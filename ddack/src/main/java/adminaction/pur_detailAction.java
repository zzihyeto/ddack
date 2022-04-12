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

public class pur_detailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		
		List<Supplier> supdetail_list = new ArrayList<Supplier>();
		SupplierDAO supplierDAO = SupplierDAO.getInstance();
		supdetail_list = supplierDAO.supplierdetail();
		
		System.out.println("===supdetail_list= pur_detailAction.java====="+supdetail_list);

		HttpSession sess = req.getSession();
		sess.setAttribute("supdetail_list", supdetail_list);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/purchase_manage.jsp");
		
		return forward ;
	}

}
