package DAO;

import java.sql.Connection;
import java.util.List;

import entity.Release;

public class ReleaseDAO {
	
	private ReleaseDAO() {}
	private static ReleaseDAO instance;
	public static ReleaseDAO getInstance() {
		if(instance ==null) instance = new ReleaseDAO();
		return instance;
	}
	
	private static Connection conn = null;
	
	public List<Release> re_order() {
	
		return null;
	}
	

}
