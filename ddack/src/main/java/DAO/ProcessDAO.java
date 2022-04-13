package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.JDBCUtility;
import entity.CHprocess;
import entity.Product;

public class ProcessDAO {

	private ProcessDAO() {}
	private static ProcessDAO instance;
	public static ProcessDAO getInstance() {
		if(instance ==null) instance = new ProcessDAO();
		return instance;
	}
	
	private static Connection conn = null;
	
	public String makeNew_linecode() {

		conn = JDBCUtility.getConnection();
		String line_code ="";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT line_code FROM `lines` ORDER BY length(line_code) desc, line_code desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				line_code= rs.getString("line_code");
				break;
			}
			
			line_code = Integer.toString(Integer.parseInt(line_code)+1);
			
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return line_code;
	}

	public void lineinsert(String line_code, String line_name, String line_usable) {

		
		conn = JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into `lines`(line_code,line_name,line_usable) value(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, line_code);
			pstmt.setString(2, line_name);
			pstmt.setString(3, line_usable);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
			
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, null);
		}
	}

	public String makeNew_checkcode() {

		conn = JDBCUtility.getConnection();
		String check_code ="";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT check_code FROM `linecheck` ORDER BY length(check_code) desc, check_code desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				check_code= rs.getString("check_code");
				break;
			}
			
			check_code = Integer.toString(Integer.parseInt(check_code)+1);
			
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return check_code;
	}

	public void lineck_insert(String check_code, String line_code,String line_usable) {

		conn = JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		String check_content = "";
		
		if(line_usable.equals("O")) {
			check_content ="사용할 수 있다";
		}else {
			check_content ="사용할 수 없다";
		}
		
		String sql = "insert into `linecheck`(check_code,line_code,check_date,check_content) value(?,?,sysdate(),?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, check_code);
			pstmt.setString(2, line_code);
			pstmt.setString(3, check_content);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
			
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
	}

	public CHprocess getlinedetail(String line_code) {

		conn = JDBCUtility.getConnection();
		CHprocess chpro = new CHprocess();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select li.* , lich.* ,chp.* "
				+ "from `lines` li left join linecheck lich on  li.line_code = lich.line_code "
				+ "left join ch_process chp  on lich.line_code = chp.line_code  "
				+ "where li.`line_code`= ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, line_code);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				chpro.setLine_code(rs.getString("line_code"));
				chpro.setLine_name(rs.getString("line_name"));
				chpro.setLine_usable(rs.getString("line_usable"));
				chpro.setCheck_date(rs.getDate("check_date"));
				chpro.setCheck_content(rs.getString("check_content"));
			}
			
			
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return chpro;
	}
	
	
}
