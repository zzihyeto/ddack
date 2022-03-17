package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginCheckService;
import vo.ActionForward;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward =null;
		
		//입력한 값 파라미터 받아오고
		String userID = req.getParameter("userID");
		String inputPassword = req.getParameter("inputPassword");
		
		boolean ok_id_pw = false;
		
		LoginCheckService logincheckser = new LoginCheckService();
		ok_id_pw = logincheckser.isLogin(userID,inputPassword); //id와 pw 확인해서 참 거짓 리턴 
		
		if(ok_id_pw) {
			HttpSession session = req.getSession();
			session.setAttribute("login_ing", "login 되었습니다.");
			forward = new ActionForward();
			forward.setPath("/ddack/index.jsp");	
			
		}
		
		return forward;
	}

}
