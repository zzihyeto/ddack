package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class Q_lineInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String line_name= req.getParameter("line_name");
		String check_content= req.getParameter("check_content");
		
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.in_ch_content(line_name,check_content); 
		//내용 등록 하면서 line 테이블에 line_usable값 넣는 procedure 실행하는 메서드
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/line_state.admin");
		
		return forward;
	}

}
