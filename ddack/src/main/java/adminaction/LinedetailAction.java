package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProcessDAO;
import action.Action;
import entity.CHprocess;
import vo.ActionForward;

public class LinedetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String line_code = req.getParameter("line_code");
		
		ProcessDAO proDAO = ProcessDAO.getInstance();
		CHprocess chpro = proDAO.getlinedetail(line_code);
		
		
		HttpSession session = req.getSession();
		session.setAttribute("chpro", chpro);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/line_detail.jsp");
		return forward;
	}

}
