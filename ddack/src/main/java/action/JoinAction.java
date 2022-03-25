package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Post;
import service.JoinService;
import service.PostService;
import vo.ActionForward;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward = null;
		
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		String name = req.getParameter("name");
		String jumin = req.getParameter("jumin");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		String do_ = req.getParameter("do_");
		String ci = req.getParameter("ci");
		String gungu = req.getParameter("gugun");
		String dong = req.getParameter("dong");
		String be_addr = req.getParameter("be_addr");
		
		PostService post = new PostService();
		Post p = post.makePost(do_ ,ci , gungu ,dong, be_addr);
		
		String post_code = p.getPost_code();
		JoinService joins = new JoinService();
		boolean regSuccess = joins.registerMember(id,pw,name,jumin,phone,email,do_,ci,gungu,dong,be_addr,post_code);
		
		HttpSession session = req.getSession(); 
		
		if(regSuccess) {
			session.setAttribute("Register", "회원가입완료");
			forward = new ActionForward();
			forward.setPath("/login_form.jsp");
		}else {
			session.setAttribute("Register", "회원가입실패");
			forward = new ActionForward();
			forward.setPath("/index.jsp");
		}
		return forward;
	}

}
