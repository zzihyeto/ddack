package adminaction;

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
		String exp_in_d = req.getParameter("exp_in_d");
		System.out.println("==exp_in_d=="+exp_in_d);
		String tru_in_d = req.getParameter("tru_in_d");
		System.out.println("======tru_in_d========"+tru_in_d);
		String quality = req.getParameter("quality");
		System.out.println("===quality==========="+quality);
		
		// 새로운 값 가져와서 예상 입고일, 실제입고일, 품질 정보 업데이트 하기
		SupplierDAO supplierDAO = SupplierDAO.getInstance();
		supplierDAO.updatePurs(b_order_code,  exp_in_d, tru_in_d, quality);
	
		ActionForward forward =new ActionForward();
		forward.setPath("/adminpage/pur_manage.admin");
		
		return forward;
	}

}
