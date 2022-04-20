package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReleaseDAO;
import action.Action;
import vo.ActionForward;
import entity.Release;

public class Release_histoy_admintAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		//List 안에 entity 를 담았지만,  entity 에 filed에 set이 되어있게 하도록  DAO에 접근  
		
		ReleaseDAO releaseDAO = ReleaseDAO.getInstance();
		List<Release> Release_history = releaseDAO.re_history();
		
		//List 안에 entity 를 담아서  섹션에 셋팅하기 
		HttpSession session = req.getSession();
		session.setAttribute("Release_history", Release_history);
	
		//주소 setpath 셋팅해주기
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/release_history_admin.jsp");
		return forward;
		
		
	}

}
