<%@page import="entity.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "DAO.MemberDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>회원탈퇴_</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
		integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
		crossorigin="anonymous">
	<!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="./assets1/favicon.ico"/>
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
							<h3 class="text-center font-weight-light my-4">회원탈퇴 페이지</h3>
						</div>
						<div class="card-body">
								<%
									Member member_info = (Member)session.getAttribute("member_info");
									String m_id = member_info.getM_id();
									
									String pw = request.getParameter("pw");
									
									MemberDAO dao = MemberDAO.getInstance();
									boolean result = dao.dbpwcompare(m_id, pw);

									if(result){
										session.invalidate();
										dao.deletemember(m_id);
										
									%>
									<center>
									<br /><br /><br />
										<h2>회원탈퇴 완료!</h2>
									<br />	
									</center>
									<div class="d-grid">
										 <input type="button" class="btn btn-success mb-3" value="Main Home" onclick="location.href='./index.jsp'"/>		
										 <!-- <input type="button" class="btn btn-danger mb-3" value="Go Back" onclick="location.href='./m_deleteFrom.jsp'"/>-->
									</div>
									<% } else { %>
									<center>
									<br /><br /><br />
										<h2>비밀번호를 다시 확인해주세요.</h2>
									</center>
									<div class="d-grid">
										 <input type="button" class="btn btn-danger mb-3" value="Go Back" onclick="location.href='./m_deleteFrom.jsp'"/>
									</div>
									<% } %>
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
	