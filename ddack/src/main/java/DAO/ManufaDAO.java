package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.JDBCUtility;
import entity.Production_manage;

public class ManufaDAO {
	
	
	private ManufaDAO() {};
	private static ManufaDAO manufaDAO;
	public static ManufaDAO getInstance() {
		
		
		if(manufaDAO == null) manufaDAO = new ManufaDAO();
	
		return manufaDAO;
		
	}
	
	Connection conn = null;

	// DB에서 StartOrder 테이블 불러오기
	public List<Production_manage> getStartOrder() {
		
		conn = JDBCUtility.getConnection();
		
		List<Production_manage> production_order = new ArrayList<Production_manage>();
		
		Production_manage production_manage = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from startorder ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				production_manage = new Production_manage();
				production_manage.setStart_od_code(rs.getString("Start_od_code"));
				production_manage.setTotal_date(rs.getInt("total_date"));
				production_manage.setBegin_date(rs.getDate("begin_date"));
				production_manage.setEnd_date(rs.getDate("end_date"));
				
				production_order.add(production_manage);
				
			}
			
		}  catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다" + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return production_order;
	}
	
	//ChProcess 테이블 가져오기 왜냐면 생산관리- 공정관리
	public List<Production_manage> getCHp() {

		conn = JDBCUtility.getConnection();
		
		List<Production_manage> process_manage = new ArrayList<Production_manage>();

		Production_manage process = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from ch_process ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				process = new Production_manage();
				process.setCh_pro_code(rs.getString("ch_pro_code"));
				process.setStart_od_code(rs.getString("start_od_code"));
				process.setP_code(rs.getString("p_code"));
				process.setMat_code1(rs.getString("mat_code1"));
				process.setMat_code2(rs.getString("mat_code2"));
				process.setMat_code3(rs.getString("mat_code3"));
				process.setMat_code4(rs.getString("mat_code4"));
				process.setCook_code(rs.getString("cook_code"));
				process.setMk_time(rs.getDate("mk_time"));
				process.setMk_ps_code(rs.getString("mk_ps_code"));
				process.setLine_code(rs.getString("line_code"));
				process.setClean_code(rs.getString("clean_code"));
				process.setQ_code(rs.getString("q_code"));
				
				process_manage.add(process);
			}
		} catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다" + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
	
		return process_manage;
	}

	// startorder 테이블에 start_od_code별 end_date 넣어주기
	public void ChangeEndDate(String start_od_code,int total_date,String mk_time) {

		conn = JDBCUtility.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql = "update startorder set total_date =? ,begin_date= ? , end_date = sysdate() where start_od_code = ?";
		
		try {
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, total_date);
			pstmt.setString(2,  mk_time);
			pstmt.setString(3, start_od_code);
			
			int regCount = pstmt.executeUpdate();
			
			if(regCount>0) {
				JDBCUtility.commit(conn);
			} else {			
				JDBCUtility.rollback(conn);
			}
		} catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다" + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
	}

	public void updateErrcnt(int error_cnt,String b_order_code) {

		conn = JDBCUtility.getConnection();
		
		PreparedStatement pstmt = null;
		String sql = "update buycomp_order set sup_error_cnt =? where b_order_code = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, error_cnt);
			pstmt.setString(2, b_order_code);
			
			int regCount = pstmt.executeUpdate();
			
			if(regCount>0) {
				JDBCUtility.commit(conn);
			} else {			
				JDBCUtility.rollback(conn);
			}
			
		} catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다" + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
	}
	
	

	
	
}
