package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProcessDAO;
import action.Action;
import vo.ActionForward;

public class LineinsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String line_name = req.getParameter("line_name");
		String line_usable = req.getParameter("line_usable");
		
		ProcessDAO proDAO = ProcessDAO.getInstance();
		//line_code 새로 만들고 line 테이블에 row 한줄 생성 
		String line_code = proDAO.makeNew_linecode();
		proDAO.lineinsert(line_code,line_name,line_usable);
		
		//check code 새로 만들고 그에따른 line_code 집어넣기 
		String check_code = proDAO.makeNew_checkcode();
		proDAO.lineck_insert(check_code,line_code,line_usable);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/line_state.admin");
		return forward;
	}

}
