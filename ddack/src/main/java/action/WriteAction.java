package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReviewDAO;
import entity.Member;
import vo.ActionForward;

public class WriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//세션통해 들어갈것
		HttpSession sess = req.getSession();
		Member member = (Member) sess.getAttribute("member_info");
		String m_id = member.getM_id();
		
		String p_name = req.getParameter("p_name");
		System.out.println("====p_name====>"+p_name);
		String p_review = req.getParameter("p_review");
		System.out.println("====p_review====>"+p_review);
		
		
		//글쓴거 등록 하고 나서 review.jsp페이지로 이동한다
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		String p_code = reviewDAO.getp_name(p_name);
		System.out.println("====p_code====>"+p_code);
		
		
		boolean writeRegist =false;
		writeRegist = reviewDAO.writeReview(m_id, p_code, p_review);
		System.out.println("====writeRegist= boolean===>"+writeRegist);
		
		ActionForward forward = new ActionForward();	
		
		if(writeRegist) {
			writeRegist = true;
			forward.setPath("review.show");			
		}
	
		return forward;
			
	}

}