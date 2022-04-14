package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class ProducupdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		String p_code = req.getParameter("p_code");
		String p_name = req.getParameter("p_name");
		String eq_code = req.getParameter("eq_code");
		int p_kg = Integer.parseInt(req.getParameter("p_kg"));
		String p_life = req.getParameter("p_life");
		String p_pay = req.getParameter("p_pay");
		
		
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.productupdate(p_code,p_name,eq_code,p_kg,p_life,p_pay);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/product_state.admin");
		return forward;
	}

}
