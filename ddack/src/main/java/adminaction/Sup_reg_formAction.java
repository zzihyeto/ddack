package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SupplierDAO;
import action.Action;
import vo.ActionForward;

public class Sup_reg_formAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();

		String b_comp_code = req.getParameter("b_comp_code");
		String b_comp_name = req.getParameter("b_comp_code");
		String b_comp_addr = req.getParameter("b_comp_addr");
		String b_comp_tel = req.getParameter("b_comp_tel");
		String mat_code = req.getParameter("mat_code");
		
		
		SupplierDAO supplierDAO = SupplierDAO.getInstance();
		int supRegist = supplierDAO.supRegist(b_comp_code, b_comp_name, b_comp_addr, b_comp_tel, mat_code);
		
		boolean supRegSucc = false;
		if (supRegSucc) {
			req.setAttribute("supRegSucc", supplierDAO);
			supRegSucc = true;
			forward.setPath("/adminpage/supplier_admin.jsp");
		} 
		
		
		return forward;
	}

}
