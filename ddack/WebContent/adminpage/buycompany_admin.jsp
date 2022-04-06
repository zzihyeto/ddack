<%@ page import="entity.MemOrder" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
	List<MemOrder>  = (List<MemOrder>) session.getAttribute("");
	
	request.setAttribute("", );
	
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>발주관리</title>
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
                        <h1 class="mt-4">발주회사 정보</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">발주회사 정보</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
							발주회사 참고하세요.<br> DDACK의 노력은 계속되어야 한다.
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>발주회사 테이블
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th></th>
						         			<th></th>
						         			
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
	                                    <c:if test="${!empty }">
							         		<c:forEach var="order" items="${ }">
							         			<tr>
							         				<td>${order.m_od_code}</td>
							         				<td>${order.m_name}</td>
							         				<td>${order.p_name}</td>
							         				<td>${order.p_count}</td>
							         				<td>${order.order_date}</td>
							         				<td>${order.dead_line}</td>
							         				<td>${order.due_date}</td>
							         				<td>
							         					<a href="#" id="makestart" class="btn btn-warning" 
							         					 onclick="changebutton(); return false;">
															생산 지시
														</a>
							         				</td>
							         				<td>${order.delay_date}</td>
							         				<td></td>
							         			</tr>
							         		</c:forEach>
						         		</c:if>                                       
                                    </tbody>
                                </table>
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
