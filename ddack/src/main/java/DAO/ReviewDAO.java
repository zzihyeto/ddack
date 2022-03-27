package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.JDBCUtility;
import entity.ReviewBean;

public class ReviewDAO {

	private ReviewDAO() {}
	private static ReviewDAO reviewDAO;
	public static ReviewDAO getInstance() {
		if(reviewDAO == null) reviewDAO = new ReviewDAO();
		return reviewDAO;
	}
	
	Connection conn = null;  
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	/* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */	

	// DB review리스트 전체가져오기 = 상세리스트 가져오기
	public List<ReviewBean> selectReview() {
		conn = JDBCUtility.getConnection();
		List<ReviewBean> review_list = new ArrayList<>();
		
		ReviewBean review = null;
	
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String sql = "select rownum() rn, t1.* "
				+ "	from (select rv.re_code, p.p_name, rv.m_id, rv.p_review, rv.review_date"
				+ "	from product p, review rv"
				+ "	where p.p_code = rv.p_code"
				+ "	order by rv.review_date asc) t1 order by rn DESC";
				
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				review = new ReviewBean();
				review.setRe_code(rs.getString("re_code"));
				review.setP_name(rs.getString("p_name"));
				review.setM_id(rs.getString("m_id"));
				review.setP_review(rs.getString("p_review"));
				review.setReview_date(rs.getDate("review_date"));
			
				review_list.add(review);
			}
			
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다_ 그건바로: 상세리스트" + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return review_list;
	}
	
	// 전체 리스트
	// 1. 전체 리뷰리스트 갯수
	public int selectListCount() {
		
		conn = JDBCUtility.getConnection(); 
		
		int listCount = 0; // 리스트갯수의 변수 초기화
		
		PreparedStatement pstmt = null; //준비상태를 pstmt로 변수설정하고 준비만, 초기화는 아직 초기화는 try이후부터
		ResultSet rs = null;
		
		String sql = "select count(*) from review";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) { 
				listCount = rs.getInt(1);  // 1행 110건확인
			}
		} catch (Exception e) {
			System.out.println("뭔가 잘못됨_전체리뷰리스트갯수" + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return listCount;
	}
	
	// 2. 전체리스트 가져오기 
	public List<ReviewBean> selectReviewList(int page, int limit) {
		conn = JDBCUtility.getConnection();
		List<ReviewBean> list = new ArrayList<ReviewBean>();
		ReviewBean review = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		/* String sql = "select * from review"; */
		/*String sql ="select * from (select rownum() rn, t1.* "
				    + "from (select rv.re_code, p.p_name, rv.m_id, rv.p_review, rv.review_date "
				    + "from product p, review rv where p.p_code = rv.p_code"
					+ "order by rv.review_date desc) t1 "
					+ "where rn between ? and ? ";*/
		
		int start = 1 + (page-1) * 10; 
		int end = limit + start;
		
		String sql =/* "select * from (select * from (select rownum() rn, t1.*"
					+"from (select rv.re_code, p.p_name, rv.m_id, rv.p_review, rv.review_date"
					+"from product p, review rv where p.p_code = rv.p_code order by"
					+"rv.review_date asc) t1) t1 order by rn desc) t2 where rn between" + start + "and"+ end;*/
				
				"select * from (select rownum() rn, t1.* "
				+ "	from (select rv.re_code, p.p_name, rv.m_id, rv.p_review, rv.review_date "
				+ "	from product p, review rv"
				+ "	where p.p_code = rv.p_code"
				+ "	order by rv.review_date asc)t1 order by rn DESC) t2 where rn between" + start + "and" + end;
				

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				review = new ReviewBean();
				review.setRe_code(rs.getString("re_code")); //리뷰코드
				review.setP_name(rs.getString("p_name")); //제품명
				review.setM_id(rs.getString("m_id")); // 작성자
				review.setP_review(rs.getString("p_review")); // 리뷰글
				review.setReview_date(rs.getDate("review_date")); //작성일
				list.add(review);
			}
		} catch (Exception e) {
			System.out.println("연결에서 뭔가 잘못된거같다_10행씩가져오기_" + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}	
			return list;	
	}
	
	//검색
	//1.검색해서 총갯수
	public int getSearchCount(String field, String query) {
		
		conn = JDBCUtility.getConnection();
		int count = 0;
		
		if(field.equals("total")) {
			field = "m_id";
		}
		
		String sql =  "select * from (select rownum() rn, t1.* "
			    + "from (select rv.re_code, p.p_name, rv.m_id, rv.p_review, rv.review_date "
			    + "from product p, review rv where p.p_code = rv.p_code) t1)"
				+ "where" + field + "like ? order by rv.review_date desc) t2)";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ query +"%");
		
			rs = pstmt.executeQuery();
			rs.next();
			
			count = rs.getInt("count");
			
		} catch (Exception e) {
			System.out.println("뭔가 잘못됐습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return count;
	}

	//2.검색해서 리스트 가져오기 
	public List<ReviewBean> searchlist(String field, String query, int page) {
	
		conn = JDBCUtility.getConnection(); 
		List<ReviewBean> review = new ArrayList<ReviewBean>();

		if (field.equals("total")) {
			field = "m_id";
		}
	 
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from"
				+ " (select rownum() rn, t1.* from"
				+ " (select rv.re_code, p.p_name, rv.m_id, rv.p_review, rv.review_date "
			    + "from product p, review rv where p.p_code = rv.p_code) t1)"
				+ "where" + field + "like ? order by rv.review_date desc) t2)"
				+ "where rn between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + query + "%");
			pstmt.setInt(2, 1 + (page-1) * 10);
			pstmt.setInt(3, page * 10);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String re_code = rs.getString("re_code");//제품코드
				String p_name = rs.getString("p_name"); // 제품명
				String m_id = rs.getString("m_id");//작성자
				String p_review = rs.getNString("p_review");
				Date review_date = rs.getDate("review_date");
				ReviewBean re = new ReviewBean(re_code, p_name, m_id, p_review, review_date);
				review.add(re);
			}
			
		}catch (Exception e) {
			System.out.println("뭔가 잘못됐습니다."+e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return review;
	}
	
	// 글쓰기
	public int insertReview(ReviewBean review) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "insert into review (re_code, m_id, p_code, p_review, review_date)"     
				   + "       values(?,?,?,?,?)";
		int insertCount = 0;
		int num = 0;
		
		try {
			pstmt = conn.prepareStatement("select max(re_code) from review");
			rs = pstmt.executeQuery();
			if(rs.next()) num = rs.getInt(1) + 1; else num = 1;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getRe_code());
			pstmt.setString(2, review.getM_id());
			pstmt.setString(3, review.getP_name());
			pstmt.setString(4, review.getP_review());
			pstmt.setDate(5, (Date) review.getReview_date());
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시글등록실패!!!" + e.getMessage());
		} finally {
			JDBCUtility.close(null, pstmt, rs); // // JDBCUtility.close()
		}		
		return insertCount;
	}

	
	
	
	
	
}