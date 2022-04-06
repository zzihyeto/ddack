package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import vo.ActionForward;

public class IdDup_CheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		MemberDAO dao = MemberDAO.getInstance();
		boolean result = dao.duplicateIdCheck(id);
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		if(result) out.println("0");
		else out.println("1");
		
		out.close();
		
		
		ActionForward forward = null;
		
		
		return forward;
	}

}
