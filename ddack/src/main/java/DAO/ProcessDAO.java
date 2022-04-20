package DAO;

import java.sql.CallableStatement;
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

	public List<Product> getGroupProduct() {

		
		conn = JDBCUtility.getConnection();
		List<Product> sort_product  = new ArrayList<Product>();
		Product row_prodct = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from "
				+ "(select sub.p_code,sub.`dead_line`,sub. due_date , sum(p_count) "
				+ "from  (select * from memorder order by dead_line desc LIMIT 18446744073709551615) sub "
				+ "group by sub.p_code "
				+ "having dead_line > DATE_ADD(STR_TO_DATE(now(), '%Y-%m-%d '), INTERVAL -1 DAY)"
				+ "order by dead_line desc ) a , product p "
				+ "where a.p_code=p.p_code";
		//그룹바이로  p_count 더해서 회사가 정한 마감일로 정렬
		//조건은 지금현재 < 마감일 (마감일 기준으로 기간이 안지났으니깐) 
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				row_prodct = new Product();
				row_prodct.setP_name(rs.getString("p_name"));				
				row_prodct.setP_code(rs.getString("p_code"));
				row_prodct.setP_count_sum(rs.getInt("sum(p_count)"));
				row_prodct.setDead_lin(rs.getString("dead_line"));
				row_prodct.setDue_date(rs.getString("due_date"));
				sort_product.add(row_prodct);
			}
			
			
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return sort_product;
	}

	public void startinsert(String p_code, int make_count) {

		conn = JDBCUtility.getConnection();
		CallableStatement cs = null;
		
		try {
			cs= conn.prepareCall("CALL make_start(?, ? ,@new_start_od_code)");
			cs.setString(1, p_code);
			cs.setInt(2, make_count);
			
			cs.execute();
		
			cs.close();
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, null, null);
		}
		
		
	}

	public void deleteorder(String p_code) {

		conn = JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
	
		String sql = "delete from memorder where p_code = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			
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

	
	
	
}
