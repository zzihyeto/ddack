package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import action.Action;
import entity.Product;
import vo.ActionForward;

public class ProducdetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String p_code = req.getParameter("p_code");
		
		ProductDAO productDAO = ProductDAO.getInstance();
		Product product = productDAO.getproductrow(p_code);

		HttpSession session = req.getSession();
		session.setAttribute("product", product);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/product_detail.jsp");
		return forward;
	}

}
