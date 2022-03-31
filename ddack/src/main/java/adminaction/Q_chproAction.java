package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import action.Action;
import entity.CHprocess;
import vo.ActionForward;

public class Q_chproAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ProductDAO productDAO = ProductDAO.getInstance();
		//List<CHprocess> chpro_q_list = productDAO.selectChpro_Q();
		
		HttpSession session = req.getSession();
		//session.setAttribute("chpro_q_list", chpro_q_list);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/chpro_q_admin.jsp");
		
		return forward;
	}

}
