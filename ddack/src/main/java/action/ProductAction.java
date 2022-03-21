package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;
import service.ProductService;
import vo.ActionForward;

public class ProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward =null;
		List<Product> pro_list = null;
		
		ProductService productser = new ProductService();
		pro_list = productser.getProduct();
		//System.out.println("==pro_list===action=="+pro_list);
		
		HttpSession session = req.getSession();
		session.setAttribute("pro_list", pro_list);
		
		forward = new ActionForward();
		forward.setPath("/product_show.jsp");	
		
		return forward;
	}

}
