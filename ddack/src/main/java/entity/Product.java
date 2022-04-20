package entity;

public class Product {

	String p_code;
	String p_name;
	String eq_code;
	String p_kg;
	String p_life;
	String p_pay;
	int p_kg_int;//처음에 string 타입으로 p_kg만들었는데 혹시 디비에 Int로 되어있어서 int용도 만듦
	
	int p_count_pay=0; 
	int p_count =0;
	int p_count_sum=0;
	
	String order_date; //주문일
	String dead_lin;//마감일(우리가 정한 납기일-5일전 기준) insert될때 계산시켜놓음 
	String due_date; //납기일(소비자가원하는 날짜)
	
	String invent_code; //창고 코드
	String invent_storname; //창고이름
	int invent_qty; //창고에 저장된 갯수
	int invent_total; // 창고에 최대 넣을 수 있는 공간
	
	String store_code;
	String store_name; //저장소 이름
	String store_loc; //저장소 위치
	
	
	
	
    public Product() {}
    

	public Product(String p_code, String p_name, String p_kg, String p_life, String p_pay) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
	
		this.p_kg = p_kg;
		this.p_life = p_life;
		this.p_pay = p_pay;
	}


	
	public String getDead_lin() {
		return dead_lin;
	}

	public void setDead_lin(String dead_lin) {
		this.dead_lin = dead_lin;
	}

	public int getP_count_sum() {
		return p_count_sum;
	}

	public void setP_count_sum(int p_count_sum) {
		this.p_count_sum = p_count_sum;
	}

	public String getStore_code() {
		return store_code;
	}

	public void setStore_code(String store_code) {
		this.store_code = store_code;
	}
	public int getP_kg_int() {
		return p_kg_int;
	}

	public void setP_kg_int(int p_kg_int) {
		this.p_kg_int = p_kg_int;
	}

	public String getInvent_code() {
		return invent_code;
	}

	public void setInvent_code(String invent_code) {
		this.invent_code = invent_code;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_loc() {
		return store_loc;
	}

	public void setStore_loc(String store_loc) {
		this.store_loc = store_loc;
	}

	public String getInvent_storname() {
		return invent_storname;
	}

	public void setInvent_storname(String invent_storname) {
		this.invent_storname = invent_storname;
	}

	public int getInvent_qty() {
		return invent_qty;
	}

	public void setInvent_qty(int invent_qty) {
		this.invent_qty = invent_qty;
	}

	public int getInvent_total() {
		return invent_total;
	}

	public void setInvent_total(int invent_total) {
		this.invent_total = invent_total;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public int getP_count() {
		return p_count;
	}

	public void setP_count(int p_count) {
		this.p_count = p_count;
	}

	public int getP_count_pay() {
		return p_count_pay;
	}

	public void setP_count_pay(int p_count_pay) {
		this.p_count_pay = p_count_pay;
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

	
	@Override
	public boolean equals(Object obj) {
		Product obj_p = (Product) obj;
		if (this.p_code.equals(obj_p.p_code)) {
			return true;
		}else {
			return false;
		}
	}
	
}
