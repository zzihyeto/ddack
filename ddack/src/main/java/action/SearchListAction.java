package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.PageInfo;
import entity.ReviewBean;
import service.PageService;
import service.SearchService;
import vo.ActionForward;

public class SearchListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		ActionForward forward = null;
		
		String _field = req.getParameter("f");
		String _query = req.getParameter("q");
		String _page = req.getParameter("page");
		String field = "re_code";
		String query = "";
		
		int page = 1;
		
		if(_field !=null && !_field.equals("")) field = _field; 
		if(_query !=null && !_query.equals("")) query = _query;
		if(_page !=null && !_page.equals("")) page = Integer.parseInt(_page);
		
		SearchService searchser = new SearchService();
		List<ReviewBean> search_list = searchser.getSearch(field, query, page);
		
		//search 해서 온 페이지 관련 pageInfo만들기
		PageService pageser = new PageService();
		PageInfo pageInfo = pageser.getSearchPageInfo(field, query, page);
		
		
		HttpSession sess = req.getSession();
		sess.setAttribute("search_list", search_list);

		req.setAttribute("pageInfo", pageInfo);
		
		forward = new ActionForward();
		forward.setPath("/review_search.jsp");
		
		return forward;
	}
}
