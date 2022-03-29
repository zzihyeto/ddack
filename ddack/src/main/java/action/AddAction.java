package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;
import service.ProductService;
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
	 	int p_count=Integer.parseInt( req.getParameter("count"));
	 	
	 			
		HttpSession session = req.getSession();
	 	ArrayList<Product> cart_list = (ArrayList<Product>) session.getAttribute("cart_list");
	 	
	 	//중복 인지 확인하고 카트 리스트에 넣기
	 	ProductService productser = new ProductService();
	 	cart_list = productser.addCart(cart_list , p_code, p_name, p_pay,  p_kg, p_life, p_count);

	 	//session 에 "cart_list" 라는 이름으로 cart_list 객체 넣음
		session.setAttribute("cart_list", cart_list);
		
		forward = new ActionForward();
		forward.setPath("product.show");
		
		return forward;
	}

}
