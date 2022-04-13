<%@ page import="entity.Product" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("utf-8");
	List<Product> storage_list = (List<Product>) session.getAttribute("storage_list");
	
	request.setAttribute("storage_list", storage_list);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Store_테이블</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        
		<!-- <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"> -->
		
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
                        <h1 class="mt-4">완제품 창고 관리</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">Store_테이블</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                고객만족을 위한 DDACK!<br> DDACK의 노력은 계속되어야 한다.
                           	 <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                                .
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>Store_테이블
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>창고 코드</th>
                                            <th>저장소 이름</th>
                                            <th>저장한 완제품</th>
                                            <th>남은 공간</th>
                                            <th>창고 위치</th>
                                        </tr>
                                    </thead>
                                    
                                
                                    <tbody>
                                      	<c:if test="${!empty storage_list}">
							         		<c:forEach var="stor" items="${storage_list }">
							         			<tr>
							         				
							         				<td>${stor.invent_code }</td>
							         				<td>${stor.store_name }</td>
							         				<td>${stor.p_name }</td>
							         				<td>${stor.invent_total - stor.invent_qty}
								         				<%-- <c:if test="${stor.invent_total <stor.invent_qty }">
								         					<i class="fa-solid fa-triangle-exclamation"></i>
								         				</c:if> --%>
								         			</td>
							         				<td>${stor.store_loc}</td>							         											         				
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
