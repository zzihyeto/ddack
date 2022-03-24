package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReviewDAO;
import entity.PageInfo;
import entity.ReviewBean;
import service.PageService;
import vo.ActionForward;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		List<ReviewBean> list = new ArrayList<ReviewBean>();

		//page		
		int page = 1;
		int limit =10;
		
		if(req.getParameter("page") !=null) {
			page = Integer.parseInt(req.getParameter("page"));
		}
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		
		//전체 리뷰리스트 총 갯수
		int listCount = reviewDAO.selectListCount();
		
		//리뷰리스트 가져오기 : 날짜기준 내림차순
		list = reviewDAO.selectReviewList(page, limit);
		
		//pageInfo 만들기
		PageService pageser = new PageService();
		PageInfo pageInfo = pageser.getPageInfo(page);
		
		HttpSession sess = req.getSession();
		sess.setAttribute("reviewList", list);
		req.setAttribute("pageInfo", pageInfo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/page/review.jsp");
		
	return forward;	

	}
}










