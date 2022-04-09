package adminaction;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SupplierDAO;
import action.Action;
import vo.ActionForward;

public class PurOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		req.setCharacterEncoding("utf-8");
		String mat_code = req.getParameter("mat_code");
		int mat_count = 0;
		
		// BOM의 재고확인
		// 모든재료가 1000개, 꼬치250개 이하이면알림.
		SupplierDAO supplierDAO = SupplierDAO.getInstance();
		supplierDAO.CheckStock(mat_code, mat_count);
		
		ActionForward forward = new ActionForward();
		forward.setPath("../order_manage/purchase_check.jsp");
		
		return forward;
	}

	
	


}
