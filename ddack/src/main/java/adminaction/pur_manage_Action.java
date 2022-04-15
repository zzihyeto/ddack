package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SupplierDAO;
import action.Action;
import entity.Supplier;
import vo.ActionForward;

public class pur_manage_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String b_order_code = req.getParameter("b_order_code");
		
		SupplierDAO supplierDAO = SupplierDAO.getInstance();
		Supplier supplier = supplierDAO.getorderCode(b_order_code);
		
		HttpSession session = req.getSession();
		session.setAttribute("supplier", supplier);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/pur_modi_.jsp");

		
		return forward;
	}

}
