<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>신규 거래처 등록</title>
	<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
	<link href="css2/styles.css" rel="stylesheet" />
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
	<!-- 네비게이션바 -->
	<%@ include file="./main/include/layout/header.jsp"%>

	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<!-- 사이드바 -->
				<%@ include file="./main/include/layout/sidebar.jsp"%>
			</nav>
		</div>
		

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<!-- table 내용 -->
					<h1 class="mt-4">신규 거래처 등록하기</h1>

					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
						<li class="breadcrumb-item active">신규거래처 등록폼</li>
					</ol>
					
					<div class="card mb-4">
						<div class="card-body">
							고객만족을 위한 DDACK!<br> DDACK의 노력은 계속되어야 한다.
						</div>
					</div>
			       
			        <div class="card mb-4">
	                   <div class="card-header">
	                      <i class="fas fa-table me-1"></i>신규거래처등록_테이블
	                   </div>
													
				<div class="card-body">
 					 <form action="sup_reg_form.admin" method="post">
						 				
 					 <div class="form-floating mb-3">
							<input name="b_comp_code" class="form-control" type="text" placeholder="거래처코드 자동등록됨" readonly/>
							<label for="b_comp_code">거래처코드_자동등록</label> <!-- 시퀀스 이용 자동 입력됨 -->
					 </div>

 					 <div class="form-floating mb-3">
							<input name="b_comp_name" class="form-control" type="text" placeholder="거래처명" />
							<label for="b_comp_name">거래처명</label>
					 </div>
 					 
 					 <div class="form-floating mb-3">
							<input name="b_comp_tel" class="form-control" type="text" placeholder="거래처연락처" />
							<label for="b_comp_tel">거래처연락처</label>
					 </div>
					 	
							
					 <div class="form-floating mb-3">
					    	<input class="form-control" name="b_comp_addr" type="text" placeholder="거래처 주소" />
							<label for="b_comp_addr">거래처주소</label>
					 </div>

					 <div class="form-floating mb-3">
					 		<input class="form-control" name="b_email" type="text" placeholder="이메일 주소" />
							<label for="b_email">email</label>
					 </div>
						
					<div class="input-group mb-3">
					  <label class="input-group-text" for="inputGroupSelect">재료코드</label>
					  <select class="form-select" name="mat_code">
					    <option selected>재료코드</option>
					    <option value="m1-1">m1-1</option>
					    <option value="m2-1">m2-1</option>
					    <option value="m2-2">m2-2</option>
					    <option value="m2-3">m2-3</option>
					    <option value="m2-4">m2-4</option>
					    <option value="m3-1">m3-1</option>
 					    <option value="m4-1">m4-1</option>
  					   	<option value="m5-1">m5-1</option>
					  </select>
					</div>	

					<div class="form-floating mb-3">
						<input class="btn btn-success" type="submit" value="신규거래처등록" /> 
						<input type="button" class="btn btn-primary" value="뒤로가기" onclick="history.back(-1);">
					</div>

					  </form>
				    </div>
				  </div>
			    </div>
			  </main>
		    </div>
		  </div>
		
	<!-- footer -->
	<jsp:include page="/adminpage/main/include/layout/footer.jsp" />
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="js2/scripts.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
	<script src="js2/datatables-simple-demo.js"></script>
</body>
</html>