package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class coninsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String mat_name = req.getParameter("mat_name");
		String mat_type = req.getParameter("mat_type");//입고,출고때 쓴
		int updatecnt = Integer.parseInt(req.getParameter("updatecnt"));
		String mat_person = req.getParameter("mat_person");

		
		//원자재이름, 원자재입고 출고, 원자재갯수, 원자재 관리자 넣기
		ProductDAO productDAO = ProductDAO.getInstance();
		int mat_count= productDAO.getMat_count(mat_name);//해당이름의 갯수 가져오기 
		//원래 mat_countdptj +- updatecn해서 넣기 
		productDAO.coninsert(mat_name,mat_type,mat_count,updatecnt,mat_person);
		
		ActionForward forward =new ActionForward();
		forward.setPath("/adminpage/bom_com.admin");
		
		return forward;
	}

}
