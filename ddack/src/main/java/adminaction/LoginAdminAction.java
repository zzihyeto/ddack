package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import entity.Member;
import entity.Post;
import service.LoginCheckService;
import vo.ActionForward;

public class LoginAdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
ActionForward forward = new ActionForward();;
		
		//입력한 값 파라미터 받아오고
		String userID = req.getParameter("userID");
		String inputPassword = req.getParameter("inputPassword");
		
		boolean ok_id_pw = false;
		boolean ok_admin = false;
		
		Member member_info = null;
		Post post_info = null;
		
		HttpSession session = req.getSession();

		LoginCheckService logincheckser = new LoginCheckService();
		ok_admin = logincheckser.isAmdin(userID,inputPassword); //admin 체크
		
		if(ok_admin) {
			member_info =logincheckser.getMember_info(userID);
			
			String post_code = member_info.getPost_code();
			post_info = logincheckser.getPost_info(post_code);
			
			session.setAttribute("member_info", member_info);
			session.setAttribute("post_info", post_info);
			session.setAttribute("login_ing", "admin");
			forward.setPath("/adminpage/index.jsp");	
			
		}else {
			req.setAttribute("no_admin", "Admin 로그인하지못합니다");
			forward.setPath("/adminpage/index.jsp");	
		}
		
		
		return forward;
	}

}
