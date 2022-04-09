package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class BomdeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		
		req.setCharacterEncoding("utf-8");
		String mat_code = req.getParameter("mat_code");
		String clean_code = req.getParameter("clean_code");
		//삭제기능 
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.bomdelete(mat_code,clean_code);
		
		//삭제하고 bom 나열 되는 서블릿 발동 
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/bomtable.admin");
		return forward;
	}

}
