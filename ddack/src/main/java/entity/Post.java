package entity;

public class Post {

	String post_code; 
	String post_num; 
	String do_; 
	String ci; 
	String gungu;	
	String dong; 
	String be_addr;
	
	public Post() {}

	public Post( String do_, String ci, String gungu, String dong, String be_addr) {
		super();
		this.do_ = do_;
		this.ci = ci;
		this.gungu = gungu;
		this.dong = dong;
		this.be_addr = be_addr;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	public String getPost_num() {
		return post_num;
	}

	public void setPost_num(String post_num) {
		this.post_num = post_num;
	}

	public String getDo_() {
		return do_;
	}

	public void setDo_(String do_) {
		this.do_ = do_;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getGungu() {
		return gungu;
	}

	public void setGungu(String gungu) {
		this.gungu = gungu;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getBe_addr() {
		return be_addr;
	}

	public void setBe_addr(String be_addr) {
		this.be_addr = be_addr;
	}
	
}
