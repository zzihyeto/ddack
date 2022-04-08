package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class BominsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String mat_name = req.getParameter("mat_name");
		String mat_type = req.getParameter("mat_type");
		String mat_unit = req.getParameter("mat_unit");
		int mat_count = Integer.parseInt(req.getParameter("mat_count"));
		String mat_person = req.getParameter("mat_person");
		String mat_container_code = req.getParameter("mat_container_code");
		String mat_life_t = req.getParameter("mat_life_t");
		String c_check = req.getParameter("c_check");
		
		ProductDAO productDAO = ProductDAO.getInstance();
		//맨뒤꺼 찾아서 추가한 새로운 mat_code 배출 
		String mat_code = productDAO.getnewmat_code();
		//c_check 내용 들어가면서 clean_code 새로생긴거에 c_check내용 들어가게 clean 테이블 pk 만들기 
		String clean_code = productDAO.getclean_code();
		//clean 에 새로운 pk랑 해서 내용 넣기 
		productDAO.insertClean(clean_code,c_check);
		//insert
		productDAO.insertBOM(mat_code,mat_name,mat_type,mat_unit,mat_count,mat_person,mat_container_code
				,mat_life_t,clean_code);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/bomtable.admin");
		return forward;
	}

}
