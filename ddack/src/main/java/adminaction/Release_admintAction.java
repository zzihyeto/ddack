package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReleaseDAO;
import action.Action;
import entity.Release;
import vo.ActionForward;

public class Release_admintAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ReleaseDAO releaseDAO = ReleaseDAO.getInstance();
		List<Release> Release_order = releaseDAO.re_order();
		
		HttpSession session = req.getSession();
		session.setAttribute("Release_order", Release_order);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/release_order_admin.jsp");
		return forward;
	}

}
