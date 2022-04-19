package adminaction;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReleaseDAO;
import action.Action;
import entity.Release;
import vo.ActionForward;

public class Release_out_adminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//파라미터 담았던거 풀기
		req.setCharacterEncoding("utf-8");
		String p_code = req.getParameter("p_code");
		String m_code = req.getParameter("m_code");
		int p_count = Integer.parseInt(req.getParameter("p_count")); //빠지는 수량
		
		
		//기능 수행하기 미션수행하기 /  DAO 접근 
		ReleaseDAO releaseDAO = ReleaseDAO.getInstance();
		
		//1.해당 p_code되는 현재 수량
		int now_qty = releaseDAO.getQty(p_code);
		int stay_cnt = now_qty - p_count;
		
		//2.버튼을 누르면 완제품수량 변경
		releaseDAO.re_out(p_code,stay_cnt);

		//3.io_cd
		String io_cd = releaseDAO.getio_cd(p_code);
		
		//4.날짜업데이트
		releaseDAO.time_update(io_cd);
		
		//memorder = p_code,m_code 가져오기
		String m_od = releaseDAO.getm_order(p_code,m_code);
		
		//5.출고는 완료 했으니, 해당하고 있는거 한 줄 삭제
		releaseDAO.del_rel(m_od);
		
		//주소지정해주기
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/release_history.admin");
		
		return forward;
	}

}
