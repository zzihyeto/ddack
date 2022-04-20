package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SupplierDAO;
import action.Action;
import vo.ActionForward;

public class pur_addformAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		SupplierDAO supplierDAO = SupplierDAO.getInstance();
	    List<String> matcodes = supplierDAO.getmatcode();
	    
	    HttpSession sess = req.getSession();
		sess.setAttribute("matcodes", matcodes);
		
		ActionForward forward =new ActionForward();
		forward.setPath("/adminpage/pur_choice_form.jsp");
		
		return forward;
	}
	
}
