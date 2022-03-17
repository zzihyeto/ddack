package entity;

public class Product {

	String p_code;
	String p_name;
	String eq_code;
	String p_kg;
	String p_life;
	String p_pay;

	public Product() {}

	public Product(String p_code, String p_name, String p_kg, String p_life, String p_pay) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
	
		this.p_kg = p_kg;
		this.p_life = p_life;
		this.p_pay = p_pay;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getEq_code() {
		return eq_code;
	}

	public void setEq_code(String eq_code) {
		this.eq_code = eq_code;
	}

	public String getP_kg() {
		return p_kg;
	}

	public void setP_kg(String p_kg) {
		this.p_kg = p_kg;
	}

	public String getP_life() {
		return p_life;
	}

	public void setP_life(String p_life) {
		this.p_life = p_life;
	}

	public String getP_pay() {
		return p_pay;
	}

	public void setP_pay(String p_pay) {
		this.p_pay = p_pay;
	}

	
	
	
}
