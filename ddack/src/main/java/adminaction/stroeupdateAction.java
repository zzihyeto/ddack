package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class stroeupdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String store_code = req.getParameter("store_code");
		String store_name = req.getParameter("store_name");
		String store_loc = req.getParameter("store_loc");
		
		
		ProductDAO proDAO = ProductDAO.getInstance();
		proDAO.storeupdate(store_code,store_name,store_loc);

		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/storage.admin");
		return forward;
	}

}
