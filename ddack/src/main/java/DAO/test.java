package DAO;

public class test {

	public static void main(String[] args) {
		String mat_code = "m5-1";
		mat_code= mat_code.split("-")[0].substring(0,1)+ Integer.toString(Integer.parseInt(mat_code.split("-")[0].substring(1))+1)+"-1";
		System.out.println(mat_code);
	}
}
