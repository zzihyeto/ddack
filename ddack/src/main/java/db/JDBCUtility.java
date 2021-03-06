package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCUtility {

	public static Connection getConnection() {

		Context initContext;
		Connection conn = null;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/ddack");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	

	public static void close(Connection conn,Statement stmt,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			//dummy
		}
	}
	public static void rollback(Connection conn) {

		try {if(conn!=null) conn.rollback(); } catch(SQLException e) {}
	}
	public static void commit(Connection conn) {
		
		try {if(conn!=null) conn.commit(); } catch(SQLException e) {}
	}
	
	
}
