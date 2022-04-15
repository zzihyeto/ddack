package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SupplierDAO;
import action.Action;
import vo.ActionForward;

public class pur_choiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		
		String mat_code = req.getParameter("mat_code");
		System.out.println("====mat_code=action=="+ mat_code);
		
		SupplierDAO supplierDAO = SupplierDAO.getInstance();
		int choicemat = supplierDAO.choiceMC(mat_code);
		
		
		boolean choice = false;
		
		if (choice) {
			
			req.setAttribute("choice", "발주필요 개수는");
			choice = true;
			forward.setPath("/adminpage/pur_choice_form.jsp");
		}
		return forward;
	}

}
