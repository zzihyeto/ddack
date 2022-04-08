package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
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
			cstmt = conn.prepareCall("call material_check(?, ?)");
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
		
		
	
	
	
	
	
	
	
	
	
	
}
