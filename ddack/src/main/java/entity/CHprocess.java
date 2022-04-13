package entity;

import java.util.Date;

public class CHprocess {

	String line_code;
	String line_name;
	String line_usable;
	String ch_pro_code;
	Date check_date;
	String check_content;
	
	String q_code;
	String q_result;
	
	public CHprocess() {}

	public String getQ_code() {
		return q_code;
	}


	public String getLine_code() {
		return line_code;
	}

	public void setLine_code(String line_code) {
		this.line_code = line_code;
	}

	public void setQ_code(String q_code) {
		this.q_code = q_code;
	}


	public String getQ_result() {
		return q_result;
	}


	public void setQ_result(String q_result) {
		this.q_result = q_result;
	}


	public String getLine_name() {
		return line_name;
	}

	public void setLine_name(String line_name) {
		this.line_name = line_name;
	}

	public String getLine_usable() {
		return line_usable;
	}

	public void setLine_usable(String line_usable) {
		this.line_usable = line_usable;
	}

	public String getCh_pro_code() {
		return ch_pro_code;
	}

	public void setCh_pro_code(String ch_pro_code) {
		this.ch_pro_code = ch_pro_code;
	}

	public Date getCheck_date() {
		return check_date;
	}

	public void setCheck_date(Date check_date) {
		this.check_date = check_date;
	}

	public String getCheck_content() {
		return check_content;
	}

	public void setCheck_content(String check_content) {
		this.check_content = check_content;
	};
	
}
