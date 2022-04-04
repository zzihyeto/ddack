package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import db.JDBCUtility;
import entity.MemOrder;
import entity.Member;
import entity.Post;
import entity.Product;

public class MemberDAO {
	
	private MemberDAO() {}
	private static MemberDAO instance;
	public static MemberDAO getInstance() {
		if(instance ==null) instance = new MemberDAO();
		return instance;
	}
	
	private static Connection conn = null;
	
	//회원 중에 아이디가 있나 ? 비번이 일치 하나 ?
	public static boolean isLogin(String userID, String inputPassword) {
		conn = JDBCUtility.getConnection();
		
		boolean ok_id_pw = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select m_id, m_pw from member where m_id= '"+ userID +"' ";
		//띄어쓰기 조심 한칸도값으로 취급한다 너무 중요 ㅠㅠㅠ
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				if(inputPassword.equals(rs.getString("m_pw"))) ok_id_pw = true;
			}
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());
			System.out.println("아이디가 일치 하지 않습니다.");
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return ok_id_pw;
	}

	//회원중에 admin인가?
	public static boolean isAdmin(String userID, String inputPassword) {
		
		conn = JDBCUtility.getConnection();
		
		boolean ok_admin = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select m_id, m_pw from member where m_type = '관리자' ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				if(userID.equals(rs.getString("m_id"))) {
					if (inputPassword.equals(rs.getString("m_pw"))) ok_admin = true;
				}
			}
			
		}catch (Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return ok_admin;
	}

	//아이디에 해당하는 회원정보 담기
	public static Member getMember_info(String userID) {
		
		conn = JDBCUtility.getConnection();
		
		Member member1 = new Member();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select * from member where m_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				member1.setM_code(rs.getString("m_code"));
				member1.setM_type(rs.getString("m_type"));
				member1.setM_id(rs.getString("m_id"));
				member1.setM_pw(rs.getString("m_pw"));
				member1.setM_name(rs.getString("m_name"));
				member1.setM_jumin(rs.getString("m_jumin"));
				member1.setM_phone(rs.getString("m_phone"));
				member1.setM_email(rs.getString("m_email"));
				member1.setPost_code(rs.getString("post_code"));
			}
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return member1;
	}

	public static Post getPost_info(String post_code) {
		
		conn = JDBCUtility.getConnection();
		
		Post post_info = new Post();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select * from post where post_code = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post_code);
			
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				post_info.setPost_code(rs.getString("post_code"));
				post_info.setPost_num(rs.getString("post_num"));
				post_info.setDo_(rs.getString("do"));
				post_info.setCi(rs.getString("ci"));
				post_info.setGungu(rs.getString("gungu"));
				post_info.setDong(rs.getString("dong"));
				post_info.setBe_addr(rs.getString("be_addr"));
			}
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		
		return post_info;
	}

	public static String[] getPost_num_code() {

		conn = JDBCUtility.getConnection();
		
		String[] post = new String[2];
	
		String before_p_code = null ;
		String before_p_num = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="SELECT post_code, post_num  FROM post ORDER BY length(post_code) desc, post_code desc";
		
		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			
			while(rs.next()) {
				before_p_code = rs.getString("post_code");
				before_p_num = rs.getString("post_num");
				break;
			}
			
			int code1 = Integer.parseInt(before_p_code.split("_")[1]) + 1;
			String code2 = Integer.toString(code1);
			
			post[0] = before_p_code.split("_")[0]+"_"+code2 ; 
			
			int code3 = Integer.parseInt(before_p_num.split("_")[1]) + 1;
			String code4 = Integer.toString(code3);
			post[1] = before_p_num.split("_")[0]+ "_"+ code4;
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		
		return post;
	}

	public static void setPost(Post p) {
		
		conn = JDBCUtility.getConnection();
		
		int succ_count=0;
		PreparedStatement pstmt = null;
		
		String sql ="insert into post(post_code,post_num,`do`,ci,gungu,dong,be_addr) VALUES (?,?,?,?,?,?,?)";
		
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getPost_code());
			pstmt.setString(2, p.getPost_num());
			pstmt.setString(3, p.getDo_());
			pstmt.setString(4, p.getCi());
			pstmt.setString(5, p.getGungu());
			pstmt.setString(6, p.getDong());
			pstmt.setString(7, p.getBe_addr());
			
			succ_count = pstmt.executeUpdate();			
			
			if(succ_count>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
			
			
		} catch (Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
	}

	public static void setMemOrder(String m_od_code,String m_code, HashMap<String, Integer> cart_map, String order_date,
			String due_date) {

		conn = JDBCUtility.getConnection();

		int succ_count=0;
		PreparedStatement pstmt1 =null;
		ResultSet rs = null;
		
		try {
			String sql ="insert into memorder(m_od_code,m_code,p_code,p_count,order_date,due_date) VALUES (?,?,?,?,?,?)";
			pstmt1 = conn.prepareStatement(sql);
			
			//카드에 담겨진걸 "p_code":p_count hashmap으로 담아와서 여기서풀어
			for(String i : cart_map.keySet()) {
				String p_code = i;
				int p_count = cart_map.get(i);
				
				pstmt1.setString(1, m_od_code);
				pstmt1.setString(2, m_code);
				pstmt1.setString(3, p_code);
				pstmt1.setInt(4, p_count);
				pstmt1.setString(5, order_date);
				pstmt1.setString(6, due_date);
				
				succ_count = pstmt1.executeUpdate();			

				if(succ_count>0) {
					JDBCUtility.commit(conn);
				}else {			
					JDBCUtility.rollback(conn);
				}
				pstmt1.clearParameters();
			}
			
			
		}catch (Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());		
		}finally {
			JDBCUtility.close(conn, pstmt1, rs);
		}
		
	}

	public static String makeModcode() {
		conn = JDBCUtility.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String m_od_code =null;
		
		try {
			pstmt = conn.prepareStatement("SELECT m_od_code  FROM memorder ORDER BY length(m_od_code) desc, m_od_code desc");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				m_od_code = rs.getString("m_od_code");
				break;
			}
			m_od_code =(m_od_code.split("_")[0])+"_"+Integer.toString(Integer.parseInt(m_od_code.split("_")[1])+1); 
		}catch(Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());	
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return m_od_code;
	}

	public static List<Product> getMemOrder(String m_code) {

		conn = JDBCUtility.getConnection();

		List<Product> order_list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql ="select p.p_name, p.p_pay , mo.* from product p, memorder mo where p.p_code=mo.p_code and mo.m_code= ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_code);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				Product product = new Product();
				product.setP_name(rs.getString("p_name"));
				product.setP_pay(rs.getString("p_pay"));
				product.setP_code(rs.getString("p_code"));
				product.setP_count(rs.getInt("p_count"));
				product.setOrder_date(rs.getString("order_date"));
				product.setDue_date(rs.getString("due_date"));
				product.setP_count_pay(Integer.parseInt(product.getP_pay())*(product.getP_count()));
				order_list.add(product);
			}
		}catch(Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());	
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return order_list;
	}

	//주문정보 다 가져오기
	public List<MemOrder> selectOrder() {

		conn = JDBCUtility.getConnection();

		List<MemOrder> memorder_list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql ="select mo.m_od_code, m.m_name, p.p_name, mo.p_count,mo.order_date,mo.dead_line,mo.due_date,mo.delay_date "
				+ "	from member m , memorder mo , product p "
				+ "	where m.m_code = mo.m_code and mo.p_code = p.p_code "
				+ "	ORDER BY length(mo.m_od_code) desc, mo.m_od_code desc ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				MemOrder memorder = new MemOrder();
				memorder.setM_od_code(rs.getString("m_od_code"));
				memorder.setM_name(rs.getString("m_name"));
				memorder.setP_name(rs.getString("p_name"));
				memorder.setP_count(rs.getInt("p_count"));
				memorder.setOrder_date(rs.getDate("order_date"));
				memorder.setDue_date(rs.getDate("due_date"));
				if (rs.getDate("dead_line") != null) {
					memorder.setDead_line(rs.getDate("dead_line"));				
				}if (rs.getDate("delay_date") != null) {
					memorder.setDelay_date(rs.getDate("delay_date"));					
				}
				memorder_list.add(memorder);
			}
		}catch(Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());	
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return memorder_list;
		
	}

	//회원 정보 다 가져오기
	public List<Member> selectMemberList() {
		conn = JDBCUtility.getConnection();
		List<Member> member_list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="select * from member";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				Member mem = new Member();
				mem.setM_code(rs.getString("m_code"));
				mem.setM_type(rs.getString("m_type"));
				mem.setM_name(rs.getString("m_name"));
				mem.setM_id(rs.getString("m_id"));
				mem.setM_phone(rs.getString("m_phone"));
				mem.setM_email(rs.getString("m_email"));
				mem.setPost_code(rs.getString("post_code"));
				member_list.add(mem);
			}
		}catch(Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());	
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return member_list;
	}

	public boolean duplicateIdCheck(String id) {

		conn = JDBCUtility.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		String sql="select m_id from member where m_id =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				result=true;
			}
		}catch(Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());	
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return result;
	}

	public void updateMember(String id, String name, String jumin, String phone, String email) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="update member set m_name = ? ,m_jumin=?, m_phone=?, m_email=? where m_id = ?";
		
		try {
			conn = db.JDBCUtility.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, jumin);
			pstmt.setString(3, phone);
			pstmt.setString(4, email);
			pstmt.setString(5, id);
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, null);
		}
		
		
	}

	public boolean update_pwcheck(String id,String pw) {
		boolean updateSucc =false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = db.JDBCUtility.getConnection();
			pstmt = conn.prepareStatement("select m_pw from member where m_id =?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String m_pw = rs.getString("m_pw");
				if(pw.equals(m_pw)) {
					updateSucc=true;
				}
			}
			
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		
		return updateSucc;
	
	}

	
	
	
}
