package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		
		String sql = "select bc.b_comp_code, bc.b_comp_name, t1.b_order_code, t1.mat_code, bc.b_comp_addr, bc.b_comp_tell "
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
				supplier.setB_comp_tell(rs.getString("b_comp_tell"));
				
				supplier_list.add(supplier);
				
			}
			
		} catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다: 거래처정보" + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return supplier_list;
	}
	
	
	
	
	
	
	
	
	
}
