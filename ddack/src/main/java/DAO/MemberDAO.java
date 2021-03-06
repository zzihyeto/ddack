package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;

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
	//
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

	public static void setMemOrder(String m_code, HashMap<String, Integer> cart_map, String order_date,
			String due_date) throws ParseException {

		//-----dead_line 날짜 계산 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date order_date_f = formatter.parse(due_date);//원하는 주문날짜 기입한걸 date형식으로 바꾸고 
		Calendar cal = Calendar.getInstance();//계산할수 있게 불러서
		cal.setTime(order_date_f);//셋팅해주고 //date계산하기 
		cal.add(Calendar.DATE, -5);//dead_line 우리가 정한 기한일 만들려고 -5일 정도 넉넉하게 잡고 생산시작하는걸로 
		String dead_line = formatter.format(cal.getTime());//다시 포켓팅해서 스트링으로 뱉기
		
		String m_od_code=null;
		int succ_count = 0;

		m_od_code = MemberDAO.makeModcode();
		conn = JDBCUtility.getConnection();
		PreparedStatement pstmt1 =null;
		
		try {
			String sql ="insert into memorder(m_od_code,m_code,p_code,p_count,order_date,dead_line,due_date) VALUES (?,?,?,?,?,?,?)";
			pstmt1 = conn.prepareStatement(sql);
			
			//카드에 담겨진걸 "p_code":p_count hashmap으로 담아와서 여기서풀어
			for(String i : cart_map.keySet()) {
				String p_code = i;
				int p_count = cart_map.get(i);
				pstmt1.setString(1, m_od_code);//변동사항 pk 라 변경되서 넣어져야함
				pstmt1.setString(2, m_code);
				pstmt1.setString(3, p_code);//변동사항
				pstmt1.setInt(4, p_count);//변동사항
				pstmt1.setString(5, order_date);
				pstmt1.setString(6, dead_line);
				pstmt1.setString(7, due_date);
				
				succ_count =pstmt1.executeUpdate();
				
				if(succ_count>0) {
					JDBCUtility.commit(conn);
				}else {			
					JDBCUtility.rollback(conn);
				}
				pstmt1.clearParameters();
				m_od_code = m_od_code =m_od_code.substring(0,m_od_code.indexOf("_"))+"_"+Integer.toString(Integer.parseInt(m_od_code.substring(m_od_code.indexOf("_")+1)) +1);
			}
		
			
			
		}catch (Exception e) {
			System.out.println("문제가 발생했습니다."+e.getMessage());		
		}finally {
			JDBCUtility.close(conn, pstmt1, null);
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

	//아이디 있으면 결과는 false 배출하도록 
	public boolean duplicateIdCheck(String inputid) {

		conn = JDBCUtility.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = true;
		String sql="select m_id from member where m_id =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputid);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				result=false;
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
		int regCount =0;
		String sql ="update member set m_name = ? ,m_jumin=?, m_phone=?, m_email=? where m_id = ?";
		
		try {
			conn = db.JDBCUtility.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, jumin);
			pstmt.setString(3, phone);
			pstmt.setString(4, email);
			pstmt.setString(5, id);
			
			regCount= pstmt.executeUpdate();
			
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

	
	//id값으로 postcode get 가져오기
	public String getPost_code(String id) {
		
		conn = db.JDBCUtility.getConnection();
		
		String  post_code ="";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select post_code from member where m_id =?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				post_code = rs.getString("post_code");
			}
			
		} catch(Exception e) {
			System.out.println("등록되지 못했습니다." + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		
		return post_code;
	}

	//post_code기준으로 post 테이블에서 내용값 수정하는 메서드
	public void update_post(String post_code, String do_, String ci, String gungu, String dong, String be_addr) {

		conn = db.JDBCUtility.getConnection();
		int regCount =0;
		PreparedStatement pstmt = null;
		String sql ="update post set `do`=?, ci=?, gungu=? , dong=? ,be_addr=? where post_code =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, do_);
			pstmt.setString(2, ci);
			pstmt.setString(3, gungu);
			pstmt.setString(4, dong);
			pstmt.setString(5, be_addr);
			pstmt.setString(6, post_code);
			
			
			regCount = pstmt.executeUpdate();
			
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
	// 회원탈퇴
	public boolean dbpwcompare(String id, String pw) {
	// ↑ boolean타입으로(return값이 true or false)의 deleteMember() 메서드생성
		boolean result = false;
		
		conn = db.JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpw="";
		// ↑ DB에서 읽어 올 password를 저장할 변수를 선어하고 초기ㄹ호
		
		try {
			String sql="select m_pw from member where m_id=?";
			// ↑ where 조건문 id에 pstmt.setString(1, id)로 매개변수로 넘겨받은 id를 위치홀더에 넣었기 때문에,
			// member 테이블의 매개변수로 받은 id를 가진 데이터의 password 칼럼을 검색
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			// ↑ 쿼리를 DB에 질의하고 받아온 결과를 rs에 저장
			if(rs.next()) {
				dbpw = rs.getString("m_pw");
			}
			if(dbpw.equals(pw)) {
				result=true;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("삭제되지 못함");
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return result;
	}

	// 날짜별. 제품별, 주문갯수 가져오기
	public List<MemOrder> getcount() {
		
		conn = JDBCUtility.getConnection();

		List<MemOrder> need_list = new ArrayList<MemOrder>();
		
		MemOrder need = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select p.p_name, mo.p_count, mo.order_date from memorder mo, product p order by order_date desc";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				need = new MemOrder();
				need.setP_name(rs.getString("p_name"));
				need.setP_count(rs.getInt("p_count"));
				need.setOrder_date(rs.getDate("order_date"));
				
				need_list.add(need);
			}
			
		} catch (Exception e) {
			System.out.println("연결해서 뭔가 잘못된거같다: 거래처정보" + e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		
		return need_list;
	}
	
	
	// 비밀번호 찾기
	public String findpw(String id, String name, String jumin) {
		
		conn = db.JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pw = null;	
		String sql ="select m_pw from member where m_id=? and  m_name=? and m_jumin=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, jumin);
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				pw=rs.getString("member.m_pw");
			}
			
		}catch (Exception e) {
			System.out.println("실패."+e.getMessage());
			
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return pw;
	}
	
	// 비밀번호찾을 때 아이디맞는지에 대한 메서드

	public boolean Idcheck(String id) {
		
		boolean being_id = false;
		conn = db.JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from member where m_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String m_id = rs.getString("m_id");
				if(id.equals(m_id)) {
					being_id=true;
				}
			}
		}catch(Exception e) {
			System.out.println("실패"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt,rs);
		}
		return being_id;
	}
	
	public void deletemember(String m_id) {
		
		conn = db.JDBCUtility.getConnection();
		PreparedStatement pstmt = null;
		String sql="delete from member where m_id=?";
		int succ_num = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			
			succ_num= pstmt.executeUpdate();
			
			if(succ_num>0) {
				JDBCUtility.commit(conn);
			}else {			
				JDBCUtility.rollback(conn);
			}
		}catch(Exception e) {
			System.out.println("실패"+e.getMessage());
		}finally {
			JDBCUtility.close(conn, pstmt,null);
		}
		
	}
}


































