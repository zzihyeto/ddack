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
	
	//완제품 나열하려고 다 가져오기
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
					bom.setC_check(rs.getString("c_check"));					
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
		String sql = "select p.p_code ,p.p_name , st.store_name ,inv.invent_total ,inv.invent_qty ,p.eq_code "
				+ "from product p , item_invent inv , `storage` st "
				+ "where p.p_code = inv.p_code and st.store_code=inv.store_code ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				produc = new Product();
				produc.setP_code(rs.getString("p_code"));
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
		String sql = "select li.* , lich.* ,chp.* "
				+ " from `lines` li left join linecheck lich on  li.line_code = lich.line_code "
				+ " left join ch_process chp  on lich.line_code = chp.line_code ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				produc = new CHprocess();
				produc.setLine_code(rs.getString("line_code"));
				produc.setLine_name(rs.getString("line_name"));
				produc.setLine_usable(rs.getString("line_usable"));
				if(rs.getString("ch_pro_code") !=null) {
					produc.setCh_pro_code(rs.getString("ch_pro_code"));
				}else {
					produc.setCh_pro_code("아직 미정");
				}
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
		
		String sql = "select * from memorder where m_code =  '" + ingm_code + "'";
		
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

	//마지막 mat_code() 번호 가져와서 자르고 +1 새로 추가해서 생성하기
	public String getnewmat_code() {
		conn = JDBCUtility.getConnection();
		String mat_code ="";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT mat_code FROM bom ORDER BY length(mat_code) desc, mat_code desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				mat_code =rs.getString("mat_code");
				break;
			}
			
			mat_code= mat_code.split("-")[0].substring(0,1)+ Integer.toString(Integer.parseInt(mat_code.split("-")[0].substring(1))+1)+"-1";
						
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return mat_code;
	}

	//마지막 clean_code()번호 가져와서 자르고 +1 새로 추가해서 pk값 내보내기 
	public String getclean_code() {
		conn = JDBCUtility.getConnection();
		String clean_code = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT clean_code FROM clean ORDER BY length(clean_code) desc, clean_code desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				clean_code =rs.getString("clean_code");
				break;
			}
			clean_code= clean_code.split("_")[0]+"_"+ Integer.toString(Integer.parseInt(clean_code.split("_")[1])+1);
						
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return clean_code;
	}

	public void insertBOM(String mat_code, String mat_name, String mat_type, String mat_unit, int mat_count,
			String mat_person, String mat_container_code, String mat_life_t, String clean_code) {

		conn = JDBCUtility.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql ="insert into bom(mat_code,mat_name,mat_type,mat_unit,mat_count,mat_person, "
				+ " mat_container_code,mat_life_t,clean_code) VALUES(?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mat_code);
			pstmt.setString(2, mat_name);
			pstmt.setString(3, mat_type);
			pstmt.setString(4, mat_unit);
			pstmt.setInt(5, mat_count);
			pstmt.setString(6, mat_person);
			pstmt.setString(7, mat_container_code);
			pstmt.setString(8, mat_life_t);
			pstmt.setString(9, clean_code);
			
						
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
	}

	public void insertClean(String clean_code, String c_check) {
		conn = JDBCUtility.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql ="insert into clean(clean_code,c_cycle_d,c_check) VALUES(?,sysdate(),?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clean_code);
			pstmt.setString(2, c_check);
			
						
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
	}

	public BOM getbomrow(String mat_code) {

		conn = JDBCUtility.getConnection();
		BOM bom = new BOM();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select b.*, c.* "
				+ "from bom b , clean c "
				+ "where b.clean_code = c.clean_code and b.mat_code = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mat_code);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bom.setMat_code(rs.getString("mat_code"));
				bom.setMat_name(rs.getString("mat_name"));
				bom.setMat_type(rs.getString("mat_type"));
				bom.setMat_unit(rs.getString("mat_unit"));
				bom.setMat_count(rs.getInt("mat_count"));
				bom.setMat_person(rs.getString("mat_person"));
				bom.setMat_container_code(rs.getString("mat_container_code"));
				bom.setMat_life_t(rs.getString("mat_life_t"));
				bom.setClean_code(rs.getString("clean_code"));
				bom.setC_check(rs.getString("c_check"));
				
			}
						
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return bom;
	}

	public void updateBOM( String mat_code,String mat_name, String mat_type, String mat_unit, int mat_count, 
			String mat_person, String mat_life_t) {

		conn = JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		String sql="update bom set mat_name=? ,mat_type=?, mat_unit=?,mat_count=?, mat_person=?, "
				+ " mat_life_t=? where mat_code=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mat_name);
			pstmt.setString(2, mat_type);
			pstmt.setString(3, mat_unit);
			pstmt.setInt(4, mat_count);
			pstmt.setString(5, mat_person);
			pstmt.setString(6, mat_life_t);
			pstmt.setString(7, mat_code);
			
			int regCount= pstmt.executeUpdate();
			
			if(regCount>0) {
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

	public void updateClean(String clean_code, String c_check) {

		conn = JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		String sql="update clean set c_check=?  where mat_code=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c_check);
			pstmt.setString(2, clean_code);
			
			int regCount= pstmt.executeUpdate();
			
			if(regCount>0) {
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

	public void bomdelete(String mat_code,String clean_code) throws SQLException {

		conn = JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String sql="delete from bom where mat_code=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mat_code);
			
			int regCount= pstmt.executeUpdate();
			
			if(regCount>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
			sql= "delete from clean where clean_code=?";

			pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1, clean_code);
			
			regCount=0;
			regCount= pstmt1.executeUpdate();
			
			if(regCount>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, null);
			pstmt1.close();
		}
	}

	public String getNewp_code() {

		conn = JDBCUtility.getConnection();
		String p_code ="";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT p_code FROM product ORDER BY length(p_code) desc, p_code desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				p_code =rs.getString("p_code");
				break;
			}
			
			p_code= Integer.toString(Integer.parseInt(p_code)+1);
						
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return p_code;
	}

	public String getNewinvent_code() {


		conn = JDBCUtility.getConnection();
		String invent_code ="";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT invent_code FROM item_invent ORDER BY length(invent_code) desc, invent_code desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				invent_code =rs.getString("invent_code");
				break;
			}
			invent_code= invent_code.split("_")[0]+"_"
						+Integer.toString(Integer.parseInt(invent_code.split("_")[1])+1);
						
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return invent_code;
	}

	public void producinsert(String p_code, String p_name, String eq_code, int p_kg,String p_life, int p_pay) {

		conn = JDBCUtility.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql ="insert into product(p_code,p_name,eq_code,p_kg,p_life,p_pay) "
				+ " VALUES(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			pstmt.setString(2, p_name);
			pstmt.setString(3, eq_code);
			pstmt.setInt(4, p_kg);
			pstmt.setString(5, p_life);
			pstmt.setInt(6, p_pay);
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
	}

	public void inventinsert(String invent_code, String p_code, int invent_qty,String store_code) {

		
		conn = JDBCUtility.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql ="insert into item_invent(invent_code,p_code,invent_qty,invent_total,`update`,store_code) "
				+ " VALUES(?,?,?,1000,sysdate(),?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, invent_code);
			pstmt.setString(2, p_code);
			pstmt.setInt(3, invent_qty);
			pstmt.setString(4, store_code);
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
	}

	public String getNewstore_code() {
		conn = JDBCUtility.getConnection();
		String store_code ="";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT store_code FROM `storage` ORDER BY length(store_code) desc, store_code desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				store_code =rs.getString("store_code");
				break;
			}
			store_code= store_code.split("_")[0]+"_"
						+Integer.toString(Integer.parseInt(store_code.split("_")[1])+1);
						
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return store_code;
	}

	public void insertstorage(String store_code, String store_name) {

		conn = JDBCUtility.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql ="insert into `storage`(store_code,store_name) "
				+ " VALUES(?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, store_code);
			pstmt.setString(2, store_name);
			
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
	}

	public Product getproductrow(String p_code) {

		conn = JDBCUtility.getConnection();
		Product product = new Product();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select * from product where p_code =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				product.setP_code(rs.getString("p_code"));
				product.setP_name(rs.getString("p_name"));
				product.setEq_code(rs.getString("eq_code"));
				product.setP_kg_int(rs.getInt("p_kg"));	
				product.setP_life(rs.getString("p_life"));
				product.setP_pay(rs.getString("p_pay"));
			
			}
			
						
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return product;
	}

	public void productupdate(String p_code, String p_name, String eq_code, int p_kg, String p_life,
			String p_pay) {

		conn = JDBCUtility.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql ="update product set p_name=?,eq_code=?,p_kg=?,p_life=?,p_pay=? "
				+ " where p_code=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_name);
			pstmt.setString(2, eq_code);
			pstmt.setInt(3, p_kg);
			pstmt.setString(4, p_life);
			pstmt.setString(5, p_pay);
			pstmt.setString(6, p_code);
			
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
	}

	public void producdelete(String store_code ,String p_code) throws SQLException {

		conn = JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		
		String sql= "delete from item_invent where p_code=?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			
			int regCount= pstmt.executeUpdate();
			if(regCount>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
			regCount=0;
			
			sql="delete from product where p_code=?"; 
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1, p_code);
			
			regCount= pstmt1.executeUpdate();
			if(regCount>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			regCount=0;
			
			sql ="delete from `storage` where store_code=?";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setString(1, store_code);
			
			regCount= pstmt2.executeUpdate();
			if(regCount>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		}finally {
			pstmt2.close();
			pstmt1.close();
			JDBCUtility.close(conn, pstmt, null);
			
		}
		
	}

	public String getstor_code(String p_code) {

		conn = JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String store_code = "";
		
		String sql ="select store_code from `item_invent` where p_code =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				store_code = rs.getString("store_code");
			
			}
			
						
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return store_code;
	}

	public void lineupdate(String line_code, String line_name, String line_usable, String check_date,
			String check_content) {

		
		
	}

	
	
	
}
