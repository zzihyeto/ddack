package action;

import java.util.ArrayList;
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

		req.setCharacterEncoding("utf-8");
		
		List<ReviewBean> list = new ArrayList<ReviewBean>();

		// page
		int page = 1;
		int limit = 10;

		if (req.getParameter("page") != null) {
			page = Integer.parseInt(req.getParameter("page"));
		}
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		
		// 구간으로 잘라서 리뷰 가져오기
		list = reviewDAO.selectReviewList(page, limit);	
		
		// pageInfo 만들기
		PageService pageser = new PageService();
		PageInfo pageInfo = pageser.getPageInfo(page);

		HttpSession sess = req.getSession();
		sess.setAttribute("review_list", list);
		req.setAttribute("pageInfo", pageInfo);

		ActionForward forward = new ActionForward();
		forward.setPath("/review.jsp");

		return forward;
	}

}
