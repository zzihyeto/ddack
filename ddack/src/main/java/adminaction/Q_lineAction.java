package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import action.Action;
import entity.CHprocess;
import vo.ActionForward;

public class Q_lineAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		
		ProductDAO productDAO = ProductDAO.getInstance();
		List<CHprocess> line_state_list = productDAO.selectLineState();
		
		HttpSession session = req.getSession();
		session.setAttribute("line_state_list", line_state_list);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/line_q_admin.jsp");
		
		return forward;
	}

}
