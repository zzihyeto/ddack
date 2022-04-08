package service;

import DAO.ReviewDAO;
import entity.ReviewBean;

public class DetailService {

	public ReviewBean getR_N(String p_name, String p_review) {

		ReviewBean review = new ReviewBean();
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		
		review = reviewDAO.getR_N(p_name, p_review);
		
		return review;
	}

	
	
}
