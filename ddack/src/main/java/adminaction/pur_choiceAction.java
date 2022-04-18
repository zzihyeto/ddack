package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SupplierDAO;
import action.Action;
import vo.ActionForward;

public class pur_choiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// mat_code를 넣어서 mat_count(주문가능수량) 확인하기
		String mat_code = req.getParameter("mat_code");
		
		SupplierDAO supplierDAO = SupplierDAO.getInstance();
		int result = supplierDAO.choiceMC(mat_code); //need_cnt 주문필요한 수량
		
		//발주회사 코드 담은 리스트 만들기
		List<String> b_comp_codes = supplierDAO.getb_comp_code();
		
		HttpSession session = req.getSession();
		//session.setAttribute("supplier", session);
		session.setAttribute("resultcount", result); //주문해야하는 갯수 섹션에 담기
		session.setAttribute("b_comp_code", result);//발주회사 코드 담은 리스트 섹션에 담기 -> 페이지에서 포문으로 풀어내면됨
	
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/pur_choice_form2.jsp?mat_code="+mat_code);
		
		return forward;
	}

}
