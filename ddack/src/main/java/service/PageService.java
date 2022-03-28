package service;

import DAO.ReviewDAO;
import entity.PageInfo;

public class PageService {

	public PageInfo getPageInfo(String page) {

		//page
		int curPage = Integer.parseInt(page); //page가 string이라서 integer.parseint로 형변환
		int limit = 10; //한페이지에 출력한 행수
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		int listCount = reviewDAO.selectListCount();
			
		//paging	
		//총페이지수
		int totalPage = (int)(((double)listCount / limit + 0.95));
		//현재 페이지의 시작페이지수 (1,11,21,...)
		int startPage = (((int) ((double)curPage / 10 + 0.9)) -1)*10+1;
		//현재페이지에 보여줄 마지막 페이지수
		int endPage = startPage + 10 -1;
		if(endPage > totalPage) endPage = totalPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setListCount(listCount);
		pageInfo.setTotalPage(totalPage);
		pageInfo.setPage(curPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		
		return pageInfo;
	}
	
	public PageInfo getPageInfo(int page) {

		//page
		int curPage = page;
		int limit = 10; //한페이지에 출력할 행수
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		int listCount = reviewDAO.selectListCount(); //리뷰가 총몇개냐 총갯수
			
		//총페이지수
		int totalPage = (int)(((double)listCount / limit + 0.95));
		//현재 페이지의 시작페이지수 (1,11,21,...)
		int startPage = (((int) ((double)curPage / 10 + 0.9)) -1)*10+1;
		//현재페이지에 보여줄 마지막 페이지수
		int endPage = startPage + 10 -1;
		if(endPage > totalPage) endPage = totalPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setListCount(listCount);
		pageInfo.setTotalPage(totalPage);
		pageInfo.setPage(curPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		return pageInfo;
	}

	//페이지관련 - 몇개 찾았나 에서 페이지 나누려고
	public PageInfo getSearchPageInfo( String field, String query, int page) {
		
		int curPage = page;
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		int Searchcount = reviewDAO.getSearchCount(field,query);
		
		//총페이지수
		int totalPage = (int)(((double)Searchcount / 10 + 0.95));
		//현재 페이지의 시작페이지수 (1,11,21,...)
		int startPage = (((int) ((double)page / 10 + 0.9)) -1)*10+1;
		//현재페이지에 보여줄 마지막 페이지수
		int endPage = startPage + 10 -1;
		if(endPage > totalPage) endPage = totalPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setListCount(Searchcount);
		pageInfo.setTotalPage(totalPage);
		pageInfo.setPage(curPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		return pageInfo;
	}

}
