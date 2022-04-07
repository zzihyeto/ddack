package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import entity.Product;
import vo.ActionForward;

public class MemOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		
		String m_code = req.getParameter("m_code");
		
		//m_code 로 memorder table에서 해당되는 회원꺼 주문 가져오기
		List<Product> order_list = MemberDAO.getMemOrder(m_code);  
		
		HttpSession session = req.getSession();
		session.setAttribute("order_list", order_list);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/mem_orders.jsp");
		
		return forward;
	}

}
