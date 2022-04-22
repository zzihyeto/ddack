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

public class pro_manageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		List<Production_manage> process_manage = new ArrayList<Production_manage>();
		
		ManufaDAO manufaDAO = ManufaDAO.getInstance();
		process_manage = manufaDAO.getCHp();
		
		
		
		HttpSession sess = req.getSession();
		sess.setAttribute("process_manage", process_manage);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/Process_Management.jsp");
		
		return forward;
	}

}
