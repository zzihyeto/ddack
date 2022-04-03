package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import action.Action;
import entity.BOM;
import vo.ActionForward;

public class BOMAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ProductDAO productDAO = ProductDAO.getInstance();
		List<BOM> bom_list = productDAO.selectBOM();
		//mat_code..mat_name..mat_type..mat_unit..mat_count..mat_person..
		//mat_container_code..mat_life_t..c_check..clean_code
		
		HttpSession session = req.getSession();
		session.setAttribute("bom_list", bom_list);

		ActionForward forward =new ActionForward();
		forward.setPath("/adminpage/bom_admin.jsp");
		
		return forward;
	}

}
