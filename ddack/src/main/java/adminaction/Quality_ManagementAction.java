package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import action.Action;
import entity.Product;
import vo.ActionForward;

public class Quality_ManagementAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ProductDAO productDAO = ProductDAO.getInstance();
		List<Product> Q_Management = productDAO.Quality_Management();
		
		HttpSession session = req.getSession();
		session.setAttribute("Q_Management", Q_Management);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/Quality_Management_admin.jsp");
		return forward;
		
	}

}
