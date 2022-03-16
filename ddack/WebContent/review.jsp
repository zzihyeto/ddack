<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>review.jsp</title>
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
            <jsp:include page="./layout/navbar.jsp"/>
            
            
           	<div class="container px-5">
	        	<!-- 검색창 -->
				
	        	
				
			
				<br />
				<!-- 전체보기 리스트 보기 실패-->
				<div>
					<c:if test="${ empty re_list }">
						<h5>
							<p class="bg-danger text-white">등록된 게시물이 존재하지않습니다.</p>
						</h5>
					</c:if>	
				</div>
				
				<!-- 전체보기 리스트-->
				<div>
					<table class="table table-hover table-secondary">
						<thead>
							<tr>
								<th>글번호</th>
								<th>작성자</th>
								<th>구매한 물품</th>
								<th>후기</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody>
							tr>td*5				
						</tbody
					</table>
					
				</div>
				
				<!-- pagenation 
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
				-->
	        </div>
        
        
        
        </main>
        
        <!-- layout폴더 > footer.jsp -->
        <jsp:include page="./layout/footer.jsp"/>
        
       
    </body>
</html>