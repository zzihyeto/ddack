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
		
		
		String sql = "select * from buycompany";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				supplier = new Supplier();
				supplier.setB_comp_code(rs.getString("b_comp_code"));
				supplier.setB_comp_name(rs.getString("b_comp_name"));
				supplier.setMat_code(rs.getString("mat_code"));
				supplier.setB_comp_addr(rs.getString("b_comp_addr"));
				supplier.setB_comp_tel(rs.getString("b_comp_tel"));
				supplier.setB_email(rs.getString("b_email"));
				
				supplier_list.add(supplier);
				
			}
			
		} catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다: 거래처정보" + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return supplier_list;
	}

	// 신규거래처등록 하기
	// 자동으로 거래처 코드 부여됨..
	public int supRegist(String b_comp_code, String b_comp_name, String b_comp_addr, String b_comp_tel, String mat_code) {
		
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
			
			if(supregCount > 0) {
				JDBCUtility.commit(conn);
			} else {
				JDBCUtility.rollback(conn);
			}
	
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		return supregCount;
	}

	//발주서 등록하기
	public void insertorder(String b_comp_code, int mat_count, String mat_code) {
		
		conn = JDBCUtility.getConnection();

		int mat_c = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "insert into buycomp_order(b_order_code, b_comp_code, mat_order_d, mat_count, mat_code)"
					+ " values(concat('발주코드_', nextval(sq_b_order_code)), ?, sysdate() , ?, ?) ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_comp_code);
			pstmt.setInt(2, mat_count);
			pstmt.setString(3, mat_code);
			mat_c = pstmt.executeUpdate();
			
			if (mat_c > 0)	{
				JDBCUtility.commit(conn);
			} else {
				JDBCUtility.rollback(conn);
			}
		}  catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
	}

	//발주된 정보 가져오기
	public List<Supplier> supplierdetail() {
		
		conn = JDBCUtility.getConnection();
		
		List<Supplier> supdetail_list = new ArrayList<Supplier>();		
		
		Supplier supplier = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from buycomp_order order by length(b_order_code) desc, b_order_code desc ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				supplier = new Supplier();
				supplier.setB_order_code(rs.getString("b_order_code"));
				supplier.setB_comp_code(rs.getString("b_comp_code"));
				supplier.setMat_order_d(rs.getDate("mat_order_d"));
				supplier.setMat_count(rs.getInt("mat_count"));
				supplier.setExp_in_d(rs.getString("exp_in_d"));
				supplier.setTru_in_d(rs.getString("tru_in_d"));
				supplier.setQuality(rs.getString("quality"));
				
				supdetail_list.add(supplier);	
			}
		} catch (Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
		return supdetail_list ;
	}

	//원재료 주문 코드에 따라 정보가져오기
	public Supplier getorderCode(String b_order_code) {
	
		conn = JDBCUtility.getConnection();

		Supplier supplier = new Supplier();
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from buycomp_order where b_order_code = ?";
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_order_code);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				supplier.setB_order_code(rs.getString("b_order_code"));
				supplier.setB_comp_code(rs.getString("b_comp_code"));
				supplier.setMat_order_d(rs.getDate("mat_order_d"));
				supplier.setMat_count(rs.getInt("mat_count"));
				supplier.setExp_in_d(rs.getString("exp_in_d"));
				supplier.setTru_in_d(rs.getString("tru_in_d"));
				supplier.setQuality(rs.getString("quality"));	
			}
						
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다." + e.getMessage());
			
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return supplier;
	}

	// 발주관리에 예상일자, 실제일자, 퀄리티 업데이트 하기	
	public void updatePurs(String b_order_code, String exp_in_d, String tru_in_d, String quality) {

		conn = JDBCUtility.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql = " update buycomp_order set " 
					+ " exp_in_d = ?, tru_in_d = ?, quality = ? where b_order_code = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, exp_in_d);
			pstmt.setString(2, tru_in_d);
			pstmt.setString(3, quality);
			pstmt.setString(4, b_order_code);
			
			int pur = pstmt.executeUpdate();
			
			if(pur > 0) {
				JDBCUtility.commit(conn);
			} else {			
				JDBCUtility.rollback(conn);
			}
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
	}
	
	// 재료코드 -> BOM 수량확인
	public Integer choiceMC(String mat_code) {

		conn = JDBCUtility.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Integer resultCount = null; //현재 수량
		Integer need_cnt = null;
		
		String sql = "select mat_count from bom where mat_code =? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mat_code);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				resultCount = rs.getInt("mat_count");
			}
			
			if(mat_code.equals("m3-1")) {
				if(resultCount < 250) {
					need_cnt = 250 - resultCount;
				} else {
					need_cnt = 0;
				}
			} else {
				if(resultCount < 1000) {
					need_cnt = 1000 - resultCount;
				} else {
					need_cnt = 0; 
				}
			}
			
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
		return need_cnt;
	}
	
	// pur_choice_form(발주서).jsp에 버튼 누르면 주문가능수량 알려주기
	public List<String> getmatcode() {
		
		List<String> matcodes = new ArrayList<>();
		
		String matcode = null;
		
		conn = JDBCUtility.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select mat_code from bom ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				matcode = rs.getString("mat_code");
				matcodes.add(matcode);
			}
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		return matcodes;
	}

	//회사 코드 가져오기
	public List<String> getb_comp_code() {
		
		List<String> b_comp_codes = new ArrayList<>();
		
		String b_comp_code = null;
		
		conn = JDBCUtility.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select b_comp_code from buycompany ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				b_comp_code = rs.getString("b_comp_code");
				b_comp_codes.add(b_comp_code);
			}
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		return b_comp_codes;
	}
	
	//mat_code 가져오기
	public String getM_code(String b_order_code) {

		String mat_code = "";
		
		conn = JDBCUtility.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select b.mat_code "
				+ " from bom b, buycomp_order bo "
				+ " where b.b_order_code=bo.b_order_code and bo.b_order_code= ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_order_code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mat_code = rs.getString("mat_code");
			}
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		return mat_code;
	}
	
	//bom mat_count 현재 수량 가져오기 
	public int getInvent_qty(String mat_code) {

		conn = JDBCUtility.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		int current = 0;
		
		String sql = "select mat_count from bom where mat_code=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mat_code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				current = rs.getInt("mat_count");
			}
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		} finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
		return current;
	}

	//bom mat_count 꺼 수량 더해준거  update
	public void calcu_qty(int new_mat_cnt, String mat_code) {
	
		conn = JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update bom set mat_count = ? where mat_code =?";
		
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, new_mat_cnt);
		pstmt.setString(2, mat_code);
		
		int pur = pstmt.executeUpdate();
		
		if(pur > 0) {
			JDBCUtility.commit(conn);
		} else {			
			JDBCUtility.rollback(conn);
		}
	} catch(Exception e) {
		System.out.println("등록되지 못했습니다." + e.getMessage());
	} finally {
		JDBCUtility.close(conn, pstmt, null);
	}
		
	}

	// mat_code  가져오기
	public String getM_Code(String string) {

		return null;
	}

	
}

