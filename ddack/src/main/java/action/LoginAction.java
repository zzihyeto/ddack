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
		boolean ok_admin = false;
		
		LoginCheckService logincheckser = new LoginCheckService();
		ok_admin = logincheckser.isAmdin(userID,inputPassword); //admin 체크
		ok_id_pw = logincheckser.isLogin(userID,inputPassword); //id와 pw 확인해서 참 거짓 리턴 
		
		if(ok_id_pw) {
			req.setAttribute("login_ing", "admin");
			forward = new ActionForward();
			forward.setPath("/index.jsp");	
			
		}else if(ok_id_pw){
			req.setAttribute("login_ing", "member");
			forward = new ActionForward();
			forward.setPath("/index.jsp");
		}
		
		
		return forward;
	}

}
