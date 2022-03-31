package entity;

import java.util.Date;

public class CHprocess {

	String line_name;
	String line_usable;
	String ch_pro_code;
	Date check_date;
	String check_content;
	
	public CHprocess() {}

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
