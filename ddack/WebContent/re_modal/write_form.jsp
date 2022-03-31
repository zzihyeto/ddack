<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

	ArrayList<Product> order_list = (ArrayList<Product>) session.getAttribute("order_list");

	String[] name_list = new String[order_list.size()];
	String p_name=null;
	for (int i=0;i<order_list.size();i++){
		p_name =order_list.get(i).getP_name();
		name_list[i] = p_name;
	}

%>
<c:set var="name_list" value="<%= name_list %>"/>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
		<meta name="description" content="" />
		<meta name="author" content="" />
		<title>DDACK_리뷰작성 페이지입니다</title>
		<!-- Favicon-->
		<link rel="icon" type="image/x-icon" href="../assets1/favicon.ico" />
		<!-- Bootstrap icons-->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
		<!-- Core theme CSS (includes Bootstrap)-->
		<link href="../css1/styles.css" rel="stylesheet" />
	</head>

<body class="d-flex flex-column">
	<main class="flex-shrink-10">
		<!-- layout폴더 -> navbar.jsp -->
		<jsp:include page="../layout/navbar.jsp" />

		<section class="py-5">
			<div class="container px-5" align="center">
				<div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5" border-radius="30px">
					<div class="row">
						<div class="col-md-2"></div>
						<div class="col-md-8">
							<h2 class="text-center">DDACK 구매후기 작성</h2>
							
							<form action="re_write.show" method="post">
								<table class="table table-striped">
									<tr>
										<td>회원ID</td>
										<td><input type="text" class="form-control" name="m_id"></td>
									</tr>
									<tr>
										<td>구매 상품</td>
										<td><input type="text" class="form-control" name="p_name"></td>
									</tr>
									<tr>
										<td>리뷰</td>
										<td><textarea rows="10" cols="50" name="p_review" class="form-control"></textarea></td>
									</tr>
									
									<tr>
										<td colspan="2" class="text-center">
										<input type="submit" value="글쓰기" class="btn btn-success">
										<input type="reset" value="다시작성" class="btn btn-warning">
										<button type="button" class="btn btn-primary" onclick="location.href='../review.jsp'">전체 게시글보기</button>
										</td>
									</tr>

								</table>
							</form>
						</div>
					</div>
				</div>
			</div>

		</section>
	</main>

	<!-- layout폴더 > footer.jsp -->
	<jsp:include page="../layout/footer.jsp" />

		<script>
		CKEDITOR.replace('content', {
				
			width:'100%',
			height:'350'	
		});
		</script>

</body>
</html>