package entity;

import java.util.Date;

public class ReviewBean {
	
	private String re_code;
	private String m_id;
	private String p_code;
	private String p_review;
	private Date review_date;
	

	public ReviewBean() {	}
	
	
	public ReviewBean(String re_code, String m_id, String p_code, String p_review, Date review_date) {
		super();
		this.re_code = re_code;
		this.m_id = m_id;
		this.p_code = p_code;
		this.p_review = p_review;
		this.review_date = review_date;
	}



	public String getRe_code() {
		return re_code;
	}

	public void setRe_code(String re_code) {
		this.re_code = re_code;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_review() {
		return p_review;
	}

	public void setP_review(String p_review) {
		this.p_review = p_review;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}
	
}
	