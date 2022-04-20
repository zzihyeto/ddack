<%@ page import="entity.Product" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("utf-8");
	List<Product> Q_Management = (List<Product>) session.getAttribute("Q_Management");
	//p_name..store_name..invent_total..invent_qty..eq_code 담겨있음
	
	request.setAttribute("Q_Management", Q_Management);
%>
<c:set var="Q_Management" value="<%= Q_Management %>"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>품질관리</title>
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
                        <h1 class="mt-4">품질관리</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">제품품질현황_테이블</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                품질관리<br> DDACK의 노력은 계속되어야 한다.
                           </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>제품품질현황_테이블
                                <%-- <a href="./product_add.jsp" class="btn btn-success">추가하러 가기</a>--%>
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>제품 이름</th>
                                            <th>제품 현황</th>
                                            <th>제품 품질검사</th>
                                            <th>제품 유통기한</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      	<c:if test="${!empty Q_Management}">
							         		<c:forEach var="Q_pro" items="${Q_Management}">
							         			<tr>         			
							         				<td>${Q_pro.p_name}</td>
							         				<td>${Q_pro.invent_qty}</td>
							         				<td>${Q_pro.eq_code}</td>
							         				<td>${Q_pro.p_life}</td>						         				
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