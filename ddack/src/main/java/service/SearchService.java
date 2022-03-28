package service;

import java.util.List;

import DAO.ReviewDAO;
import entity.ReviewBean;

public class SearchService {

	public List<ReviewBean> getSearch() {
		return getSearch("m_id","",1);
	}
	
	public List<ReviewBean> getSearch(int page){
		return getSearch("m_id","",page);
	}
	
	
	public List<ReviewBean> getSearch(String field, String query, int page) {

		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		List<ReviewBean> search_list = reviewDAO.searchlist(field,query,page);
		return search_list;
	}

	
	
	

	
}
