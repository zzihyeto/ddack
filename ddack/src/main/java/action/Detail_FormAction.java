package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.ReviewBean;
import service.DetailService;
import vo.ActionForward;

public class Detail_FormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		// 로그인 여부 상관없이 상세리뷰페이지 볼수 있음 -> 로그인 여부 불필요함
		// 상세리뷰 폼에는 p_name, p_review가 보여지도록 해야함 -> 이걸 뒤져서 가져와야한다.
		
		ActionForward forward = null;
		ReviewBean review = new ReviewBean();
		
		String p_code = req.getParameter("p_code");
		String m_id = req.getParameter("m_id");
		
				
		//p_code와 m_id로 p_review와 p_name 가져오기
		DetailService detail = new DetailService();
		review = detail.getR_N(p_code, m_id);
		
		HttpSession session = req.getSession();
		session.setAttribute("review", review);
		
		forward = new ActionForward();
		forward.setPath("/re_modal/detail_form.jsp");
		
		
		return forward;

		}
}