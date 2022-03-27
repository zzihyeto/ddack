package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReviewDAO;
import entity.PageInfo;
import entity.ReviewBean;
import service.PageService;
import vo.ActionForward;

public class ReviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward =null;
		
		List<ReviewBean> review_list = null;
		PageInfo pageinfo = null;
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		
		review_list = reviewDAO.selectReview();
		
		PageService page = new PageService();
		
		pageinfo = page.getPageInfo(1);
		
		HttpSession session = req.getSession();
		session.setAttribute("review_list", review_list);
		session.setAttribute("pageInfo", pageinfo);

		
		forward = new ActionForward();
		forward.setPath("/review.jsp");
		
		return forward;
	}

}
