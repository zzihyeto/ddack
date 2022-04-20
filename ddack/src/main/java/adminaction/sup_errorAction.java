package adminaction;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ManufaDAO;
import action.Action;
import vo.ActionForward;

public class sup_errorAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		req.setCharacterEncoding("utf-8");

		//주문코드별 -> 랜덤으로 불량수량을 알려준다
		String b_order_code = req.getParameter("b_order_code");
		//현재주문량
		int mat_count = Integer.parseInt(req.getParameter("mat_count"));

		//불량 수량 랜덤으로 계산
		Random random = new Random();
		
		int error_cnt = random.nextInt(1+20) + 1; //값이- 값으로 나옴.  현재 재료 재고수량<난수<현재 재료 입고수량 
		
		//발주후 진짜 입고된 수량
		int in_mat = mat_count - error_cnt ;		
			
		//랜덤으로 가져온 불량 수량 테이블에 집어넣기 
		ManufaDAO manufaDAO = ManufaDAO.getInstance();
		manufaDAO.updateErrcnt(error_cnt,b_order_code); //불량 수량 update
		
		//불량 수량 섹션에담고 가지고 pur_modi_2 로 가기 
		HttpSession session = req.getSession();
		session.setAttribute("error_cnt", error_cnt);

		ActionForward forward = new ActionForward();		
		forward.setPath("/adminpage/pur_modi_2.jsp");
		
		return forward;
	}

}
