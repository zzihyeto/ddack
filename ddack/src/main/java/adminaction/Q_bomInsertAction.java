package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class Q_bomInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String mat_name= req.getParameter("mat_name");
		int mat_count_update= Integer.parseInt(req.getParameter("mat_count_update"));
		String c_check= req.getParameter("c_check");
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.in_bom_eqcheck(mat_name,mat_count_update,c_check);
		
		ActionForward forward =new ActionForward();
		forward.setPath("/adminpage/bomtable.admin");
		return forward;
	}

}
