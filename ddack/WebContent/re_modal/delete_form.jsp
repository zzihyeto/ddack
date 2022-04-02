<%@page import="entity.ReviewBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

	ReviewBean review = (ReviewBean) session.getAttribute("review");
	String p_name =review.getP_name();
	System.out.println("===p_name=" + p_name);
	String p_review =  review.getP_review();
	System.out.println("===p_reivew=" + p_review);

%>

<c:set var="p_name" value="<%= p_name %>"/>
<c:set var="p_review" value="<%= p_review %>"/>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
		<meta name="description" content="" />
		<meta name="author" content="" />
		<title>DDACK_리뷰 삭제 페이지입니다</title>
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
			<main>
				<!-- layout폴더 -> navbar.jsp -->
				<jsp:include page="/layout/navbar.jsp" />

				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="card shadow-lg border-0 rounded-lg my-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">DDACK 리뷰 삭제하기</h3>
								</div>

								<div class="card-body">
									<form action="re_modify.show" method="post">
										<table class="table table-striped">

											<tr>
												<td>구매 상품</td>
												<td><input type="text" class="form-control" value="${ p_name }" readonly></td>
											</tr>

											<tr>
												<td>리뷰</td>
												<td>
												<textarea name="p_review" class="form-control">${ p_review }</textarea>
												</td>
											</tr>

											<tr>
												<td colspan="2" class="text-center">
													<input type="submit" value="삭제" class="btn btn-warning"> <!-- //수정 -->
													<input type="button" class="btn btn-primary" onclick="location.href='review.show'" value="전체 게시글보기">
												</td>
											</tr>

										</table>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>

	<!-- layout폴더 > footer.jsp -->
	<jsp:include page="/layout/footer.jsp" />

	<script>
		CKEDITOR.replace('content', {
				
			width:'100%',
			height:'350'	
		});
		</script>

</body>
</html>