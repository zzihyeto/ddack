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
				
		MemberDAO dao = MemberDAO.getInstance();
		boolean updateSucc = dao.update_pwcheck(id,pw);
		
		
		if(updateSucc) {
			//비번이 일치하니 내용값을 수정할수있어서 update하자
			
			String post_code = dao.getPost_code(id);
			//post_code기준으로 내용값 수정하는 메서드
			dao.update_post(post_code,do_ ,ci , gungu ,dong, be_addr);
			
			
			dao.updateMember(id,name,jumin,phone,email);
			
			Member member_info= dao.getMember_info(id);
			Post post_info = MemberDAO.getPost_info(post_code);
			
			HttpSession session = req.getSession(); 
			session.setAttribute("member_info", member_info);
			session.setAttribute("post_info", post_info);
			
			forward.setPath("./succ_m_modi.jsp");
		}else {
			//비번이 일치 하지 않으므로 회원 정보 수정하지 못합니다.를 알리러
			
		}
		
		return forward;
	}

}
