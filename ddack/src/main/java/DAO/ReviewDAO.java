package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.JDBCUtility;
import entity.Product;
import entity.ReviewBean;

public class ReviewDAO {

	private ReviewDAO() {}
	private static ReviewDAO reviewDAO;
	public static ReviewDAO getInstance() {
		if(reviewDAO == null) reviewDAO = new ReviewDAO();
		return reviewDAO;
	}
	
	private static Connection conn = null;

	/* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */	
	
	// 글쓰기
	public int insertReview(ReviewBean review) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into review (re_code, m_id, p_code, p_review, review_date) "     
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
			pstmt.setString(3, review.getP_code());
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
	
	//DB에서 가져오기
	public List<ReviewBean> selectReview() {
		
		conn = JDBCUtility.getConnection();
		
		List<ReviewBean> review_list = new ArrayList<>();
		ReviewBean review = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String sql = "select * from review";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				review = new ReviewBean();
				review.setRe_code(rs.getString("re_code"));
				review.setM_id(rs.getString("m_id"));
				review.setP_code(rs.getString("p_code"));
				review.setP_review(rs.getString("p_review"));
				review.setReview_date(rs.getDate("review_date"));
			
				review_list.add(review);
			}
			
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		
		return review_list;
	}
	
	

}