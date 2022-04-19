package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReleaseDAO;
import action.Action;
import vo.ActionForward;
import entity.Release;

public class Release_histoy_admintAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ReleaseDAO releaseDAO = ReleaseDAO.getInstance();
		
//		releaseDAO.re_history();
		
//		HttpSession session = req.getSession();
//		session.setAttribute("Release_history", Release_history);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/release_history_admin.jsp");
		return forward;
		
		
	}

}
