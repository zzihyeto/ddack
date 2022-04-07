package service;

import DAO.MemberDAO;
import entity.Member;
import entity.Post;

public class LoginCheckService {

	public boolean isLogin(String userID ,String inputPassword) {
		boolean ok_id_pw = false;
		
		
		ok_id_pw = MemberDAO.isLogin(userID,inputPassword);
		
		return ok_id_pw ;
	}

	public boolean isAmdin(String userID, String inputPassword) {

		boolean ok_admin = false;
		
		
		ok_admin = MemberDAO.isAdmin(userID, inputPassword);
		return ok_admin;
	}

	public Member getMember_info(String userID) {

		Member member_info = null;
		
		
		member_info = MemberDAO.getMember_info(userID);
		
		return member_info;
	}

	public Post getPost_info(String post_code) {
		
		Post post_info = null;
		
		
		post_info = MemberDAO.getPost_info(post_code);
		
		return post_info;
	}


}
