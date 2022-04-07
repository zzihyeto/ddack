package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import vo.ActionForward;

public class FindpwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String jumin = req.getParameter("jumin");
		boolean being_id =false;
		MemberDAO dao = MemberDAO.getInstance();
		
		//이런아이디가 있나 없나
		 being_id = dao.Idcheck(id);
		 
		//그런 이름이랑 주민이 맞는지 boolean
		if(being_id) {
			//있으면 비번 배출해서 가지고 
			String getpw = dao.findpw(id,name,jumin);
			
			if(getpw!=null) {
				//로그인 폼으로 가고 
				req.setAttribute("getpw",getpw);
				forward.setPath("/findpwAfter.jsp");
				
			}else {
				req.setAttribute("no_getpw","아이디는 맞지만 다른 정보가 안맞아요");
				forward.setPath("/findpw.jsp");
			}
			
	
		
		}else {
			//글씨를 가지고 
			//로그인 폼으로 가고 
			req.setAttribute("no_getpw","그런 아이디는 없습니다.다시 해주세요.");
			forward.setPath("/findpw.jsp");
		}
		
	     return forward;
	}
	
	
}
