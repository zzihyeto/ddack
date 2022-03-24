package service;

import DAO.JoinDAO;

public class JoinService {
	
	public boolean registerMember(String id, String password, String name, String jumin, String phone, String email, 
			String do_, String ci, String gungu, String dong, String be_addr, String post_code ) {
		
		boolean regSucces = false;
		
		JoinDAO.getInstance();
		
		int regCount = JoinDAO.registerMember(id,password,name,jumin,phone,email,do_,ci,gungu,dong,be_addr, post_code );
		
		if(regCount>0) {
			regSucces = true;
		}
		return regSucces;
		
	}

}
