package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

public class StartinsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String p_code = req.getParameter("p_code");
		String make_cout = req.getParameter("p_count_sum");
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("");
		
		return forward;
	}

}
