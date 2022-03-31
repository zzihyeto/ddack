package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.JDBCUtility;
import entity.BOM;
import entity.CHprocess;
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

	public List<BOM> selectBOM() {

		List<BOM> bom_list = new ArrayList<>();

		conn = JDBCUtility.getConnection();
		BOM bom = null;

		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "select b.* ,c.c_check from bom b, clean c where b.clean_code = c.clean_code";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bom = new BOM();
				bom.setMat_code(rs.getString("mat_code"));
				bom.setMat_name(rs.getString("mat_name"));
				bom.setMat_type(rs.getString("mat_type"));
				bom.setMat_unit(rs.getString("mat_unit"));
				bom.setMat_count(rs.getInt("mat_count"));
				bom.setMat_person(rs.getString("mat_person"));
				bom.setMat_container_code(rs.getString("mat_container_code"));
				if(rs.getString("mat_life_t")!=null) {
					bom.setMat_life_t(rs.getString("mat_life_t"));					
				}
				if(rs.getString("c_check")!=null) {
					bom.setClean_code(rs.getString("c_check"));					
				}
				
				bom_list.add(bom);
			}
			
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return bom_list;
	}

	public List<Product> selectProducState() {
		conn = JDBCUtility.getConnection();
		List<Product> pro_state_list =new ArrayList<>();
		Product produc = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "select p.p_name , st.store_name ,inv.invent_total ,inv.invent_qty ,p.eq_code "
				+ "from product p , item_invent inv , `storage` st "
				+ "where p.p_code = inv.p_code and st.store_code=inv.store_code ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				produc = new Product();
				produc.setP_name(rs.getString("p_name"));
				produc.setInvent_storname(rs.getString("store_name"));
				produc.setInvent_total(rs.getInt("invent_total"));
				produc.setInvent_qty(rs.getInt("invent_qty"));
				produc.setEq_code(rs.getString("eq_code"));
				
				pro_state_list.add(produc);
			}
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return pro_state_list;
	}

	public List<CHprocess> selectLineState() {

		conn = JDBCUtility.getConnection();
		List<CHprocess> line_state_list =new ArrayList<>();
		CHprocess produc = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "select li.line_name , li.line_usable , chp.ch_pro_code , lich.check_date, lich.check_content "
				+ "from `lines` li , ch_process chp , linecheck lich "
				+ "where li.line_code = chp.line_code and lich.line_code = li.line_code ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				produc = new CHprocess();
				produc.setLine_name(rs.getString("line_name"));
				produc.setLine_usable(rs.getString("line_usable"));
				produc.setCh_pro_code(rs.getString("ch_pro_code"));
				produc.setCheck_date(rs.getDate("check_date"));
				produc.setCheck_content(rs.getString("check_content"));
				line_state_list.add(produc);
			}
		}catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return line_state_list;
		
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
