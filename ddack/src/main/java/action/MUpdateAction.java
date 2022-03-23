package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public class MUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward =null;
		
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		String jumin = req.getParameter("jumin");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		String do_ = req.getParameter("do_");
		String ci = req.getParameter("ci");
		String gungu = req.getParameter("gungu");
		String dong = req.getParameter("dong");
		String be_addr = req.getParameter("be_addr");
		
		//System.out.println("===가져온값 =====>" +name +id +pw +jumin+email+phone+do_ +ci+gungu+dong+be_addr );
		
		//비번 일치
		
		
		forward = new ActionForward();
		forward.setPath("./member_info.jsp");
		
		return null;
	}

}
