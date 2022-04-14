<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String register_msg = (String) session.getAttribute("Register");
	String no_login = (String) session.getAttribute("no_login");
	String pw_error = (String) request.getAttribute("pw_error");

%>
<c:set var="register_msg" value="<%= register_msg %>"/>
<c:set var="no_login" value="<%= no_login %>"/>
<c:set var="pw_error" value="<%= pw_error %>"/>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>login_form.jsp</title>
	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
		integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
		crossorigin="anonymous">
	<!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
	<!-- Bootstrap icons-->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
		rel="stylesheet" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="./css1/styles.css" rel="stylesheet" />
</head>

<body class="d-flex flex-column">
	<div id="layoutAuthentication">
	    <div id="layoutAuthentication_content">
	        <main>
	         <!-- layout폴더 > navbar.jsp -->
	   		<jsp:include page="./layout/navbar.jsp" />	
            
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="card shadow-lg border-0 rounded-lg my-5">
                            <div class="card-header">
	                            <h3 class="text-center font-weight-light my-4">
	                            	Login
	                            </h3>
	                            <!-- 로긴안해서 삭제 권한없음 -->
	                            <c:if test="${!empty no_login}">
            						<div class="bg-danger text-white">
										${ no_login }
									</div>
					            </c:if>
								
								<c:if test="${!empty pw_error}">
					            	<div class="bg-danger text-white">
										${ pw_error }
									</div>
					            </c:if> 
					            <c:if test="${!empty register_msg}">
					            	<div class="alert alert-warning" role="alert">
										${register_msg} 했습니다. 로그인해주세요.
									</div>
					            </c:if>
                            </div>
                            <div class="card-body">
                                <form action="login.check" method="post">
                                    <div class="form-floating mb-3">
                                        <input name="userID" class="form-control" id="userID" type="text" placeholder="ID..." />
                                        <label for="userID">Id</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="inputPassword" class="form-control" id="inputPassword" type="password" placeholder="PW..."/>
                                        <label for="inputPassword">Password</label>
                                    </div>
                                    <div class="form-check mb-3">
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                        <a class="small" href="#" >비밀번호 찾기</a>
                                        <button type="submit" class="btn btn-warning">Login</button>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer text-center py-3">
                                <div class="small">
                                	<a href="join_form.jsp" class="btn btn-warning">회원가입</a>
                                </div>
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
	        </main>
	    </div>
	</div>
     <!-- layout폴더 > footer.jsp -->
	<jsp:include page="./layout/footer.jsp" />
    
</body>
</html>