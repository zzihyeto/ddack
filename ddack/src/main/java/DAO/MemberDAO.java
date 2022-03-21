package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.JDBCUtility;

public class MemberDAO {
	
	private MemberDAO() {}
	private static MemberDAO instance;
	public static MemberDAO getInstance() {
		if(instance ==null) instance = new MemberDAO();
		return instance;
	}
	
	private static Connection conn = null;
	
	//회원 중에 아이디가 있나 ? 비번이 일치 하나 ?
	public static boolean isLogin(String userID, String inputPassword) {

		conn = JDBCUtility.getConnection();
		boolean ok_id_pw = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select m_id, m_pw from member where m_id= '"+ userID +"' ";
		//띄어쓰기 조심 한칸도값으로 취급한다 너무 중요 ㅠㅠㅠ
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				if(inputPassword.equals(rs.getString("m_pw"))) ok_id_pw = true;
			}
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());
			System.out.println("아이디가 일치 하지 않습니다.");
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return ok_id_pw;
	}

	//회원중에 admin인가?
	public static boolean isAdmin(String userID, String inputPassword) {
		conn = JDBCUtility.getConnection();
		boolean ok_admin = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select m_id, m_pw from member where m_type = '관리자' ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				if(userID.equals(rs.getString("m_id"))) {
					if (inputPassword.equals(rs.getString("m_pw"))) ok_admin = true;
				}
			}
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		
		return ok_admin;
	}
	
	
}
