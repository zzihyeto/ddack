package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SupplierDAO;
import action.Action;
import vo.ActionForward;

public class pur_formAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		

		ActionForward forward = new ActionForward();
		
		String b_order_code = req.getParameter("b_order_code");
		String mat_order_d = req.getParameter("mat_order_d");
	//	String mat_code = req.getParameter("mat_code");
	//	System.out.println("===mat_code=="+mat_code);
		String b_comp_code = req.getParameter("b_comp_code");
		System.out.println("===b_comp_code=="+b_comp_code);
		int mat_count = Integer.parseInt(req.getParameter("mat_count"));
		System.out.println("=========mat_count="+mat_count);
		String exp_in_d = req.getParameter("exp_in_d");
		String tru_in_d = req.getParameter("tru_in_d");
		String quality = req.getParameter("quality");
		
		SupplierDAO supplierDAO = SupplierDAO.getInstance();
		int checkmat = supplierDAO.checkm(b_order_code, b_comp_code, mat_order_d, mat_count, exp_in_d, tru_in_d, quality);
		
		boolean cmat = false;
		
		if(cmat) {
			
			req.setAttribute("cmat", supplierDAO);
			cmat = true;
			forward.setPath("/adminpage/purchase_mamage.jsp");
		}
		
		return forward;
	}

}
