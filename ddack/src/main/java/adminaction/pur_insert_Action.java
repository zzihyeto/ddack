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
		String tru_in_d = req.getParameter("tru_in_d");
		String quality = req.getParameter("quality");
		
		int real_qty = Integer.parseInt(req.getParameter("real_qty"));
		System.out.println("=jsp에서 가져온 aciton =real_qty===>"+real_qty);
		// 새로운 값 가져와서 예상 입고일, 실제입고일, 품질 정보 업데이트 하기
		SupplierDAO supplierDAO = SupplierDAO.getInstance();
		supplierDAO.updatePurs(b_order_code, exp_in_d, tru_in_d, quality);
	
		//mat_code 가져오기
		String mat_code = supplierDAO.getM_code(b_order_code);
		System.out.println("==mat_code===>"+mat_code);
		
		//bom mat_count 현재 수량 가져오기 
		int current = supplierDAO.getInvent_qty(mat_code);
		System.out.println("==current===>"+current);
		//bom mat_count 꺼 수량 더해준거  update
		int new_mat_cnt = current + real_qty;
		System.out.println("==new_mat_cnt===>"+new_mat_cnt);
		
		supplierDAO.calcu_qty(new_mat_cnt, mat_code);

		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/pur_manage.admin");
		
		return forward;
	}

}
