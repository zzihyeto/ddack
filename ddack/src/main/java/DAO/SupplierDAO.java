package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.JDBCUtility;
import entity.Supplier;

public class SupplierDAO {

	
	private SupplierDAO() {}
	private static SupplierDAO supplierDAO;
	public static SupplierDAO getInstance() {
		
		if(supplierDAO == null) supplierDAO = new SupplierDAO();
		return supplierDAO;	
	}
	
	Connection conn = null;

	/* -----------------------------------------*/
	
	// DB에서 supplier(거래처)정보 가져오기
	public List<Supplier> SupplierInfo() {

		conn = JDBCUtility.getConnection();
		
		List<Supplier> supplier_list = new ArrayList<Supplier>();		
		
		Supplier supplier = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		
		String sql = "select bc.b_comp_code, bc.b_comp_name, t1.b_order_code, t1.mat_code, bc.b_comp_addr, bc.b_comp_tel "
					+ " from buycompany bc, (select b.mat_code, bco.b_order_code , bco.b_comp_code from buycomp_order bco, bom b "
					+ " where bco.b_order_code = b.b_order_code) t1 where t1.b_comp_code = bc.b_comp_code ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				supplier = new Supplier();
				supplier.setB_comp_code(rs.getString("b_comp_code"));
				supplier.setB_comp_name(rs.getString("b_comp_name"));
				supplier.setB_order_code(rs.getString("b_order_code"));
				supplier.setMat_code(rs.getString("mat_code"));
				supplier.setB_comp_addr(rs.getString("b_comp_addr"));
				supplier.setB_comp_tel(rs.getString("b_comp_tel"));
				
				supplier_list.add(supplier);
				
			}
			
		} catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다: 거래처정보" + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return supplier_list;
	}

	// BOM에서 원재료 재고체크하기
	// supplier_admin.jsp에서 발주지시 누름
	// mariadb에 있는 프로시저 발동됨.
	public void CheckStock(String mat_code, int mat_count) throws SQLException {
		
		conn = JDBCUtility.getConnection();
		
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.prepareCall("call CheckStock(?, ?)");
			cstmt.setString(1, mat_code);
			cstmt.setInt(2, mat_count);
			cstmt.execute();
			cstmt.close();
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			cstmt.close();
			JDBCUtility.close(conn, null, null);
		}
	}

	// 신규거래처등록
	public int supRegist(String b_comp_code, String b_comp_name, 
			String b_comp_addr, String b_comp_tel, String mat_code) {
		
		conn = JDBCUtility.getConnection();

		int supRegist = 0;
		int supregCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "INSERT INTO buycompany(b_comp_code, b_comp_name, b_comp_addr, b_comp_tel, mat_code) "
					+ "values(concat('발주회사코드_', nextval(sq_b_comp_code)), ?, ?, ?, ?)";
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_comp_name);
			pstmt.setString(2, b_comp_addr);
			pstmt.setString(3, b_comp_tel);
			pstmt.setString(4, mat_code);
			supregCount = pstmt.executeUpdate();
			
			if(supregCount >0) {
				JDBCUtility.commit(conn);
			} else {
				JDBCUtility.rollback(conn);
			}
	
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		return supRegist;
	}

	//발주서 등록하기
	public int checkm(String b_order_code, String b_comp_code, String mat_order_d,
			 int mat_count, String exp_in_d, String tru_in_d, String quality) {
		
		conn = JDBCUtility.getConnection();

		int checkm = 0;
		int mat_c = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "insert into buycomp_order(b_order_code, b_comp_code,mat_order_d, mat_count, exp_in_d, tru_in_d, quality)"
					+ " values(concat('발주코드_', nextval(sq_b_order_code)), ?, ?, ?, ?, ?, ?) ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_comp_code);
			pstmt.setString(2, mat_order_d);
			pstmt.setInt(3, mat_count);
			pstmt.setString(4, exp_in_d);
			pstmt.setString(5, tru_in_d);
			pstmt.setString(6, quality);
			mat_c = pstmt.executeUpdate();
			
			if (mat_c >0)	{
				JDBCUtility.commit(conn);
			} else {
				JDBCUtility.rollback(conn);
			}
		}  catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
		return checkm;
	}	
	
	
}
