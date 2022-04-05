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

		//나중에 생산지시내리면 영향받도록 해야지
		int mat_count_update =0;
		String mat_con_out = "";
		if(mat_count_update>0) {
			mat_con_out ="D";
		}
		
		ProductDAO productDAO = ProductDAO.getInstance();
		List<BOM> bomcon_list = productDAO.getbomcontainer(mat_con_out,mat_count_update);
		
		HttpSession session = req.getSession();
		session.setAttribute("bomcon_list", bomcon_list);
		
		ActionForward forward =new ActionForward();
		forward.setPath("/adminpage/bom_con_admin.jsp");
		
		return forward;
	}

}
