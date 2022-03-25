package action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import entity.Member;
import entity.Product;
import vo.ActionForward;

public class FinalbuyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		
		String order_date = req.getParameter("today");
		String due_date = req.getParameter("due_date");

		HttpSession session = req.getSession();
		List<Product> cart_list = (List<Product>) session.getAttribute("cart_list");
		
		HashMap<String,Integer> cart_map = new HashMap<>();
		for (int i=0; i<cart_list.size() ; i++) { 
			String p_code= cart_list.get(i).getP_code(); 
			int p_count = cart_list.get(i).getP_count();
			cart_map.put(p_code,p_count);
		}
		 
		Member member = (Member) session.getAttribute("member_info"); 
		String m_code = member.getM_code();
		
		MemberDAO.getInstance();
		String m_od_code = MemberDAO.makeModcode();
		
		MemberDAO.setMemOrder(m_od_code,m_code,cart_map,order_date,due_date);
		
		session.setAttribute("order_date", order_date);
		session.setAttribute("due_date", due_date);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/succ_order.jsp");
		return forward;
	}

}
