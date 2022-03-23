package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Member;
import entity.Post;
import service.LoginCheckService;
import vo.ActionForward;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		//입력한 값 파라미터 받아오고
		String userID = req.getParameter("userID");
		String inputPassword = req.getParameter("inputPassword");
		
		boolean ok_id_pw = false;
		boolean ok_admin = false;
		
		LoginCheckService logincheckser = new LoginCheckService();
		ok_admin = logincheckser.isAmdin(userID,inputPassword); //admin 체크

		ok_id_pw = logincheckser.isLogin(userID,inputPassword); //id와 pw 확인해서 참 거짓 리턴 
		
		Member member_info = null;
		Post post_info = null;
		
		HttpSession session = req.getSession();

		if(ok_admin) {
			session.setAttribute("login_ing", "admin");

			forward = new ActionForward();
			forward.setPath("/index.jsp");	
			
		}else if(ok_id_pw){
			//회원이라면 
			//회원 정보 가져오고
			member_info =logincheckser.getMember_info(userID);
			
			String post_code = member_info.getPost_code();
			//회원 우편 가져오고
			post_info = logincheckser.getPost_info(post_code);
			
			
			//회원정보 담긴 알찬 Member 를 세션 속성에 저장
			session.setAttribute("member_info", member_info);
			
			//회원우편 정보 담긴 Post를 세션 속성에 저장
			session.setAttribute("post_info", post_info);
			
			//"member"문자열을  "login_ing"이름으로 세션 속성에 저장
			session.setAttribute("login_ing", "member");

			forward = new ActionForward();
			forward.setPath("/index.jsp");
		}
		
		
		return forward;
	}

}
