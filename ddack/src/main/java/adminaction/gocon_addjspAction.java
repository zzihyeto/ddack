package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class gocon_addjspAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ProductDAO productDAO = ProductDAO.getInstance();
		List<String> mat_list = productDAO.getMat_list();
		
		HttpSession session = req.getSession();
		session.setAttribute("mat_list", mat_list);
		
		ActionForward forward =new ActionForward();
		forward.setPath("/adminpage/con_add.jsp");
		return forward;
	}

}
