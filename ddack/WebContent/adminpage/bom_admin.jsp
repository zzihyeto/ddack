<%@ page import="entity.BOM" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("utf-8");
	List<BOM> bom_list = (List<BOM>) session.getAttribute("bom_list");
	
	request.setAttribute("bom_list", bom_list);
	
	String succ_update = (String)request.getAttribute("succ_update");
%>

<c:set var="succ_update" value="<%= succ_update %>"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>BOM_테이블</title>
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
                        <h1 class="mt-4">BOM_테이블</h1>
                       	
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">BOM_테이블</li>
                        </ol>
                        <c:if test="${!empty succ_update}">
					        <div class="alert alert-warning" role="alert">
					          ${succ_update}
					        </div>
					    </c:if>
                        <div class="card mb-4">
                            <div class="card-body">
                                BOM (Bills of Material)<br> DDACK의 노력은 계속되어야 한다.
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>BOM_테이블
                                <a href="./bom_add.jsp" class="btn btn-success">추가하러 가기</a>
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>원자재 코드</th>
                                            <th>원자재 이름</th>
                                            <th>외부/내부</th>
                                            <th>원자재 단위</th>
                                            <th>원자재 갯수</th>
                                            <th>원자재 관리자</th>
                                            <th>원자재 창고코드</th>
                                            <th>원자재 유통기한</th>
                                            <th>위생 관리</th>
                                        </tr>
                                    </thead>
                                    
                                
                                    <tbody>
                                      	<c:if test="${!empty bom_list}">
							         		<c:forEach var="bom" items="${bom_list }">
							         			<tr>
							         				<td><a href="bomdetail.add?mat_code=${bom.mat_code }">${bom.mat_code}</a></td>
							         				<td>${bom.mat_name}</td>
							         				<td>${bom.mat_type}</td>
							         				<td>${bom.mat_unit}</td>
							         				<td>${bom.mat_count}</td>
							         				<td>${bom.mat_person}</td>
							         				<td>${bom.mat_container_code}</td>
							         				<td>${bom.mat_life_t}</td>
							         				<td>${bom.c_check}</td>
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
