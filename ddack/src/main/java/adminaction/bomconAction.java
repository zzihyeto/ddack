package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import action.Action;
import entity.BOM;
import vo.ActionForward;

public class bomconAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		
		String mat_con_out = "F";
				
		ProductDAO productDAO = ProductDAO.getInstance();
		List<BOM> bomcon_list = productDAO.getbomcontainer(mat_con_out);
		
		HttpSession session = req.getSession();
		session.setAttribute("bomcon_list", bomcon_list);
		
		ActionForward forward =new ActionForward();
		forward.setPath("/adminpage/bom_con_admin.jsp");
		
		return forward;
	}

}
