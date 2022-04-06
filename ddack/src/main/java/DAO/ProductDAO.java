package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	//mat_code..mat_name..mat_type..mat_unit..mat_count..mat_person..mat_container_code..
	//mat_life_t..c_check..clean_code
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
				bom.setClean_code(rs.getString("clean_code"));
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

	//pro_stateAction 에서 완제품골라 담은 것 
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

	public List<CHprocess> selectChpro_Q() {

		conn = JDBCUtility.getConnection();
		List<CHprocess> chpro_q_list =new ArrayList<>();
		CHprocess produc = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select qu.q_code , chp.ch_pro_code , qu.q_result "
				+ "from quality qu, ch_process chp "
				+ "where qu.ch_pro_code = chp.ch_pro_code ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				produc = new CHprocess();
				produc.setQ_code(rs.getString("q_code"));
				produc.setCh_pro_code(rs.getString("ch_pro_code"));
				produc.setQ_result(rs.getString("q_result"));
				
				chpro_q_list.add(produc);
			} 
						
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return chpro_q_list;
	}

	//chpro_q_admin.jsp에서 불량체크버튼 누르면
	//mariadb에 있는 procedure을 실행 시킨다.(procedure 만들어진상태)
	public void q_chpro_start(String q_code, String chpro_code) throws SQLException {

		conn = JDBCUtility.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt =conn.prepareCall("call q_chpro_check(?,?)");
			cstmt.setString(1,q_code);
			cstmt.setString(2,chpro_code);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			cstmt.close();
			JDBCUtility.close(conn, null, null);
		}
	}

	//line_q_admin.jsp에서 등록버튼누르면 
	//해당 라인이름 , 체크내용이 들어가게 하는 메서드
	public void in_ch_content(String line_name, String check_content) throws SQLException {
		conn = JDBCUtility.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt =conn.prepareCall("call q_line_check(?,?)");
			cstmt.setString(1,line_name);
			cstmt.setString(2,check_content);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			cstmt.close();
			JDBCUtility.close(conn, null, null);
		}
	}

	//Q_produInsertAction에 사용됨
	//해당되는 완제품에, eq_code string 들어가게 
	public void in_pro_eqcheck(String p_name,int error_cnt) throws SQLException {
		conn = JDBCUtility.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt =conn.prepareCall("call q_product_check(?,?)");
			cstmt.setString(1,p_name);
			cstmt.setInt(2,error_cnt);
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			cstmt.close();
			JDBCUtility.close(conn, null, null);
		}
	}
	//Q_produInsertAction
	//해당되는 이름의
	public void in_bom_eqcheck(String mat_name, int mat_count_update, String c_check) throws SQLException {
		conn = JDBCUtility.getConnection();
		CallableStatement cstmt = null;
		try {
			cstmt =conn.prepareCall("call q_bom_check(?,?,?)");
			cstmt.setString(1,mat_name);
			cstmt.setInt(2,mat_count_update);
			cstmt.setString(3,c_check);
			
			cstmt.execute();
			cstmt.close();
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			cstmt.close();
			JDBCUtility.close(conn, null, null);
		}
	}

	//mat_name , mat_container_code , mat_count ,  (D , mat_con_out)
	//생산지시 내리면 mat_con_out="D" 랑 mat_con_out 지정해야곘다; 
	public List<BOM> getbomcontainer(String mat_con_out, int mat_count_update) {
		conn = JDBCUtility.getConnection();
		List<BOM> bomcon_list = new ArrayList<>();
		BOM bom = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select mat_code, mat_name, mat_container_code, mat_count from bom ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bom = new BOM();
				bom.setMat_code(rs.getString("mat_code"));
				bom.setMat_name(rs.getString("mat_name"));
				bom.setMat_container_code(rs.getString("mat_container_code"));
				bom.setMat_count(rs.getInt("mat_count"));
				bom.setMat_con_out(mat_con_out);
				bom.setMat_count_update(mat_count_update);
				bomcon_list.add(bom);
			} 
						
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return bomcon_list;
	}

	public List<Product> getStorageInfo() {
		
		conn = JDBCUtility.getConnection();
		List<Product> storage_list = new ArrayList<>();
		Product bom = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select  it.invent_code , st.store_name , pr.p_name , it.invent_qty, it.invent_total, st.store_loc "
				+ " from `storage` st , item_invent it , product pr "
				+ " where st.store_code=it.store_code and pr.p_code = it.p_code ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bom = new Product();
				bom.setInvent_code(rs.getString("invent_code"));
				bom.setStore_name(rs.getString("store_name"));
				bom.setP_name(rs.getString("p_name"));
				bom.setInvent_qty(rs.getInt("invent_qty"));
				bom.setInvent_total(rs.getInt("invent_total"));
				bom.setStore_loc(rs.getString("store_loc"));
				storage_list.add(bom);
			} 
						
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return storage_list;
	}

	
	
	
	
	
}
