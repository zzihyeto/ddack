<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content />
<meta name="author" content />
<title>memberinfo.jsp</title>
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
		<div class="container">
			<div class="row justify-content-center">
				 <div class="col-lg-8">
				 	<div class="card shadow-lg border-0 rounded-lg my-5">
				 		<div class="card-header">
				 			<h3 class="text-center font-weight-light my-4">MY Page</h3>	
				 		</div>
				 		<div class="card-body">
				 			<table align="center">
				 			<tr>
				 				<td>ID</td>
				 			</tr>
				 			<tr>
				 				<td>Password</td>
				 			</tr>
				 			<tr>
				 				<td>Name</td>
				 			</tr>
				 			<tr>
				 				<td>Jumin</td>
				 			</tr>
				 			<tr>
				 				<td>Phone</td>
				 			</tr>
				 			<tr>
				 				<td>Email</td>
				 			</tr>
				 			<tr>
				 				<td>Address</td>
				 			</tr>
				 			</table>
				 		</div>
				 	<input type="button" class="btn btn-warning mr-md-3" value="회원수정"
							onclick="location.href='update_form.jsp'"/>
					<input type="button" class="btn btn-danger" value="회원탈퇴"
						onclick="location.href='delete_form'"/>
				   </div>
				</div>
			</div>
		</div>
</main>

     <!-- layout폴더 > footer.jsp -->
	<jsp:include page="./layout/footer.jsp" />
</body>
</html>