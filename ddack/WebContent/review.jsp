<%@ page import="entity.PageInfo"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.ReviewBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	List<ReviewBean> review_list = (List<ReviewBean>) session.getAttribute("review_list");
	request.setAttribute("review_list", review_list);
	
	PageInfo pageinfo = (PageInfo) request.getAttribute("pageInfo");
 	
 	int curPage = pageinfo.getPage();
	int totalPage = pageinfo.getTotalPage();
    int startPage = pageinfo.getStartPage();
	int endPage = pageinfo.getEndPage();
	
	String buy_check = (String) session.getAttribute("buy_check");
	
 %>

<c:set var="curPage" value="<%=curPage%>"/>
<c:set var="totalPage" value="<%=totalPage%>"/>
<c:set var="startPage" value="<%=startPage%>"/>
<c:set var="endPage" value="<%=endPage%>"/>

<c:set var ="buy_check" value="<%= buy_check %>"/>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
		<meta name="description" content="" />
		<meta name="author" content="" />
		<title>DDACK_리뷰페이지입니다</title>
		<!-- Favicon-->
		<link rel="icon" type="image/x-icon" href="./assets1/favicon.ico" />
		<!-- Bootstrap icons-->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
		<!-- Core theme CSS (includes Bootstrap)-->
		<link href="./css1/styles.css" rel="stylesheet" />
	</head>

<body class="d-flex flex-column">

	<main class="flex-shrink-0">
		<!-- layout폴더 -> navbar.jsp -->
		<jsp:include page="./layout/navbar.jsp" />
		
		<!-- 구매내역없으면 -->
		<div class="bg-danger text-white">
			${ buy_check }
		</div>

		<div class="container px-5">
			<!-- 검색창 -->
			<div class="float-right mt-3">
				<nav class="nav justify-content-end">
					<div class="float-right mt-3">
					
						<!-- 검색분류선택하고 검색어로 검색 -->
						<form class="d-flex" action="search.show?page=${ curPage }" method="post">
							<!--검색 분류선택 -->
							<select name="f" class="form-select me-2">
								<option value="m_id">작성자ID</option>
								<option value="p_name">제품명</option>
								<option value="review_date">작성일</option>
							</select> 
							<input name="q" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
							<button class="btn btn-outline-success" type="submit">Search</button>
						</form>
						
					</div>
				</nav>
			   <br />
			</div>

			<!-- 전체보기 리스트 보기 실패-->
			<div>
				<c:if test="${ empty review_list }">
					<h5>
						<p class="bg-danger text-white">등록된 게시물이 존재하지 않습니다.</p>
					</h5>
				</c:if>
			</div>

			<!-- 전체보기 리스트 성공시-->
			<div>
				<table class="table table-hover table-secondary">
					<thead class="table-warning">
						<tr>
							<th>글번호</th>
							<th>제품명</th>
							<th>작성자ID</th>
							<th>내용</th>
							<th>작성일</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="re" items="${ review_list }">
							<tr>
								<td>${ re.r_num }</td>
								<td>${ re.p_name }</td>
								<td>${ re.m_id }</td>
								<td><a href="re_detail_form.show?p_name=${ re.p_name }&m_id=${re.m_id}&p_code=${re.p_code}">${ re.p_review }</a></td>
								<td>${ re.review_date }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<!-- 리뷰 쓰기 폼으로 넘어가기-->
			<div style="float:right" class="mb-3">
				<a href="re_write_form.show" class="btn btn-outline-success">쓰기</a>
			</div>

			<!-- pagenation -->
			<div class="container">
				<ul class="pagination justify-content-center">
					<c:if test="${startPage!=1}">
						<li class="page-item"><a href="review.show?page=1" class="page-link"><i class="bi bi-skip-backward"></i></a></li>
						<li class="page-item"><a href="review.show?page=${startPage-10}" class="page-link"><i class="bi bi-skip-start"></i></a></li>
					</c:if>

					<c:forEach var="page_num" begin="${startPage}" end="${endPage}">
						<li class="page-item"><a href="review.show?page=${page_num}" class="page-link">${page_num}</a></li>
					</c:forEach>

					<c:if test="${endPage < totalPage}">
						<li class="page-item"><a href="review.show?page=${endPage+1}" class="page-link"><i class="bi bi-skip-end"></i></a></li>
						<li class="page-item"><a href="review.show?page=${totalPage}" class="page-link"><i class="bi bi-skip-forward"></i></a></li>
					</c:if>
				</ul>
			</div>
			
		</div>
	</main>

	<!-- layout폴더 > footer.jsp -->
	<jsp:include page="./layout/footer.jsp" />

</body>
</html>