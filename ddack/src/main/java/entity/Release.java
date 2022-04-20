package entity;

import java.util.Date;

public class Release {
	
	String p_code;
	String m_code;
	String eq_code;
	String p_name;
	int    p_count=0;
	String io_cd;
	Date io_time; 
	
	String pro_code;
	String mem_code;
	int pro_count;
	Date re_date;
	
	public Release() {}
	
	public Release(String p_code, String m_code, String eq_code, int p_count) {
		super();
		this.p_code = p_code;
		this.m_code = m_code;
		this.eq_code = eq_code;
		this.p_count = p_count;
	}
	
	public String getIo_cd() {
		return io_cd;
	}

	public void setIo_cd(String io_cd) {
		this.io_cd = io_cd;
	}

	public Date getIo_time() {
		return io_time;
	}

	public void setIo_time(Date io_time) {
		this.io_time = io_time;
	}

	public String getP_code() {
		return p_code;
	}


	public void setP_code(String p_code) {
		this.p_code = p_code;
	}


	public String getM_code() {
		return m_code;
	}


	public void setM_code(String m_code) {
		this.m_code = m_code;
	}


	public String getEq_code() {
		return eq_code;
	}


	public void setEq_code(String eq_code) {
		this.eq_code = eq_code;
	}


	public int getP_count() {
		return p_count;
	}


	public void setP_count(int p_count) {
		this.p_count = p_count;
		
	}

	public String getP_name() {
		return p_name;
		
	}
	
	
	public void setP_name(String p_name) {
		this.p_name = p_name;
		
	}
	
	 public String getPro_code() {
		return pro_code;
		
	}

	public void setPro_code(String pro_code) {
		this.pro_code = pro_code;
		
	}

	public String getMem_code() {
		return mem_code;
		
	}

	public void setMem_code(String mem_code) {
		this.mem_code = mem_code;
		
	}

	
	public int getPro_count() {
		return pro_count;
		
	}

	
	public void setPro_count(int pro_count) {
		this.pro_count = pro_count;
		
	}

	public Date getRe_date() {
		return re_date;
		
	}

	
	public void setRe_date(Date re_date) {
		this.re_date = re_date;
		
	}
}
