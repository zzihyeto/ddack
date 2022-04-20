<%@ page import="entity.Release"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("utf-8");
	List<Release> Release_order = (List<Release>) session.getAttribute("Release_order");
	//p_name..store_name..invent_total..invent_qty..eq_code 담겨있음
	
	request.setAttribute("Release_order", Release_order);
%>
<c:set var="Release_order" value="<%= Release_order %>"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>출고지시</title>
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
                        <h1 class="mt-4">출고지시</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">출고지시_테이블</li>
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
                                <i class="fas fa-table me-1"></i>출고지시_테이블
                                <%-- <a href="./product_add.jsp" class="btn btn-success">추가하러 가기</a>--%>
                            </div >
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>제품코드</th>
                                            <th>거래처코드</th>
                                            <th>요청수량</th>
                                            <th>제품상태</th>
                                            <th>출고</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      	<c:if test="${!empty Release_order}">
							         		<c:forEach var="R_order" items="${Release_order}">
							         			<tr>         			
							         				<td>${R_order.p_code}</td>
							         				<td>${R_order.m_code}</td>
							         				<td>${R_order.p_count}</td>
							         				<td>${R_order.eq_code}</td>
							         				<td><a href="release_out.admin?p_code=${R_order.p_code}&m_code=${R_order.m_code}&p_count=${R_order.p_count}" class="form-control btn btn-success btn-sm">출고하기</a></td>						         				
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