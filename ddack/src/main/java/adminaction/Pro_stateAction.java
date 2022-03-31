package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import action.Action;
import entity.Product;
import vo.ActionForward;

public class Pro_stateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ProductDAO productDAO = ProductDAO.getInstance();
		List<Product> pro_state_list = productDAO.selectProducState();
		
		HttpSession session = req.getSession();
		session.setAttribute("pro_state_list", pro_state_list);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/product_state_admin.jsp");
		return forward;
	}

}
