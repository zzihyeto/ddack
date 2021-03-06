package adminaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SupplierDAO;
import action.Action;
import entity.Supplier;
import vo.ActionForward;

public class SupplierAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	

		List<Supplier> supplier_list = new ArrayList<Supplier>();
		
		SupplierDAO supplierDAO = SupplierDAO.getInstance();
		supplier_list = supplierDAO.SupplierInfo();

		HttpSession sess = req.getSession();
		sess.setAttribute("supplier_list", supplier_list);

		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/supplier_admin.jsp");
		
		return forward;
	}

}
