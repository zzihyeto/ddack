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
		String inputid = req.getParameter("inputid");
		
		MemberDAO dao = MemberDAO.getInstance();
		boolean result = dao.duplicateIdCheck(inputid);
		ActionForward forward = new ActionForward();
		
		if(result) {
			req.setAttribute("inputid_result", "아아디 사용하셔도 됩니다." );	
			req.setAttribute("inputid", inputid);	
			forward.setPath("/join_form2.jsp");
		}else {
			req.setAttribute("inputid_result", "같은아이디가 있습니다. 다시 입력해주세요");			
			forward.setPath("/join_form.jsp");
		}
		
		return forward;
	}

}
