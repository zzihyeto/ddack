package adminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import action.Action;
import vo.ActionForward;

public class ProducinsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		
		req.setCharacterEncoding("utf-8");
		String store_name = req.getParameter("store_name");
		String p_name = req.getParameter("p_name");
		int invent_qty = Integer.parseInt(req.getParameter("invent_qty"));
		String eq_code = req.getParameter("eq_code");
		int p_kg = Integer.parseInt(req.getParameter("p_kg"));
		String p_life = req.getParameter("p_life");
		int p_pay = Integer.parseInt(req.getParameter("p_pay"));
		
		ActionForward forward = new ActionForward();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		if(invent_qty<=1000) {
			//p_code new 생성
			String p_code = productDAO.getNewp_code();
			productDAO.producinsert(p_code,p_name,eq_code,p_kg,p_life,p_pay);
			
			//store 코드 만드는 함수 
			String store_code = productDAO.getNewstore_code();
			//store 값 넣는 함수 
			productDAO.insertstorage(store_code,store_name);
			
			//창고코드
			String invent_code = productDAO.getNewinvent_code();
			productDAO.inventinsert(invent_code,p_code,invent_qty,store_code);
			
			forward.setPath("/adminpage/product_state.admin");
		}else {
			req.setAttribute("invent_qty_warn", "창고에 넣을 수 있는 갯수는 1000개에요. 넣고 싶은 갯수가 너무 많아요 다시 입력해주세요");
			forward.setPath("/adminpage/product_add.jsp");
		}
		
		return forward;
		
	}

}
