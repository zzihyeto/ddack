package entity;

import java.security.Timestamp;
import java.util.Date;


public class Production_manage {

	String start_od_code;
	int total_date;
	Date begin_date;
	Date end_date;
	
	String ch_pro_code;
	String p_code;
	String mat_code1;
	String mat_code2;
	String mat_code3;
	String mat_code4;
	String cook_code;
	Date mk_time;
	String mk_ps_code;
	String line_code;
	String clean_code;
	String q_code;
	
	public Production_manage() {};		
	
	public Production_manage(String start_od_code, int total_date, Date begin_date, Date end_date,
			String ch_pro_code, String p_code, String mat_code1, String mat_code2, String mat_code3, String mat_code4,
			String cook_code, Date mk_time, String mk_ps_code, String line_code, String clean_code, String q_code) {
	
		super();
		this.start_od_code = start_od_code;
		this.total_date = total_date;
		this.begin_date = begin_date;
		this.end_date = end_date;
		this.ch_pro_code = ch_pro_code;
		this.p_code = p_code;
		this.mat_code1 = mat_code1;
		this.mat_code2 = mat_code2;
		this.mat_code3 = mat_code3;
		this.mat_code4 = mat_code4;
		this.cook_code = cook_code;
		this.mk_time = mk_time;
		this.mk_ps_code = mk_ps_code;
		this.line_code = line_code;
		this.clean_code = clean_code;
		this.q_code = q_code;
	}
	
	public String getStart_od_code() {
		return start_od_code;
	}
	
	public void setStart_od_code(String start_od_code) {
		this.start_od_code = start_od_code;
	}
	
	public int getTotal_date() {
		return total_date;
	}
	
	public void setTotal_date(int total_date) {
		this.total_date = total_date;
	}
	
	public String getCh_pro_code() {
		return ch_pro_code;
	}
	
	public void setCh_pro_code(String ch_pro_code) {
		this.ch_pro_code = ch_pro_code;
	}
	
	public String getP_code() {
		return p_code;
	}
	
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	
	public String getMat_code1() {
		return mat_code1;
	}
	
	public void setMat_code1(String mat_code1) {
		this.mat_code1 = mat_code1;
	}
	
	public String getMat_code2() {
		return mat_code2;
	}
	
	public void setMat_code2(String mat_code2) {
		this.mat_code2 = mat_code2;
	}
	
	public String getMat_code3() {
		return mat_code3;
	}
	
	public void setMat_code3(String mat_code3) {
		this.mat_code3 = mat_code3;
	}
	
	public String getMat_code4() {
		return mat_code4;
	}
	
	public void setMat_code4(String mat_code4) {
		this.mat_code4 = mat_code4;
	}
	
	public String getCook_code() {
		return cook_code;
	}
	
	public void setCook_code(String cook_code) {
		this.cook_code = cook_code;
	}
	

	
	public Date getMk_time() {
		return mk_time;
	}

	public void setMk_time(Date mk_time) {
		this.mk_time = mk_time;
	}

	public String getMk_ps_code() {
		return mk_ps_code;
	}
	
	public void setMk_ps_code(String mk_ps_code) {
		this.mk_ps_code = mk_ps_code;
	}
	
	public String getLine_code() {
		return line_code;
	}
	
	public void setLine_code(String line_code) {
		this.line_code = line_code;
	}
	
	public String getClean_code() {
		return clean_code;
	}
	
	public void setClean_code(String clean_code) {
		this.clean_code = clean_code;
	}
	
	public String getQ_code() {
		return q_code;
	}
	
	public void setQ_code(String q_code) {
		this.q_code = q_code;
	}

	public Date getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	
	
	
	
}
