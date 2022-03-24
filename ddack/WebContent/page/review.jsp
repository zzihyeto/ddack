<%@ page import="entity.PageInfo"%>
<%@ page import= "java.util.List" %>
<%@ page import="entity.ReviewBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	List<ReviewBean> review_list = (List<ReviewBean>) session.getAttribute("review_list");
	request.setAttribute("review_list", review_list);
	PageInfo pageinfo = (PageInfo) request.getAttribute("pageInfo");
	//System.out.println("====review_list=====>",review_list);
	
	request.setAttribute("review_list", (List<ReviewBean>) session.getAttribute("review_list")); 	
	int curPage = pageinfo.getPage();
	int totalPage = pageinfo.getTotalPage();
	int startPage = pageinfo.getStartPage();
	int endPage = pageinfo.getEndPage();
%>
<c:set var="curPage" value="<%=curPage %>"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>DDACK_리뷰페이지입니다</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="./css1/styles.css" rel="stylesheet" />
    </head>
	<body class="d-flex flex-column">

        <main class="flex-shrink-0">
            <!-- layout폴더 -> navbar.jsp -->
            <jsp:include page="/layout/navbar.jsp"/>
            
        	<div class="container px-5">
        	
        	<!-- 검색창 : 이거 다시해야함-->
			  <div class="float-right mt-3">
			<nav class="nav justify-content-end">
					  <div class="float-right mt-3">
					  <!-- 검색분류선택하고 검색어로 검색 -->
					    <form class="d-flex" action="search.re?page=${curPage }" method="post">
					    <!--검색 분류선택 -->
					      <select name="sk" class="me-2">
					      	<option value="m_id">작성자ID</option>
					      	<option value="p_code">상품코드</option>
					      	<option value="review_date">작성일</option>
					      </select>
					      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
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
								<th>작성자ID</th>
								<th>상품코드</th>
								<th>후기</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody>
						
						<c:forEach var="review" items="${ review_list }">
							<tr>
								<td>${ review.re_code }</td>
								<td>${ review.m_id }</td>
								<td>${ review.p_code }</td>
								<td>${ review.p_review }</td>
								<td>${ review.review_date }</td>
							</tr>	
						</c:forEach>			
						</tbody>
					</table>					
				</div>
				<div style="float: right;" class="mb-3">
				<button type="button" class="btn btn-outline-success">Write</button>
				</div>
				
		<!-- pagenation_맨밑에 깍두기  -->
				<div class="container">
					<ul class="pagination justify-content-center">
						
						<c:if test="${startPage!=1}">
							<li class="page-item"><a href="list.re?page=1" class="page-link"><i class="fas fa-fast-backward"></i></a></li>
							<li class="page-item"><a href="list.re?page=${startPage-10}" class="page-link"><i class="fas fa-backward"></i></a></li>
						</c:if>
						
						<c:forEach var="page_num" begin="${startPage}" end="${endPage}">
							<li class="page-item"><a href="list.re?page=${page_num}" class="page-link">${page_num}</a></li>
						</c:forEach>
						
						<c:if test="${endPage < totalPage}">
							<li class="page-item"><a href="list.re?page=${endPage+1}" class="page-link"><i class="fas fa-forward"></i></a></li>
							<li class="page-item"><a href="list.re?page=${totalPage}" class="page-link"><i class="fas fa-fast-forward"></i></a></li>
						</c:if>
					</ul>
				</div>

	        </div>
     
        </main>
        
        <!-- layout폴더 > footer.jsp -->
        <jsp:include page="/layout/footer.jsp"/>
            
    </body>
</html>