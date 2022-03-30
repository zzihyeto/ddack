package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import action.Action;
import entity.MemOrder;
import vo.ActionForward;

public class MemorderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		
		MemberDAO memberDAO = MemberDAO.getInstance();
		List<MemOrder> memorder_list = memberDAO.selectOrder(); 
		
		HttpSession session = req.getSession();
		session.setAttribute("memorder_list", memorder_list);

		ActionForward forward =new ActionForward();
		forward.setPath("/adminpage/memorder_admin.jsp");
		
		return forward;
	}

}
