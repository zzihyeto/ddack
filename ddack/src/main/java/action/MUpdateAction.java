package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import entity.Member;
import entity.Post;
import service.JoinService;
import service.PostService;
import vo.ActionForward;

public class MUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		
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
		
		PostService post = new PostService();
		post.update_post(id,do_ ,ci , gungu ,dong, be_addr);
		//post 내용 넣기 
		//해당되는 아이디로 post_code찾아서 49번줄에 사용ㅎ게 하기 
		String post_code = post.getPost_code(id);
		
		MemberDAO dao = MemberDAO.getInstance();
		boolean updateSucc = dao.update_pwcheck(id,pw);
		if(updateSucc) {
			
			dao.updateMember(id,name,jumin,phone,email);
			
			Member member_info= dao.getMember_info(id);
			
			Post post_info = MemberDAO.getPost_info(post_code);
			
			HttpSession session = req.getSession(); 
			session.setAttribute("member_info", member_info);
			session.setAttribute("post_info", post_info);
			
			forward.setPath("./member_info.jsp");
		}else {
			
		}
		
		
		
		
		
		
		return null;
	}

}
