package service;

import DAO.MemberDAO;
import entity.Post;

public class PostService {

	public Post makePost(String do_, String ci, String gungu, String dong, String be_addr) {

		Post p = new Post(do_ , ci, gungu, dong,be_addr);
		
		MemberDAO.getInstance();
		
		String[] post = MemberDAO.getPost_num_code();
		
		String post_code = post[0];
		String post_num = post[1];
		
		p.setPost_code(post_code);
		p.setPost_num(post_num);
		
		MemberDAO.setPost(p); //posttable 에 새로운 주소정보 넣었음
		
		return p;
	}

}
