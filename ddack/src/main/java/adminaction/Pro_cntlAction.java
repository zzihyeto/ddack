package adminaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProcessDAO;
import action.Action;
import entity.Product;
import vo.ActionForward;

public class Pro_cntlAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		
		//pro_cntl로 가지고 갈거 
		//memorder 보면서 제품이름, 제품갯수합계, 생산시작버튼(startmake.add 누르면 발동)
		ProcessDAO proDAO = ProcessDAO.getInstance();
		List<Product> sort_product = proDAO.getGroupProduct();
		
	
		HttpSession session = req.getSession();
		session.setAttribute("sort_product", sort_product);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/pro_cntl.jsp");
		return forward;
	}

}
