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
		
		String b_order_code = req.getParameter("b_order_code"); // 발주코드
		String mat_code = req.getParameter("mat_code"); //원재료 코드
		String b_comp_code = req.getParameter("b_comp_code"); //발주회사 코드
		int mat_count = Integer.parseInt(req.getParameter("mat_count")); // 발주수량
		
		SupplierDAO supplierDAO = SupplierDAO.getInstance();

		
		//DB 접근해서 등록하는 메서드 실행
		supplierDAO.insertorder(b_order_code, b_comp_code, mat_count);
		
		//가야할곳에 재료 담아서 
		// 주소로 간다.		
		forward.setPath("/adminpage/pur_manage.admin");
		return forward;
	}

}
