<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.Integer"%>
<%
	request.setCharacterEncoding("utf-8");

	List<String> matcodes = (List<String>)session.getAttribute("matcodes");
	request.setAttribute("matcodes", matcodes);
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>발주서 작성</title>
	<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
	<link href="css2/styles.css" rel="stylesheet" />
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
	<!-- 네비게이션바 -->
	<%@ include file="./main/include/layout/header.jsp"%>

	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
				<!-- 사이드바 -->
				<%@ include file="./main/include/layout/sidebar.jsp"%>
			</nav>
		</div>

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<!-- table 내용 -->
					<h1 class="mt-4">발주서 작성하기</h1>

					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
						<li class="breadcrumb-item active">발주 관리</li>
					</ol>
					<div class="card mb-4">
						<div class="card-body">
							고객만족을 위한 DDACK!<br> DDACK의 노력은 계속되어야 한다. 
							<a target="_blank" href="https://datatables.net/">official DataTables documentation</a> 
							.
						</div>
					</div>
		
		<!-- 네비탭바 -->
          <ul class="nav nav-tabs mb-4">
			 <li class="nav-item">
		    	<a class="nav-link active" href="pur_choice_form.jsp">발주서 작성하기</a>
			 </li>
			 <li class="nav-item">
		    	<a class="nav-link" href="pur_manage.admin">발주관리</a>
			 </li>
		   </ul>   
		   
		   <!--발주서 폼  -->
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table me-1"></i>발주서 작성
					</div>
						
					<div class="card-body">

							<div class="input-group mb-3">
								<span class="input-group-text" >발주코드</span>
								<input type="text" class="form-control" name="b_order_code"	aria-describedby="basic-addon3" placeholder="자동생성됨" readonly />
							</div><!--시퀀스로 자동입력되게  -->
							
						<!-- 재료코드로 주문필요 수량 검색 -->
						<form class="d-flex" action="order_stock.admin">
						  <div class="form-floating row g-3">
							<div class="input-group mb-3"> 
								<label class="input-group-text" for="inputGroupSelect">재료코드</label>
									<select class="form-select me-5" name="mat_code">
										<c:if test="${ !empty matcodes }">
											<c:forEach var="mat_code" items="${ matcodes }">
												<option value="${ mat_code }">${ mat_code }</option>
											</c:forEach>
										</c:if>
									</select>											 
									<!--원재료 코드별 주문가능 수량은? 수량 알려주는 것-->
									<input name="#" class="form-control me-2" type="text" placeholder="주문가능수량" readonly>
									<button class="btn btn-outline-success" type="submit">주문가능 수량체크</button>
								
							</div>
						</div>
					    </form>
							
							<div class="form-floating mb-3">
								<div class="input-group mb-3">
									<!-- 재료코드에 따른 발주회사코드 option으로 선택할수 있도록  -->
									<label class="input-group-text" for="inputGroupSelect" >발주회사코드</label>
										
								</div>
							</div>
							

								<div class="form-floating mb-3">
									<input name="mat_count" class="form-control" type="text" placeholder="주문수량" readonly="readonly"/>
									<label for="mat_count">주문수량</label>
								</div>

								<div class="form-floating mb-3">
									<input name="mat_order_d" class="form-control" type="text" placeholder="주문일자" readonly="readonly"/>
									<label for="mat_order_d">주문일자</label>
								</div>

								<div class="form-floating mb-3">
									<input class="btn btn-success" type="submit" value="발주서등록" /> 
									<input type="button" class="btn btn-primary" value="뒤로가기" onclick="history.back(-1);">
								</div>

						</div>
					</div>
				</div>
			</main>
		</div>
	</div>

	<!-- footer -->
	<jsp:include page="/adminpage/main/include/layout/footer.jsp" />

	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="js2/scripts.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"	crossorigin="anonymous"></script>
	<script src="js2/datatables-simple-demo.js"></script>
</body>
</html>