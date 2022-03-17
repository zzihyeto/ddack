package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;
import vo.ActionForward;

public class AddcartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String p_code = req.getParameter("p_code");
		//System.out.println("===p_code======"+p_code);
		
		ActionForward forward =null;
		List<Product> cart_list = null;
		
		ProductService productser = new ProductService();
		cart_list = productser.getCartProduct(p_code);
		
		req.setAttribute("cart_list", cart_list);
		
		forward = new ActionForward();
		forward.setPath("/cart.jsp");
		
		
		return forward;
	}
}
