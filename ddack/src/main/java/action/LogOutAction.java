package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;

public class LogOutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		session.invalidate();
		
		ActionForward forward = new ActionForward();
		forward.setPath("/index.jsp");
		
		return forward;
	}

}
