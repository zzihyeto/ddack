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
	
	//완제품 나열하려고 다 가져오
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
	
	
	// 구매내역확인하기(리뷰작성 위해서는 구매내역이 있어야 작성이 가능함.)
	// 구매내역이 있는가 없는가? ingm_id 있냐 없냐! 엠코드(꾸매이력확인)가 있다면 엠아이디가 나온다.
	// m_id를 넣으면 buy_check의 불리언값이 나오겠죠?
	public boolean buycheck(String ingm_code) {
		
		conn = JDBCUtility.getConnection();
	
		boolean buy_check = false; //구매이력 확인
				
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from memorder where m_code =  '" + ingm_code+"'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
					buy_check = true;
			} 
						
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return buy_check;
	}


	
	
}
