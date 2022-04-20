package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProcessDAO;
import action.Action;
import vo.ActionForward;

public class StartinsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String p_code = req.getParameter("p_code");
		int make_count = Integer.parseInt(req.getParameter("p_count_sum"));
		
		//프로시저 자리 - 만드는 중 
		ProcessDAO proDAO = ProcessDAO.getInstance();
		proDAO.startinsert(p_code,make_count);
		
		//p_code 기준 + 오늘날짜 이후 기준 출고 시키기 

		//출고 시킨거 입력하는 메서드 update 
		
		//주문한거 삭제하는 메서드
		proDAO.deleteorder(p_code);
		
		//주문상세정보로 다시 가서 
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/memorder.admin");
		
		return forward;
	}

}
