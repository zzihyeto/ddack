package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.JDBCUtility;
import entity.Product;

public class ProductDAO {

	private ProductDAO() {}
	private static ProductDAO instance;
	public static ProductDAO getInstance() {
		if(instance ==null) instance = new ProductDAO();
		return instance;
	}
	
	private static Connection conn = null;
	
	public List<Product> getProduct() {
		conn = JDBCUtility.getConnection();
		List<Product> pro_list = new ArrayList<>();
		Product product = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "select * from product";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				product = new Product();
				product.setP_code(rs.getString("p_code"));
				product.setP_name(rs.getString("p_name"));
				product.setEq_code(rs.getString("eq_code"));
				product.setP_kg(rs.getString("p_kg"));
				product.setP_life(rs.getString("p_life"));
				product.setP_pay(rs.getString("p_pay"));
				pro_list.add(product);
			}
			
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return pro_list;
	}
	
	
}
