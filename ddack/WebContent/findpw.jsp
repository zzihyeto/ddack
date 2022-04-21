<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String no_getpw = (String)request.getAttribute("no_getpw");
%>
<c:set var="no_getpw" value="<%= no_getpw %>"/>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>findpw.jsp</title>
	<link rel="stylesheet"	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
		integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"	crossorigin="anonymous">
	<!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="./assets1/favicon.ico" />
	<!-- Bootstrap icons-->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
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
						<c:if test="${!empty no_getpw}">
			            	<div class="alert alert-warning" role="alert">
								${no_getpw} 
							</div>
			            </c:if>
							<h3 class="text-center font-weight-light my-4">비밀번호 찾기</h3>
						</div>
						<div class="card-body">
							<form action="findpw.member" method="post">
								<div class="form-floating mb-3">
									<input class="form-control" id="id" type="text" name="id"/>
									<label for="id"> 
										<i class="bi bi-person"></i> ID
									</label>
								</div>
								<div class="form-floating mb-3">
									<input class="form-control" id="name" type="text" name="name"/>
									<label for="name"> 
										<i class="bi bi-emoji-smile"></i> 이름
									</label>
								</div>
								<div class="form-floating mb-3">
									<div class="form-floating mb-3">
										<input class="form-control" id="jumin" type="text" name="jumin" />
										<label for="jumin"> 
											<i class="bi bi-envelope"></i>주민번호
										</label>
									</div>
								</div>
								<div class="d-grid">
									<input type="submit" class="btn btn-warning btn-lg mb-3" value="비밀번호찾기" /> 
								</div>
							</form>
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