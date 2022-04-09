<%@ page import="entity.MemOrder"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>신규거래처등록</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<link href="css2/styles.css" rel="stylesheet"/>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
	<!-- 네비게이션바 -->
	<jsp:include page="/adminpage/main/include/layout/header.jsp" />

	<div id="layoutAuthentication">
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<div id="layoutAuthentication_content">
						<div class="container">
							<div class="row justify-content-center">
								<div class="col-lg-7">
									<div class="card shadow-lg border-0 rounded-lg mt-5">
										<div class="card-header">
											<h3 class="text-center font-weight-light my-4">신규거래처등록</h3>
										</div>
															
					<div class="card-body">
 					 <form action="sup_reg_form.admin" method="post">
						<div class="input-group mb-3">
						  <span class="input-group-text" name="b_comp_code">거래처 코드</span>
						  <input type="text" class="form-control" name="b_comp_code" aria-describedby="basic-addon3" placeholder="자동생성됨" readonly/>
						</div>
						
						<div class="row mb-3">
							<div class="col-md-6">
								<div class="form-floating">
									<input class="form-control" name="b_comp_name" type="text" placeholder="거래처명" /> 
									<label for="b_comp_name">거래처명</label>
								</div>
							</div>
							
							<div class="col-md-6">
								<div class="form-floating">
									<input class="form-control" name="b_comp_tel" type="text" placeholder="거래처전화번호" /> 
									<label for="b_comp_tel">거래처연락처</label>
								</div>
							</div>
						</div>
							
						<div class="form-floating mb-3">
							<input class="form-control" name="b_comp_addr" type="text" placeholder="거래처 주소" />
							<label for="b_comp_addr">거래처 주소</label>
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
					
						<div class="mt-4 mb-0">
							<div class="d-grid">
								<input type="submit" class="btn btn-primary btn-block" value="신규거래처등록">
							</div>
						</div>
						
					 </form>
					</div>
				</div>
			</div>
			</div>
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