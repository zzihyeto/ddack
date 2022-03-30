package entity;

import java.util.Date;

public class MemOrder {

	String m_od_code;
	String m_name;
	String p_name;
	int p_count=0;
	Date order_date; //주문일
	Date dead_line; //마감일
	Date due_date; //납기일(실제받고 싶은 날짜)
	Date delay_date; //지연일
	
	public MemOrder() {}
	public MemOrder(String m_od_code, String m_name, String p_name, int p_count, Date order_date, Date due_date) {
		super();
		this.m_od_code = m_od_code;
		this.m_name = m_name;
		this.p_name = p_name;
		this.p_count = p_count;
		this.order_date = order_date;
		this.due_date = due_date;
	}
	public String getM_od_code() {
		return m_od_code;
	}
	public void setM_od_code(String m_od_code) {
		this.m_od_code = m_od_code;
	}
	
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_count() {
		return p_count;
	}
	public void setP_count(int p_count) {
		this.p_count = p_count;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public Date getDead_line() {
		return dead_line;
	}
	public void setDead_line(Date dead_line) {
		this.dead_line = dead_line;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Date getDelay_date() {
		return delay_date;
	}
	public void setDelay_date(Date delay_date) {
		this.delay_date = delay_date;
	}
	
	
}
