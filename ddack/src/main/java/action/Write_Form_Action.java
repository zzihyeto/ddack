
package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import DAO.ProductDAO;
import entity.Member;
import entity.Product;
import vo.ActionForward;

public class Write_Form_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		boolean loging_check = false; //로그인 여부 확인
		boolean buy_check = false; //구매이력 확인
		
		//로그인 여부 확인 => LoginAction.java에 있는것 이용
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("member_info"); //회원정보 담긴 Member를 세션속성저장
		
		String ingm_code = null; 
		
		if (member != null) { //member에 member_info가 null이 아니면 = 로그인이 되어있따면(값이 있겠지!?)
			loging_check = true;
			ingm_code=member.getM_code();//member에 있는 m_code
		}
		
		ActionForward forward = new ActionForward();

		// 로그인 여부 확인 ok - > 구매이력확인 -> id/ 제품명 가져오기
		if(loging_check) {
			
			ProductDAO productDAO = ProductDAO.getInstance(); //변수에 객체를 담아와서 써본다 -> 메모리문제
			buy_check = productDAO.buycheck(ingm_code);
			
			if (buy_check) {
				//로그인도햇고 사기도햇네요 쓸수있는 페이지로 갈게요
				List<Product> order_list = MemberDAO.getMemOrder(ingm_code);
				session.setAttribute("order_list", order_list);
				forward.setPath("./re_modal/write_form.jsp");
				
				System.out.println("==order_list=>"+order_list);
				
			} else {
				//리뷰나열된 페이지로 가서 산게 없네요 문자열 띄어도되고 
				//사야지 쓸수있습니다.
				
				
				session.setAttribute("buy_check", "구매내역없음 구매후 작성하셈");
				forward.setPath("review.show");
			}
		} else {			
			
			forward.setPath("/login_form.jsp");
		}
	
		return forward;
	}

}
