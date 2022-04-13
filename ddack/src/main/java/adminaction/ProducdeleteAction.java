package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class ProducdeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		String p_code = req.getParameter("p_code");
		//삭제기능 
		ProductDAO productDAO = ProductDAO.getInstance();
		//지금해당되는 품목코드로 store_code가져오고 
		String store_code = productDAO.getstor_code(p_code);
		//그걸로 store_code로 store코드 삭제하고 invent 코드 삭제 하고 p_code까지 삭제 되도록 
		productDAO.producdelete(store_code,p_code);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/product_state.admin");
		return forward;
	}

}
