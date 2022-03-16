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

		} catch (NamingException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return conn;

	}

	

	public static void close(ResultSet rs) {

		try {

			if (rs != null)	rs.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public static void close(Statement stmt) {

		try {

			if (stmt != null)	stmt.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public static void close(Connection conn) {

		try {

			if (conn != null)	conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public static void rollback(Connection conn) {

		try {

			if (conn != null)	conn.rollback();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
}
