package adminaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ManufaDAO;
import action.Action;
import entity.Production_manage;
import vo.ActionForward;

public class pro_order_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		List<Production_manage> production_order = new ArrayList<Production_manage>();
		
		ManufaDAO manufaDAO = ManufaDAO.getInstance();
		production_order = manufaDAO.getStartOrder();
				
		HttpSession sess = req.getSession();
		sess.setAttribute("production_order", production_order);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/production_order.jsp");
				
		return forward;
	}

}
