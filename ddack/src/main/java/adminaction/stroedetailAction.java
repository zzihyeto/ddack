package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import action.Action;
import entity.Product;
import vo.ActionForward;

public class stroedetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String store_code = req.getParameter("store_code");
		
		ProductDAO productDAO = ProductDAO.getInstance();
		Product store = productDAO.getStore_names(store_code);
		
		HttpSession session = req.getSession();
		session.setAttribute("store", store);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/store_detail.jsp");//jsp만들어야함
		return forward;
	}

}
