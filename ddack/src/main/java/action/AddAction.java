package action;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;
import vo.ActionForward;

public class AddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward =null;
		
		req.setCharacterEncoding("utf-8");
		
		String p_code = req.getParameter("p_code");
		System.out.println("====지금선택한 것 "+p_code);
		
	 	String p_name = req.getParameter("p_name");
	 	String p_pay = req.getParameter("p_pay");
	 	String p_kg = req.getParameter("p_kg");
	 	String p_life = req.getParameter("p_life");
	 	int p_count =Integer.parseInt( req.getParameter("count"));
	 	
	 	
	 	HttpSession session = req.getSession();
	 	ArrayList<Product> cart_list = (ArrayList<Product>) session.getAttribute("cart_list");
	 	Product product =null;
	 	
	 	if (cart_list == null ){
	 		cart_list = new ArrayList<Product>();
	 		
	 		product =new Product();
	 		product.setP_code(p_code);
		 	product.setP_name(p_name);
		 	product.setP_kg(p_kg);
		 	product.setP_pay(p_pay);
		 	product.setP_life(p_life);
		 	product.setP_count_pay(Integer.parseInt(p_pay) *p_count);
		 	product.setP_count(p_count);
		 	
		 	cart_list.add(product);
	 	}else {
	 		//우선 product에 정보 넣고
	 		product =new Product();
			product.setP_code(p_code);
			product.setP_name(p_name);
			product.setP_kg(p_kg);
			product.setP_pay(p_pay);
			product.setP_life(p_life);
			product.setP_count_pay(Integer.parseInt(p_pay) *p_count);
			product.setP_count(p_count);
			
			//같은게 있는지 검열
	 		String t_f_list[] = new String [cart_list.size()];
	 		int index=0;
	 		for (int i=0; i< cart_list.size(); i++) {
	 			//product랑 cart_list안에 product 끼리 비교
	 			//product에 equlas 오버라이드 적어놓은 상태
	 			t_f_list[i]=String.valueOf(product.equals(cart_list.get(i)));
	 			
	 			//true있다면 그인덱스 번호 index로 지정
	 			if (t_f_list[i].equals("true")) {
	 				index = i; 
	 			}
	 		}
	 		
	 		//배열중에 true를 가지고 있다면 index 지정한걸루 수정만 하기 	
 			if (Arrays.asList(t_f_list).contains("true")) {
 				cart_list.get(index).setP_count(cart_list.get(index).getP_count()+p_count);
 				cart_list.get(index).setP_count_pay((cart_list.get(index).getP_count_pay())+(Integer.parseInt(p_pay) *p_count));
 			}else {
 				// 배열중에 true 없으면 cart_list에 담기
 				cart_list.add(product);
 				
 			}
	 	}
	 	//session 에 "cart_list" 라는 이름으로 cart_list 객체 넣음
		session.setAttribute("cart_list", cart_list);
		
		forward = new ActionForward();
		forward.setPath("product.show");
		
		return forward;
	}

}
