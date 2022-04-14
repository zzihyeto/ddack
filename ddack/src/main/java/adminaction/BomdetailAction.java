package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import action.Action;
import entity.BOM;
import vo.ActionForward;

public class BomdetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String mat_code = req.getParameter("mat_code");
		
		ProductDAO productDAO = ProductDAO.getInstance();
		BOM bom = productDAO.getbomrow(mat_code);
		
		HttpSession session = req.getSession();
		session.setAttribute("bom", bom);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/bom_detail.jsp");
		return forward;
	}

}
