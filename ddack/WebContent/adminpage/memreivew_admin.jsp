<%@ page import="entity.ReviewBean" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("utf-8");
	List<ReviewBean> review_list = (List<ReviewBean>) session.getAttribute("review_list");
	
	request.setAttribute("review_list", review_list);
	
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>상품리뷰</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css2/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    
    <body class="sb-nav-fixed">
      <!-- 네비게이션바 -->
	 <%@ include file ="main/include/layout/header.jsp"%>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                 <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                	<!-- 사이드바 -->
                    <%@ include file ="main/include/layout/sidebar.jsp"%>    
                </nav>
        </div>
            
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                    <!-- table 내용 -->
                        <h1 class="mt-4">상품리뷰 정보</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">상품리뷰 정보</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                상품리뷰 참고하세요. <br> DDACK의 노력은 계속되어야 한다.
                        	</div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>상품리뷰 테이블
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>주문 번호</th>
						         			<th>상품 이름</th>
						         			<th>작성자</th>
						         			<th>리뷰내용</th>
						         			<th>리뷰날짜</th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
	                                    <c:if test="${!empty review_list}">
							         		<c:forEach var="re" items="${review_list }">
							         			<tr>
							         				<td>${re.re_code}</td>
							         				<td>${re.p_name}</td>
							         				<td>${re.m_id}</td>
							         				<!-- 글씨잘리게나오도록 함 -->
							         				<td>${fn:substring(re.p_review,0,15)}</td>
							         				<td>${re.review_date}</td>
							         			</tr>
							         		</c:forEach>
						         		</c:if>                                       
                                    </tbody>
                                </table>
                                
                            </div>
                        </div>
                    </div>
                    </div>
                </main>
	      
                <!-- footer -->   
            	<%@ include file ="main/include/layout/footer.jsp"%>
            </div>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js2/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js2/datatables-simple-demo.js"></script>
    </body>
</html>
