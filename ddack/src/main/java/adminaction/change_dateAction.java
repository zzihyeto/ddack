package adminaction;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ManufaDAO;
import action.Action;
import vo.ActionForward;

public class change_dateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		req.setCharacterEncoding("utf-8");
		String start_od_code = req.getParameter("start_od_code");
		String mk_time = req.getParameter("mk_time");
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//Date mk_time = format.parse( req.getParameter("mk_time"));
		
		//1.total_date 시간 계산
		
		LocalDate now = LocalDate.now();
        LocalDate d2 = LocalDate.parse(req.getParameter("mk_time"), DateTimeFormatter.ISO_LOCAL_DATE);
        Duration diff = Duration.between( d2.atStartOfDay(),now.atStartOfDay());
        int total_date = (int) diff.toDays();
        
		//ManufaDAO부르기
		ManufaDAO manefaDAO = ManufaDAO.getInstance();
		manefaDAO.ChangeEndDate(start_od_code,total_date,mk_time);
				
		ActionForward forward = new ActionForward();
		forward.setPath("/adminpage/production_order.admin");
		
		return forward;
	}

}
