package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SupplierDAO;
import action.Action;
import vo.ActionForward;

public class pur_formAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		

		ActionForward forward = new ActionForward();
		
		int need_cnt = Integer.parseInt(req.getParameter("need_cnt")); // 최소 필요한 주문수량
		String b_comp_code = req.getParameter("b_comp_code"); //발주회사 코드
		int mat_count = Integer.parseInt(req.getParameter("mat_count")); // 발주수량
		String mat_code = req.getParameter("mat_code");
		SupplierDAO supplierDAO = SupplierDAO.getInstance();
		
		HttpSession session = req.getSession();
		session.setAttribute("mat_code", mat_code);
		
		if(mat_count < need_cnt) {
			//부족하게 주문을한다고 ? 다시 주문하러가 
			forward.setPath("/adminpage/pur_addform.admin"); //pur_choice_from.jsp 1로가는거임
		} else {
			//넉넉하게 주문했네 오케이 등록시켜줄께
			
			//DB 접근해서 등록하는 메서드 실행
			supplierDAO.insertorder(b_comp_code, mat_count, mat_code);
			
			//가야할곳에 재료 담아서 
			// 주소로 간다.		
			forward.setPath("/adminpage/pur_manage.admin");
		}
		
		return forward;
	}

}
