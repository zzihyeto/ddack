package action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import DAO.ReviewDAO;
import entity.Member;
import entity.Product;
import vo.ActionForward;

public class WriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//세션통해 들어갈것
		HttpSession sess = req.getSession();
		Member member = (Member) sess.getAttribute("member_info");
		String m_id = member.getM_id();
		String ingm_code=member.getM_code();
		String p_name = req.getParameter("p_name");
		String p_review = req.getParameter("p_review");
		
		//글쓴거 등록 하고 나서 review.jsp페이지로 이동한다
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		String p_code = reviewDAO.getp_name(p_name);
		
		ActionForward forward = new ActionForward();	
		boolean writeRegist =false;
		HttpSession session = req.getSession();
		
		if(p_review.equals("")) {
			List<Product> order_list = MemberDAO.getMemOrder(ingm_code);
			session.setAttribute("order_list", order_list);
			req.setAttribute("blank", "리뷰 글이 빈칸 입니다");
			forward.setPath("./re_modal/write_form.jsp");	
		}else {
			writeRegist = reviewDAO.writeReview(m_id, p_code, p_review);
			
			if(writeRegist) {
				forward.setPath("review.show");			
			}
		}
	
		return forward;
			
	}

}