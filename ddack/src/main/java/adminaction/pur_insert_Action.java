package adminaction;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SupplierDAO;
import action.Action;
import vo.ActionForward;

public class pur_insert_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		
		req.setCharacterEncoding("utf-8");
		
		String b_order_code = req.getParameter("b_order_code");
		String b_comp_code = req.getParameter("b_comp_code");
		Date mat_order_d = req.getDateHeader("mat_order_code");
		int mat_count = Integer.parseInt(req.getParameter("mat_count"));
		String exp_in_d = req.getParameter("exp_in_d");
		String tru_in_d = req.getParameter("tru_in_d");
		String quality = req.getParameter("quality");
		
		
		// 예상 입고일, 실제입고일, 품질 정보 업데이트 하기
		SupplierDAO supplierDAO = SupplierDAO.getInstance();
		supplierDAO.updatePur(b_order_code, b_comp_code, mat_order_d, mat_count, exp_in_d, tru_in_d, quality);
		
	
		ActionForward forward =new ActionForward();
		forward.setPath("/adminpage/pur_manage.admin");
		
		
		return forward;
	}

}
