package service;

import DAO.MemberDAO;

public class LoginCheckService {

	public boolean isLogin(String userID ,String inputPassword) {
		boolean ok_id_pw = false;
		
		MemberDAO member = MemberDAO.getInstance();
		
		ok_id_pw = MemberDAO.isLogin(userID,inputPassword);
		
		return ok_id_pw ;
	}
}
