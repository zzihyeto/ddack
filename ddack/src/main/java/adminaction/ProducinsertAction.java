package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class ProducinsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		
		req.setCharacterEncoding("utf-8");
		String p_name = req.getParameter("p_name");
		String invent_code = req.getParameter("invent_code");
		int invent_total = Integer.parseInt(req.getParameter("invent_total"));
		int invent_qty = Integer.parseInt(req.getParameter("invent_qty"));
		String eq_code = req.getParameter("eq_code");
		
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/product_state.admin");
		
		return forward;
	}

}
