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

	/* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */	

	// DB review리스트 전체 가져오기
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
	
	// 2. 전체에서 구간으로 리스트 가져오기 
	public List<ReviewBean> selectReviewList(int page, int limit) {
		conn = JDBCUtility.getConnection();
		List<ReviewBean> list = new ArrayList<ReviewBean>();
		ReviewBean review = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from (select rownum() rn, t1.* "
				+ "				from (select rv.re_code, p.p_name, rv.m_id, rv.p_review, rv.review_date, p.p_code"
				+ "						from product p, review rv "
				+ "						where p.p_code = rv.p_code "
				+ "				order by rv.review_date DESC )t1 )t2 limit ? , "+ limit;
				
		int startRow = (page - 1) * limit;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				review = new ReviewBean();
				review.setR_num(rs.getInt("rn"));
				review.setRe_code(rs.getString("re_code")); //리뷰코드
				review.setP_name(rs.getString("p_name")); //제품명
				review.setM_id(rs.getString("m_id")); // 작성자
				review.setP_review(rs.getString("p_review")); // 리뷰글
				review.setReview_date(rs.getDate("review_date")); //작성일
				review.setP_code(rs.getString("p_code"));
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
		
		
		String sql =  "select count(*) from (select rownum() rn, t1.* "
				+ " from (select rv.re_code, p.p_name, rv.m_id, rv.p_review, rv.review_date "
				+ " from product p, review rv where p.p_code = rv.p_code and " + field+ " like ? "
				+ " order by rv.review_date desc) t1 "
				+ " ) t2 ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ query +"%");
		
			rs = pstmt.executeQuery();
			rs.next();
			
			count = rs.getInt("count(*)");
			
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
		List<ReviewBean> search_list = new ArrayList<ReviewBean>();

		if (field.equals("total")) {
			field = "m_id";
		}
	 
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from (select rownum() rn, t1.* "
				+ "	from (select rv.re_code, p.p_name, rv.m_id, rv.p_review, rv.review_date "
				+ "	from product p, review rv where p.p_code = rv.p_code and "+ field +" like ? "
				+ "	order by rv.review_date DESC )t1 "
				+ " )t2 limit ?,? ";
		
		int start = 1 + (page-1) * 10 ;
		int end = 10+start;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + query + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end );
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String re_code = rs.getString("re_code");//제품코드
				String p_name = rs.getString("p_name"); // 제품명
				String m_id = rs.getString("m_id");//작성자
				String p_review = rs.getNString("p_review");
				Date review_date = rs.getDate("review_date");
				String p_code = rs.getString("p_code");
				
				ReviewBean search_review = new ReviewBean(re_code, p_name, m_id, p_review, review_date, p_code);
				search_review.setR_num(rs.getInt("rn"));
				
				search_list.add(search_review);
			}
			
		}catch (Exception e) {
			System.out.println("뭔가 잘못됐습니다."+e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return search_list;
	}


	// 리뷰글 등록 
	public boolean writeReview(String m_id, String p_code, String p_review) {
		conn = JDBCUtility.getConnection();
	
		boolean writeRegist = false;
		int regist = 0;
		
		PreparedStatement pstmt = null;
		
		String sql  = "insert into review "
					+ " values(concat('리뷰_', nextval(review_re_code)), ?, ? , ?, sysdate())";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, p_code);
			pstmt.setString(3, p_review);
			
			regist = pstmt.executeUpdate();
			
			System.out.println("==regist=>" + regist);

			if(regist >0) {
				JDBCUtility.commit(conn);
				writeRegist = true;
			} else {
				JDBCUtility.rollback(conn);
			}
			
		} catch (Exception e) {
			System.out.println("리뷰글이 등록되지 못했습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
		return writeRegist;
	}
	
	//p_name 으로 p_code뽑아내도록
	public String getp_name(String p_name) { //p_code통해서 p_name가져와야함.

		conn = JDBCUtility.getConnection();
		
		String p_code = "";
		
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String sql="select p_code from "
				+ " (select a.p_name, b.* from product a, memorder b "
				+ " where a.p_code = b.p_code order by order_date desc) t1 "
				+ " where p_name = ? ";
		
		try {			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_name);
			
			rs = pstmt.executeQuery();
			rs.next();
			p_code = rs.getString("p_code");
			
			
		} catch (Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return p_code;
	}


	// 리뷰 상세페이지에 들어갈 내용을 가져와야한다.
	public ReviewBean getR_N(String p_code, String m_id) {
	
		conn = JDBCUtility.getConnection();
		
		ReviewBean review = new ReviewBean();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select p.p_name, r.p_review "
				+ " from review r, product p"
				+ " where p.p_code=r.p_code "
				+ " and r.m_id = ? and p.p_code= ? ";

		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, p_code);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				review.setP_name(rs.getString("p_name"));
				review.setP_review(rs.getString("p_review"));
				System.out.println("===review====" + review);
			}
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return review;
		
	}
	
	
	
	
	
}