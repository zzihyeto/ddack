<%@ page import="entity.Post" %>
<%@ page import="entity.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Member member_info = (Member) session.getAttribute("member_info");
	
	Post post_info = (Post) session.getAttribute("post_info");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>member.jsp</title>
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
	<main class="flex-shrink-0">
		<!-- layout폴더 > navbar.jsp -->
		<jsp:include page="./layout/navbar.jsp" />
	
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card shadow-lg border-0 rounded-lg my-5">
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">성공적으로 수정되었습니다.</h3>
							
						</div>
						
						<div class="card-body">
								<div class="form-floating mb-3">
									<input class="form-control" id="name" type="text" name="name" value="${member_info.m_name }"readonly="readonly"/>
									<label for="name"> 
										<i class="bi bi-emoji-smile"></i> 이름
									</label>
								</div>
								<div class="form-floating mb-3">
									<div class="form-floating mb-3">
										<input class="form-control" id="id" type="text" name="id" value="${member_info.m_id }" readonly="readonly" />
										<label for="name"> 
											<i class="bi bi-person"></i> 아이디
										</label>
									</div>
								</div>
								
								<div class="form-floating mb-3">
									<input class="form-control" id="jumin" type="text" name="jumin" value="${member_info.m_jumin }" readonly="readonly"/>
									<label for="jumin"> 
										<i class="bi bi-credit-card-2-front"></i> 주민번호
									</label>
								</div>
								<div class="form-floating mb-3">
									<input class="form-control" id="email" type="text" name="email" value="${member_info.m_email }" readonly="readonly"/>
									<label for="email"> 
										<i class="bi bi-envelope"></i> Email
									</label>
								</div>
								<div class="form-floating mb-3">
									<div class="form-floating mb-3 mb-md-0">
										<input class="form-control" id="phone" type="text" name="phone" value="${member_info.m_phone }" readonly="readonly"/>
										<label for="phone">
											<i class="bi bi-telephone"></i> 연락처
										</label>
									</div>
								</div>
								<div class="form-floating mb-3">
									<div class="row">
										<div class="col-md-4">
											<div class="form-floating mb-3">
												<input class="form-control" id="" type="text" name="do_" value="${post_info.do_}" readonly="readonly"/> 
												<label for="do">도</label>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-floating mb-3">
												<input class="form-control" id="" type="text" name="ci" value="${post_info.ci}"readonly="readonly"/>
												<label for="ci">시</label>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-floating mb-3">
												<input class="form-control" id="" type="text" name="gungu" value="${post_info.gungu}" readonly="readonly"/>
												<label for="gungu">구/군</label>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="form-floating mb-3">
												<input class="form-control" id="" type="text" name="dong" value="${post_info.dong}"readonly="readonly"/>
												<label for="dong">동/읍</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-floating mb-3">
												<input class="form-control" id="" type="text" name="be_addr" value="${post_info.be_addr}"readonly="readonly"/>
												<label for="be_addr"> 
													<i class="bi bi-house-heart"></i>
													상세주소
												</label>
											</div>
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
</body>
</html>