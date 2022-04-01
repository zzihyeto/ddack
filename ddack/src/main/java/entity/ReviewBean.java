package entity;


import java.util.Date;

public class ReviewBean {
	
	private int r_num;
	private String re_code;
	private String p_name;
	private String m_id;
	private String p_review;
	private Date review_date;
	private String p_code;
	
	public ReviewBean() {}
	
	public ReviewBean(String re_code, String p_name, String m_id, String p_review, Date review_date, String p_code) {
		super();
		this.re_code = re_code;
		this.p_name = p_name;
		this.m_id = m_id;
		this.p_code = p_code;
		this.p_review = p_review;
		this.review_date = review_date;
	}

	
	public int getR_num() {
		return r_num;
	}

	public void setR_num(int r_num) {
		this.r_num = r_num;
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
	
	//추가한 p_name메소드_03.26_br
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_name() {
		return p_name;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	
	
}
	