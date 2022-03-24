package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Member;
import entity.Product;
import vo.ActionForward;

public class FinalbuyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward =null;

		req.setCharacterEncoding("utf-8");
		
		
		String today = req.getParameter("today");
		
		String due_date = req.getParameter("due_date");
		
		
		 HttpSession session = req.getSession();
		  
		 List<Product> cart_list = (List<Product>) session.getAttribute("cart_list");
		 String[] p_codes = new String[cart_list.size()]; String[] p_counts = new
		 String[20];
		  
		 for (int i=0; i<cart_list.size() ; i++) { 
			 String p_code= cart_list.get(i).getEq_code(); p_codes[i] = p_code; 
		
		 }
		 
		 Member member = (Member) session.getAttribute("member_info"); 
		 String mem =
		 member.getM_id();
		 
		
		forward = new ActionForward();
		forward.setPath("/finalbuy.jsp");
		return null;
	}

}
