package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class Q_produInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String p_name= req.getParameter("p_name");
		int error_cnt= Integer.parseInt(req.getParameter("error_cnt"));
		
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.in_pro_eqcheck(p_name,error_cnt);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/product_state.admin");
		return forward;
	}

}
