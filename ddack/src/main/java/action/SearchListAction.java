package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.PageInfo;
import entity.ReviewBean;
import service.PageService;
import service.SearchService;
import vo.ActionForward;



public class SearchListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		ActionForward forward =null;
		
		String _field = req.getParameter("f");
		String _query = req.getParameter("q");
		String _page = req.getParameter("page");
		String field = "total";
		String query = "";
		
		int page = 1;
		int limit = 10;
		
		if(_field !=null && !_field.equals("")) field = _field; //total, user_id , t_code 중에
		if(_query !=null && !_query.equals("")) query = _query;
		if(_page !=null && !_page.equals("")) page = Integer.parseInt(_page);
		
		SearchService searchser = new SearchService();
		List<ReviewBean> list = searchser.getSearch(field,query,page);
		int Searchcount = searchser.getSearchCount(field,query);
		
		//총페이지수
		int totalPage = (int)(((double)Searchcount / limit + 0.95));
		//현재 페이지의 시작페이지수 (1,11,21,...)
		int startPage = (((int) ((double)page / 10 + 0.9)) -1)*10+1;
		//현재페이지에 보여줄 마지막 페이지수
		int endPage = startPage + 10 -1;
		if(endPage > totalPage) endPage = totalPage;
		
		//pageInfo만들기
		PageService pageser = new PageService();
		PageInfo pageInfo = pageser.getPageInfo(page);
		
		req.setAttribute("pageInfo", pageInfo);
		req.setAttribute("searchlist", list);
		req.setAttribute("count", Searchcount);

		forward = new ActionForward();
		forward.setPath("/reviews_search.jsp");
		return forward;
	}
}
