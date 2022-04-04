package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import DAO.ReviewDAO;
import entity.Member;
import vo.ActionForward;

public class Modi_FormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//detail_form. jsp에서 수정버튼 누르면 3가지 값을 가져온다
		//이름이 있어야 가져올수 있다.
		String p_name = req.getParameter("p_name");
		String p_review = req.getParameter("p_review");
		String m_id = req.getParameter("m_id");//리뷰쓴 아이디
		
		//현재아이디값은 어디서 ? member_info에서 있는지 확인한다.
		HttpSession sess = req.getSession();
		Member member = (Member) sess.getAttribute("member_info");
		
		String ingm_id = null; 
		
		boolean logmid_check = false;
		
		if(member != null) { 
			logmid_check = true;
			ingm_id = member.getM_id();		
		}
		
		ActionForward forward = new ActionForward();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		
		if(logmid_check) {
			// 지금 리뷰 아이디랑 현재로그인 아이디 비교하기 --> 블린 값에따라
			if(ingm_id.equals(m_id)) {
				//update review set p_review =? where m_id =? and p_name=?;
				//DB 접근 해서 업데이트 하기 (수정하기)
				reviewDAO.re_update(p_review, m_id, p_name);
			}else {
				//로그인은 맞지만 너가 쓴 글이 아니야(없어)@@
				//메세지를 띄울지? 어디로 보낼지 ? 
				//메세지 안띄우고 싶으면 안띄워도 된다.
				
				//액션포워드 선언 , 초기값 지정하고
				//액션 포워드 . 패스 셋팅
				forward.setPath("review.show");	
			}
		} else {
				//로그인 안되어있네 로그인하러가셈@@
			
		} 
 
		//포워드 배출 
		return forward;
	}

}