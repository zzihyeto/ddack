package entity;

import java.util.Date;

public class BOM {

	String mat_code;
	String mat_name;
	String mat_type;
	String mat_unit;
	int mat_count=0;
	int mat_count_update=0;
	String mat_person;
	String mat_container_code;
	String mat_life_t;
	
	String clean_code;
	Date c_cycle_d;
	String c_check;
	
	public BOM() {};

	public BOM(String mat_code, String mat_name, String mat_type, String mat_unit, int mat_count) {
		super();
		this.mat_code = mat_code;
		this.mat_name = mat_name;
		this.mat_type = mat_type;
		this.mat_unit = mat_unit;
		this.mat_count = mat_count;
	}

	
	public int getMat_count_error() {
		return mat_count_update;
	}

	public void setMat_count_error(int mat_count_update) {
		this.mat_count_update = mat_count_update;
	}

	public Date getC_cycle_d() {
		return c_cycle_d;
	}

	public void setC_cycle_d(Date c_cycle_d) {
		this.c_cycle_d = c_cycle_d;
	}

	public String getC_check() {
		return c_check;
	}

	public void setC_check(String c_check) {
		this.c_check = c_check;
	}

	public String getMat_code() {
		return mat_code;
	}

	public void setMat_code(String mat_code) {
		this.mat_code = mat_code;
	}

	public String getMat_name() {
		return mat_name;
	}

	public void setMat_name(String mat_name) {
		this.mat_name = mat_name;
	}

	public String getMat_type() {
		return mat_type;
	}

	public void setMat_type(String mat_type) {
		this.mat_type = mat_type;
	}

	public String getMat_unit() {
		return mat_unit;
	}

	public void setMat_unit(String mat_unit) {
		this.mat_unit = mat_unit;
	}

	public int getMat_count() {
		return mat_count;
	}

	public void setMat_count(int mat_count) {
		this.mat_count = mat_count;
	}

	public String getMat_person() {
		return mat_person;
	}

	public void setMat_person(String mat_person) {
		this.mat_person = mat_person;
	}

	public String getMat_container_code() {
		return mat_container_code;
	}

	public void setMat_container_code(String mat_container_code) {
		this.mat_container_code = mat_container_code;
	}

	public String getMat_life_t() {
		return mat_life_t;
	}

	public void setMat_life_t(String mat_life_t) {
		this.mat_life_t = mat_life_t;
	}

	public String getClean_code() {
		return clean_code;
	}

	public void setClean_code(String clean_code) {
		this.clean_code = clean_code;
	};
	
	
}
