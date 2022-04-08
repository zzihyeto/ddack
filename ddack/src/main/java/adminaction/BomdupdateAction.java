package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class BomdupdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");

		String mat_code = req.getParameter("mat_code");
		String mat_name = req.getParameter("mat_name");
		String mat_type = req.getParameter("mat_type");
		String mat_unit = req.getParameter("mat_unit");
		int mat_count = Integer.parseInt(req.getParameter("mat_count"));
		String mat_person = req.getParameter("mat_person");
		String mat_life_t = req.getParameter("mat_life_t");
		String c_check = req.getParameter("c_check");
		String clean_code = req.getParameter("clean_code");
		
		//새로운 값 받아와서 update하게 만들기
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.updateBOM(mat_code,mat_name,mat_type,mat_unit,mat_count,mat_person,mat_life_t);
		
		productDAO.updateClean(clean_code,c_check);
		
		req.setAttribute("succ_update", "성공적으로 수정되었습니다.");
		ActionForward forward =new ActionForward();
		forward.setPath("/adminpage/bomtable.admin");
		
		return forward;
	}

}
