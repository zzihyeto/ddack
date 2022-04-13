package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class LineupdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String line_code = req.getParameter("line_code");
		String line_name = req.getParameter("line_name");
		String line_usable = req.getParameter("line_usable");
		String check_date = req.getParameter("check_date");
		String check_content = req.getParameter("check_content");
		
		
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.lineupdate(line_code,line_name,line_usable,check_date,check_content);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/line_state.admin");
		return forward;
	}

}
