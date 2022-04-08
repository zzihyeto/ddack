<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//회원가입 실패&성공 후 메세지
	String Regis_msg = (String)request.getAttribute("Register");
%>
<c:set var="register_msg" value="<%= Regis_msg %>"/>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>join.jsp</title>
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
<div id="layoutAuthentication">
	    <div id="layoutAuthentication_content">

	<main class="flex-shrink-0">
		<!-- layout폴더 > navbar.jsp -->
		<jsp:include page="./layout/navbar.jsp" />
		<c:if test="${!empty register_msg}">
	        <div class="alert alert-warning" role="alert">
	          ${register_msg} 했습니다. 다시 입력해주세요.
	        </div>
	    </c:if>
		<section class="py-5">
			<div class="container px-5">
				<div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
					<div class="row justify-content-center">
						<div class="card-header">
							<div class="text-center font-weight-light my-4">
								<div class="feature bg-success bg-gradient text-white rounded-3 mb-5">
									<i class="bi bi-envelope"></i>
								</div>
								<h1 class="fw-bolder">회원가입</h1>
								<p class="lead fw-normal text-muted mb-0">
									당신의 건강한 삶을 위해<br> DDACK이 응원합니다!!
								</p>
							</div>

							<div class="card-body">
								<form action="join.member" method="post">
									<div class="form-floating mb-3">
										<input class="form-control" id="name" type="text" name="name" placeholder="user name....." /> 
											<label for="name"><i class="bi bi-emoji-smile"></i> 이름
										</label>
									</div>
									
									<div class="form-floating mb-3">
										<div class="row">
											<div class="col-md-8">
												<div class="form-floating mb-3">
													<input class="form-control" id="userId" type="text" name="id"
														placeholder="user id....." onkeydown="inputIdChk()" /> 
														<label for="id"> <i class="bi bi-person"></i> 아이디</label>
													<input type="hidden" name="idDuplication" value="idUncheck"/>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-floating mb-3">
												<input type="button" class="form-control btn btn-primary" value="중복확인" onclick="openIdChk()" />
												<!--  <a href="duplicate.member" class="form-control btn btn-primary">ID중복체크 </a>-->
												</div>
											</div>
										</div>
									</div>
									
									<div class="form-floating mb-3">
										<input class="form-control" id="password" type="password" name="password" placeholder="Create a password" /> 
										<label for="password"> <i class="bi bi-key"></i> 비밀번호</label>
									</div>
									<div class="form-floating mb-3">
										<input class="form-control" id="jumin" type="text" placeholder="주민등록번호를 입력하세요." name="jumin" />
										 <label for="jumin"> <i class="bi bi-credit-card-2-front"></i> 주민번호</label>
									</div>
									
									<div class="form-floating mb-3">
										<input class="form-control" id="email" type="text" name="email" placeholder="name@example.com"/> 
											<label for="email"><i class="bi bi-envelope"></i> Email</label>
									</div>
									<div class="form-floating mb-3">
										<div class="form-floating mb-3 mb-md-0">
											<input class="form-control" id="phone" type="text" name="phone" placeholder="연락처를 입력하세요"/>
											 <label for="phone"><i class="bi bi-telephone"></i> 연락처</label>
										</div>
									</div>
									<div class="form-floating mb-3">
										<div class="row">
											<div class="col-md-4">
												<div class="form-floating mb-3">
													<input class="form-control" id="" type="text" name="do_"
														placeholder="name@example.com" /> <label for="do">도</label>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-floating mb-3">
													<input class="form-control" id="" type="text" name="ci"
														placeholder="연락처를 입력하세요" /> <label for="ci">시</label>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-floating mb-3">
													<input class="form-control" id="" type="text" name="gugun"
														placeholder="name@example.com" /> <label for="gungu">구/군</label>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-floating mb-3">
													<input class="form-control" id="" type="text" name="dong"
														placeholder="name@example.com" /> <label for="dong">동/읍</label>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-floating mb-3">
													<input class="form-control" id="" type="text"name="be_addr" placeholder="연락처를 입력하세요" /> 
														<label for="be_addr"> <i class="bi bi-house-heart"></i>상세주소</label>
												</div>
											</div>
										</div>
									</div>


									<!-- Submit Button-->
									<div class="d-grid">
										<input type="submit" class="btn btn-warning btn-lg" value="회원가입" />
									</div>
								</form>
							</div>
							<div class="card-footer text-center py-3">
								<div class="small">
									<a href="./login_form.jsp" class="btn btn-success btn-lg">로그인하기</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</div>
		</div>
	</main>

	<!-- layout폴더 > footer.jsp -->
	<jsp:include page="./layout/footer.jsp" />
	
	<script>
		function checkValue(){
			var form = document.userInfo;
			if(!form.id.value){
				alert("아이디를 입력하세요!");
				return false;
			}
			if(form.idDuplication.value != "idCheck"){
				alert("아이디 중복체크를 해주세요.");
			}
			if(!form.password.value){
				alert("비밀번호를 입력하세요");
				return false;
			}
			//비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
			if(form.password.value != form.passwordcheck.value){
				alert("비밀번호를 동일하게 입력하세요.");
				return false;
			}
			if(!form.name.value){
				alert("이름을 입력하세요.");
				return false;
			}
		}
		function openIdChk(){
			window.name="parentForm";
			window.open("./IdCheckForm.jsp",
					"chkForm","width=500,height=300,resizable=no,scrollbars=no");
		}
		//아이디 입력창에 값 입력시 hidden에 idUncheck를 세팅한다.
		//이렇게 하는 이유는 중복체크 후 다이 아이디 창이 새로운 아이디를 입력했을 때 다시중복체크를 하도록 한다.
		function inputIdChk(){
			document.userInfo.idDuplication.vale="idUncheck";
		}
	</script>
	</div>
</div>
</body>
</html>