package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ManufaDAO;
import action.Action;
import vo.ActionForward;

public class change_dateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		req.setCharacterEncoding("utf-8");
		String start_od_code = req.getParameter("start_od_code");

		ManufaDAO manefaDAO = ManufaDAO.getInstance();
		manefaDAO.ChangeEndDate(start_od_code);
				
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/production_order.admin");
		
		return forward;
	}

}
