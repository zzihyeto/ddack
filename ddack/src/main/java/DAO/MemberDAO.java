package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.JDBCUtility;
import entity.Member;
import entity.Post;

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
			
		}catch (Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return ok_admin;
	}

	//아이디에 해당하는 회원정보 담기
	public static Member getMember_info(String userID) {
		
		conn = JDBCUtility.getConnection();
		
		Member member1 = new Member();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select * from member where m_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				member1.setM_code(rs.getString("m_code"));
				member1.setM_type(rs.getString("m_type"));
				member1.setM_id(rs.getString("m_id"));
				member1.setM_pw(rs.getString("m_pw"));
				member1.setM_name(rs.getString("m_name"));
				member1.setM_jumin(rs.getString("m_jumin"));
				member1.setM_phone(rs.getString("m_phone"));
				member1.setM_email(rs.getString("m_email"));
				member1.setPost_code(rs.getString("post_code"));
			}
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return member1;
	}

	public static Post getPost_info(String post_code) {
		
		conn = JDBCUtility.getConnection();
		
		Post post_info = new Post();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select * from post where post_code = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post_code);
			
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				post_info.setPost_code(rs.getString("post_code"));
				post_info.setPost_num(rs.getString("post_num"));
				post_info.setDo_(rs.getString("do"));
				post_info.setCi(rs.getString("ci"));
				post_info.setGungu(rs.getString("gungu"));
				post_info.setDong(rs.getString("dong"));
				post_info.setBe_addr(rs.getString("be_addr"));
			}
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		
		return post_info;
	}

	
	
	
}
