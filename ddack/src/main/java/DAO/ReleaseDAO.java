package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.JDBCUtility;
import entity.Release;

public class ReleaseDAO {
	
	private ReleaseDAO() {}
	private static ReleaseDAO instance;
	public static ReleaseDAO getInstance() {
		if(instance ==null) instance = new ReleaseDAO();
		return instance;
	}
	
	private static Connection conn = null;
	
	// 출고지시
	public List<Release> re_order() {
		
		conn = JDBCUtility.getConnection();
		List<Release> Release_order = new ArrayList<>();
		Release release = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String sql ="SELECT p.p_code, mm.m_code, p.eq_code, mm.p_count "
				+ " FROM product p, memorder mm "
				+ " WHERE p.p_code=mm.p_code";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				release = new Release();
				release.setP_code(rs.getString("p_code"));
				release.setM_code(rs.getString("m_code"));
				release.setEq_code(rs.getString("eq_code"));
				release.setP_count(rs.getInt("p_count"));
				Release_order.add(release);
				
			}
			
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return Release_order;
	}
	
	//출고 된 후 수량 변화 update 시킴
	public void re_out(String p_code,int stay_cnt) {
		
		conn = JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		String sql ="update item_invent set invent_qty = ? where p_code =? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stay_cnt);
			pstmt.setString(2, p_code);
			
			int i= pstmt.executeUpdate();
			
			if(i>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
	}

	//해당되는 완제품 p_code의 현재 수량
	public int getQty(String p_code) {

		conn = JDBCUtility.getConnection();
		int now_qty = 0;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql ="select * from item_invent where p_code =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				now_qty = rs.getInt("invent_qty");	
			}
		
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못 된거같다"+e.getMessage());
			System.out.println("연결해서 뭔가 잘못?"+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return now_qty;
	}
	
	// 출고일 시간 업데이트
	public void time_update(String io_cd) {
		
		conn = JDBCUtility.getConnection();
		PreparedStatement pstmt = null;

		String sql = "update item_io set io_time= sysdate() where io_cd= ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,io_cd);
			
			int i= pstmt.executeUpdate();
			
			if(i>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
	}
	
	// io_cd
	public String getio_cd(String p_code) {

		conn = JDBCUtility.getConnection();
		String io_cd ="";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "select ii.p_code,ii.invent_code ,ii.invent_qty, st.store_code, io.io_cd "
				+ " from  item_invent ii, `storage` st, item_io io "
				+ " where ii.store_code = st.store_code "
				+ " and st.store_code=io.store_code  and p_code =? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,p_code);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				io_cd = rs.getString("io_cd");				
			}
			
		} catch(Exception e) {
			System.out.println("연결이 잘못되었습니다." + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return io_cd;
	}
	
	// memorder = p_code,m_code 가져오기
	public String getm_order(String p_code, String m_code) {
		
		String m_od ="";
		conn = db.JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM memorder WHERE p_code=? and m_code=?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			pstmt.setString(2, m_code);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m_od = rs.getString("p_code");
				m_od = rs.getString("m_code");
			}

		}catch(Exception e) {
			System.out.println("실패인가"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt,rs);
		}
		
		return m_od;
	}
	
	// 출고지시 후 해당 줄 삭제
	public void del_rel(String p_code, String m_code) {
		
		conn = db.JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		String sql="delete from memorder where p_code =? and m_code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			pstmt.setString(2, m_code);
			
			int i= pstmt.executeUpdate();
			
			if(i>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			 
		}catch(Exception e) {
			System.out.println("실패요"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt,null);
		}
		
	}
	
	// 삭제된 거 rel테이블에 insert하기
	public void get_del(String p_code, String m_code, int p_count) {
		
		conn = JDBCUtility.getConnection();
		int i =0;
		PreparedStatement pstmt = null;
		
		String sql ="insert into rel(pro_code,mem_code,pro_count,re_date) VALUES (?,?,?,sysdate())";
		
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			pstmt.setString(2, m_code);
			pstmt.setInt(3, p_count);
			
			i = pstmt.executeUpdate();			
			
			if(i>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}

		} catch (Exception e) {
			System.out.println("실패입니다요."+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
	}
	
	// 출고내역
	public List<Release> re_history() {
		
		conn = JDBCUtility.getConnection();
		List<Release> Release_history = new ArrayList<>();
		Release release = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String sql ="SELECT * FROM rel";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				release = new Release();
				release.setPro_code(rs.getString("pro_code"));
				release.setMem_code(rs.getString("mem_code"));
				release.setP_count(rs.getInt("pro_count"));
				release.setRe_date(rs.getDate("re_date"));
				Release_history.add(release);
				
			}
			
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return Release_history;
	}
	
	}
 


























