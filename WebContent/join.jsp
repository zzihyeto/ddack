<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content />
<meta name="author" content />
<title>join.jsp</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="./css1/styles.css" rel="stylesheet" />
</head>

<body class="d-flex flex-column">
	<main class="flex-shrink-0">
		<!-- layout폴더 > navbar.jsp -->
		<jsp:include page="./layout/navbar.jsp" />
		
  <section class="py-5">
		<div class="container px-5">
		  <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
			<div class="row justify-content-center">
			<div class="col-lg-7">
						<div class="text-center mb-5">
							<div class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
								<i class="bi bi-envelope"></i>
							</div>
							<h1 class="fw-bolder">회원가입</h1>
							<p class="lead fw-normal text-muted mb-0">
								당신의 건강한 삶을 위해<br> DDACK이 응원한다!!
							</p>
						</div>

						<div class="card-body">
							<form>
								<div class="form-floating mb-3">
									<input class="form-control" id="id" type="text"
										placeholder="user id....." /> <label for="id">id</label>
								</div>
								<div class="row mb-3">
									<div class="col-md-6">
										<div class="form-floating mb-3 mb-md-0">
											<input class="form-control" id="inputFirstName" type="text"
												placeholder="Enter your first name" /> <label
												for="inputFirstName">이름</label>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-floating">
											<input class="form-control" id="inputLastName" type="text" placeholder="Enter your last name" /> 
											<label for="inputLastName">성</label>
										</div>
									</div>
								</div>
								<div class="form-floating mb-3">
									<input class="form-control" id="inputEmail" type="email" placeholder="name@example.com" /> 
									<label for="inputEmail">Email주소</label>
								</div>
								<div class="row mb-3">
									<div class="col-md-6">
										<div class="form-floating mb-3 mb-md-0">
											<input class="form-control" id="inputPassword" type="password" placeholder="Create a password" /> 
											<label for="inputPassword">비밀번호</label>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-floating mb-3 mb-md-0">
											<input class="form-control" id="inputPasswordConfirm" type="password" placeholder="Confirm password" />
											 <label for="inputPasswordConfirm">비밀번호확인</label>
										</div>
									</div>
								</div>

								<div class="row mb-3">
									<div class="col-md-6">
										<div class="form-floating mb-3 mb-md-0">
											<input class="form-control" id="jumin" type="text" placeholder="주민번호를 입력하세요" />
											 <label for="jumin">주민번호</label>
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-floating mb-3 mb-md-0">
											<input class="form-control" id="phone" type="text" placeholder="연락처를 입력하세요" />
											 <label for="phone">연락처</label>
										</div>
									</div>
								</div>

								<div class="d-none" id="submitSuccessMessage">
									<div class="text-center mb-3">
										<div class="fw-bolder">Form submission successful!</div>
										To activate this form, sign up at <br /> <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
									</div>
								</div>
								<!-- Submit error message-->
								<!---->
								<!-- This is what your users will see when there is-->
								<!-- an error submitting the form-->
								<div class="d-none" id="submitErrorMessage">
									<div class="text-center text-danger mb-3">Error sending message!</div>
								</div>
								<!-- Submit Button-->
								<div class="d-grid">
									<button class="btn btn-warning btn-lg disabled"	id="submitButton" type="submit"><a href="login.jsp">회원가입</a></button>
								</div>
							</form>
						</div>
						<div class="card-footer text-center py-3">
							<div class="small">
								<a href="login.jsp">건강하고 싶나요? 로그인하십쇼.</a>
							</div>
					
					 </div>
			 	</div>
			</div>
			</div>
		</div>
	</section>
	</main>

	<!-- layout폴더 > footer.jsp -->
	<jsp:include page="./layout/footer.jsp" />

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="./js1/scripts.js"></script>
</body>
</html>