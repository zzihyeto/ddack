package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;
import vo.ActionForward;

public class Del_MemberAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward = null;
		
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
	 	ArrayList<Product> member = (ArrayList<Product>) session.getAttribute("member");
	 	
	 	
		forward = new ActionForward();
		forward.setPath("./member_info.jsp");
		forward.setRedirect(true);
		
		return forward;
	}

}
