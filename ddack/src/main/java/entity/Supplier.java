package entity;

import java.util.Date;

public class Supplier { //(외부) 거래처관련

	String b_order_code; //(외부)거래처주문코드
	String b_comp_code; //거래처 코드
	Date mat_order_d; //주문일자
	String mat_count; //주문 수량
	String exp_in_d; //예상입고일
	String tru_in_d; //실제입고일
	String quality; // 재료의 품질검사 O, X로 확인

	String month_p_code; 
	String month_pay;
	Date payment_d;

	String b_comp_name; //거래처명
	String b_comp_addr; //거래처주소
	String b_comp_tell; // 거래처 연락처( tell을 tel로 바꾸기)
	Date arrive_date; // 도착일자? 
	String mat_code;
	
	public Supplier() {}
	
	

	public Supplier(String b_order_code, String b_comp_code, Date mat_order_d, String mat_count, String exp_in_d,
			String tru_in_d, String quality, String month_p_code, String month_pay, Date payment_d, String b_comp_name,
			String b_comp_addr, String b_comp_tell, Date arrive_date, String mat_code) {
		super();
		this.b_order_code = b_order_code;
		this.b_comp_code = b_comp_code;
		this.mat_order_d = mat_order_d;
		this.mat_count = mat_count;
		this.exp_in_d = exp_in_d;
		this.tru_in_d = tru_in_d;
		this.quality = quality;
		this.month_p_code = month_p_code;
		this.month_pay = month_pay;
		this.payment_d = payment_d;
		this.b_comp_name = b_comp_name;
		this.b_comp_addr = b_comp_addr;
		this.b_comp_tell = b_comp_tell;
		this.arrive_date = arrive_date;
		this.mat_code = mat_code;
	}



	public String getB_order_code() {
		return b_order_code;
	}


	public void setB_order_code(String b_order_code) {
		this.b_order_code = b_order_code;
	}


	public String getB_comp_code() {
		return b_comp_code;
	}


	public void setB_comp_code(String b_comp_code) {
		this.b_comp_code = b_comp_code;
	}


	public Date getMat_order_d() {
		return mat_order_d;
	}


	public void setMat_order_d(Date mat_order_d) {
		this.mat_order_d = mat_order_d;
	}


	public String getMat_count() {
		return mat_count;
	}


	public void setMat_count(String mat_count) {
		this.mat_count = mat_count;
	}


	public String getExp_in_d() {
		return exp_in_d;
	}


	public void setExp_in_d(String exp_in_d) {
		this.exp_in_d = exp_in_d;
	}


	public String getTru_in_d() {
		return tru_in_d;
	}


	public void setTru_in_d(String tru_in_d) {
		this.tru_in_d = tru_in_d;
	}


	public String getQuality() {
		return quality;
	}


	public void setQuality(String quality) {
		this.quality = quality;
	}


	public String getMonth_p_code() {
		return month_p_code;
	}


	public void setMonth_p_code(String month_p_code) {
		this.month_p_code = month_p_code;
	}


	public String getMonth_pay() {
		return month_pay;
	}


	public void setMonth_pay(String month_pay) {
		this.month_pay = month_pay;
	}


	public Date getPayment_d() {
		return payment_d;
	}


	public void setPayment_d(Date payment_d) {
		this.payment_d = payment_d;
	}


	public String getB_comp_name() {
		return b_comp_name;
	}


	public void setB_comp_name(String b_comp_name) {
		this.b_comp_name = b_comp_name;
	}


	public String getB_comp_addr() {
		return b_comp_addr;
	}


	public void setB_comp_addr(String b_comp_addr) {
		this.b_comp_addr = b_comp_addr;
	}


	public String getB_comp_tell() {
		return b_comp_tell;
	}


	public void setB_comp_tell(String b_comp_tell) {
		this.b_comp_tell = b_comp_tell;
	}


	public Date getArrive_date() {
		return arrive_date;
	}


	public void setArrive_date(Date arrive_date) {
		this.arrive_date = arrive_date;
	}



	public String getMat_code() {
		return mat_code;
	}



	public void setMat_code(String mat_code) {
		this.mat_code = mat_code;
	}
	
	
	
	
}
