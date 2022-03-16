<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<%@page import="db.JDBCUtility"%>

<%@page import="java.sql.Connection"%>

<!DOCTYPE>

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

			out.println("연결성공 : " + conn + "<br>");			

			JDBCUtility.commit(conn);

		}catch(Exception e){

			out.println("연결실패 : " + e.getMessage() + "<br>");			

			JDBCUtility.rollback(conn);

		}finally{

			JDBCUtility.close(conn,null,null);

		}

	%>

</body>

</html>