<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>m_deleteFrom.jsp</title>
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
	<script language="javascript">
		
		function check() {
			if(!document.delform.pw.value) {
				alert("비밀번호를 입력하지 않으셨습니다.");
				return false;
			}
		}
	
	</script>
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
							<h3 class="text-center font-weight-light my-4">Secession Page</h3>
						</div>
						<div class="card-body">
						<form name="delform" action="deletePro.jsp" method="post" onsubmit="return check()">
								<div class="form-floating mb-3">
									<input class="form-control" id="password" type="text" name="pw"/>
									<label for="password"> <i class="bi bi-key"></i> 비밀번호를 입력해주세요.</label>
								</div>
								<div class="d-grid">
									<input type="submit" class="btn btn-warning btn-lg mb-3" value="secession"/>
									<input type="button" class="btn btn-danger btn-lg mb-3" value="Go To Main" onclick="location.href='./index.jsp'"/>
								</div>
							</div>	
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
	<!-- layout폴더 > footer.jsp -->
	<jsp:include page="./layout/footer.jsp" />
</body>
</html>