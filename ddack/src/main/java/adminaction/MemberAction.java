package adminaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import action.Action;
import entity.Member;
import vo.ActionForward;

public class MemberAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		
		List<Member> member_list = new ArrayList<>();
		MemberDAO memberDAO  =MemberDAO.getInstance();
		member_list = memberDAO.selectMemberList();
		
		HttpSession sess = req.getSession();
		sess.setAttribute("member_list", member_list);
 		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/member_admin.jsp");
		return forward;
	}

}
