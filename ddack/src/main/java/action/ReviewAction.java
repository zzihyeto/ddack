package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReviewDAO;
import entity.ReviewBean;
import vo.ActionForward;

public class ReviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward =null;
		
		List<ReviewBean> review_list = null;
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		
		review_list = reviewDAO.selectReview();
		
		
		HttpSession session = req.getSession();
		session.setAttribute("review_list", review_list);
		
		
		forward = new ActionForward();
		forward.setPath("/review.jsp");
		
		return forward;
	}

}
