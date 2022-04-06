package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReviewDAO;
import entity.Member;
import vo.ActionForward;

public class Delete_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		boolean loging_check = false; //로그인 여부 확인
		
		// 로그인한 상태고 작성한 내역이 있어야함 작성한내역 있음 삭제가능
		
		//리뷰세부에서 온거
		String p_code = req.getParameter("p_code");
//		String p_review = req.getParameter("p_review");
		String m_id = req.getParameter("m_id"); 
		
		ActionForward forward = new ActionForward();

		
		//로그인 여부 상태
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("member_info"); //회원정보 담긴 Member를 세션속성저장
		
		String ingm_id = null; 
		
		//로그인 상태입니다.
		if (member != null) { //member에 member_info가 null이 아니면 = 로그인이 되어있따면(값이 있겠지!?)
			loging_check = true;
			ingm_id = member.getM_id(); //로그인중인 아이디
		}
		
		//로긴여부 확인완료 -> 구매 이력확인하자
		if(loging_check) {
			
			if(ingm_id.equals(m_id)) {
				//로그인도 했고 '로그인중아이디' == '리뷰 세부아이디'
				//삭제가능하니 삭제하자!
				ReviewDAO reviewDAO = ReviewDAO.getInstance();
				reviewDAO.delete_review(m_id, p_code); //delete ~ from ~ where ~?;
				forward.setPath("/review.show");
			} else {
				//로그인도 했고 로그인중 아이디랑 리뷰세뷰 id랑 다르넹
				//삭제권한없음 알림@@
				req.setAttribute("no_delete", "삭제할 권한이 없습니다."); //안돼.ㅠㄴ
				forward.setPath("/re_detail_form.show");
			}
			
		} else {
			//로그인이 안되있으니 -> login_form.jsp로 가자
			session.setAttribute("no_login", "로그인상태가 아니여서 삭제를 못함.");
			forward.setPath("/login_form.jsp");
		}
		
		return forward;
	}

}
