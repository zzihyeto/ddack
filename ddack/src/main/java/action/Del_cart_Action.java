package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;
import vo.ActionForward;

public class Del_cart_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward =null;
		
		req.setCharacterEncoding("utf-8");
		String p_code = req.getParameter("p_code");
		
		HttpSession session = req.getSession();
	 	ArrayList<Product> cart_list = (ArrayList<Product>) session.getAttribute("cart_list");
		
	 	int index =0;
	 	for(int i=0; i<cart_list.size();i++) {
	 		String cart_p_code = cart_list.get(i).getP_code();
	 		if(p_code.equals(cart_p_code)) {
	 			index = i;
	 		}
	 	}
	 	
		cart_list.remove(index);
		
		forward = new ActionForward();
		forward.setPath("./cart.jsp");
		forward.setRedirect(true);
		
		return forward;
	}

}
