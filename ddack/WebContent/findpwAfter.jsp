<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String getpw = (String)request.getAttribute("getpw");
%>
<c:set var="getpw" value="<%= getpw %>"/>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>findpw.jsp</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
		integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	<!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="./assets1/favicon.ico" />
	<!-- Bootstrap icons-->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="./css1/styles.css" rel="stylesheet" />
</head>
<body class="d-flex flex-column">
	<main class="flex-shrink-0">
		<!-- layout폴더 > navbar.jsp -->
		<jsp:include page="./layout/navbar.jsp" />
	
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card shadow-lg border-0 rounded-lg my-5">
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">비밀번호 찾기완료</h3>
						</div>
						<div class="card-body">
							<div class="form-floating mb-3">
								<input class="form-control" id="password" type="text" name="password" value="${ getpw }"/>
								<label for="password"> 
								<i class="bi bi-person"></i> 비밀번호</label>
							</div>
							<div class="d-grid">
								<input type="button" class="btn btn-warning btn-lg mb-3" value="로그인화면으로 돌아가기" onclick="location.href='./login_form.jsp'" /> 
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<!-- layout폴더 > footer.jsp -->
	<jsp:include page="./layout/footer.jsp" />
</body>
</html>