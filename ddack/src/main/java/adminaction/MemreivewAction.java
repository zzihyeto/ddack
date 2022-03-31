package adminaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReviewDAO;
import action.Action;
import entity.ReviewBean;
import vo.ActionForward;

public class MemreivewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		List<ReviewBean> review_list = new ArrayList<ReviewBean>();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		review_list= reviewDAO.selectReview();

		HttpSession sess = req.getSession();
		sess.setAttribute("review_list", review_list);

		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/memreivew_admin.jsp");
		
		return forward;
	}

}
