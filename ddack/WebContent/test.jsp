<%@page import="java.sql.SQLException"%>

<%@page import="db.JDBCUtility"%>

<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

</head>

<body>



	<%

		Connection conn  = null;

		try{

			conn = JDBCUtility.getConnection();

			conn.setAutoCommit(false);

			out.println("연결성공 : " + conn + "<br>");			

			conn.commit();

		}catch(SQLException e){

			out.println("연결실패 : " + e.getMessage() + "<br>");			

			JDBCUtility.rollback(conn);

		}finally{

			JDBCUtility.close(conn);

		}

	%>

</body>

</html>