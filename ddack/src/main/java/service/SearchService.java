package service;

import java.util.List;

import DAO.ReviewDAO;
import entity.ReviewBean;

public class SearchService {

	public List<ReviewBean> getSearch() {
		return getSearch("total","",1);
	}
	
	public List<ReviewBean> getSearch(int page){
		return getSearch("total","",page);
	}
	public List<ReviewBean> getSearch(String field, String query, int page) {

		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		List<ReviewBean> review = reviewDAO.searchlist(field,query,page);
		return review;
	}

	public int getSearchCount() {
		return getSearchCount("total","");
	}
	public int getSearchCount(String field, String query) {
		
		ReviewDAO teethDAO = ReviewDAO.getInstance();
		int count = teethDAO.getSearchCount(field,query);
		
		return count;
	}

	
}
