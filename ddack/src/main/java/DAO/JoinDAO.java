package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.JDBCUtility;

public class JoinDAO {
	
	private JoinDAO() {}
	private static JoinDAO instance;
	public static JoinDAO getInstance() {
		if(instance ==null) instance = new JoinDAO();
		return instance;

	}
	private static Connection conn = null;
	
	// 회원등록하기
	public static int registerMember(String id, String password, String name, String jumin, String phone, String email,
			String do_, String ci, String gungu, String dong, String be_addr, String post_code) {
		
		
		int regCount = 0;
		
		String m_code=null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into member(m_code,m_type,m_id,m_pw,m_name,m_jumin,m_phone,m_email,post_code) "
				+ " VALUES (?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = db.JDBCUtility.getConnection();
			pstmt = conn.prepareStatement("SELECT m_code FROM member ORDER BY length(m_code) desc, m_code desc");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				m_code = rs.getString("m_code");
				break;
			}

			conn.close();
			
			int code1 =Integer.parseInt(m_code.split("_")[1]) + 1;
			String code2 = Integer.toString(code1);
			m_code = m_code.split("_")[0]+ "_"+ code2;		
			
			conn = db.JDBCUtility.getConnection();
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1, m_code);
			pstmt1.setString(2, "회원");
			pstmt1.setString(3, id);			
			pstmt1.setString(4, password);
			pstmt1.setString(5, name);
			pstmt1.setString(6, jumin);
			pstmt1.setString(7, phone);
			pstmt1.setString(8, email);
			pstmt1.setString(9, post_code);
			regCount = pstmt1.executeUpdate();
			
			if(regCount>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			JDBCUtility.close(null, pstmt1, null);
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return regCount;
	}

}