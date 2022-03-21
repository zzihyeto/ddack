package action;

import java.util.ArrayList;
import java.util.List;

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
	 	String p_name = req.getParameter("p_name");
	 	String p_pay = req.getParameter("p_pay");
	 	String p_kg = req.getParameter("p_kg");
	 	String p_life = req.getParameter("p_life");
	 	int p_count =Integer.parseInt( req.getParameter("count"));
	 	
	 	
	 	HttpSession session = req.getSession();
	 	List<Product> cart_list = (List<Product>) session.getAttribute("cart_list");
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
	 		for (int i=0; i< cart_list.size(); i++) {
	 			if ((cart_list.get(i).getP_code()).equals(p_code)) {
	 				cart_list.get(i).setP_count(cart_list.get(i).getP_count()+p_count);
	 				cart_list.get(i).setP_count_pay(cart_list.get(i).getP_count_pay()+(Integer.parseInt(p_pay) *p_count));
	 			}else {
	 				
	 				product =new Product();
	 				product.setP_code(p_code);
	 				product.setP_name(p_name);
	 				product.setP_kg(p_kg);
	 				product.setP_pay(p_pay);
	 				product.setP_life(p_life);
	 				product.setP_count_pay(Integer.parseInt(p_pay) *p_count);
	 				product.setP_count(p_count);
	 				
	 				cart_list.add(product);
	 			}
	 			
	 		}
	 		
			
	 	}
	 		
 		
	 	
	 	
		session.setAttribute("cart_list", cart_list);
		
		forward = new ActionForward();
		forward.setPath("product.show");
		
		return forward;
	}

}
