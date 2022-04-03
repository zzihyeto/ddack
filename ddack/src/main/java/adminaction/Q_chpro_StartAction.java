package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class Q_chpro_StartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String q_code = req.getParameter("q_code");
		String chpro_code = req.getParameter("chpro_code");
		
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.q_chpro_start(q_code,chpro_code);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/q_chpro.admin");
		
		return forward;
	}
		
}
