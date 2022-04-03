<%@ page import="entity.CHprocess" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("utf-8");
	List<CHprocess> chpro_q_list = (List<CHprocess>) session.getAttribute("chpro_q_list");
	
	request.setAttribute("chpro_q_list", chpro_q_list);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Quality_테이블</title>
        
       <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        
        <link href="./css2/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
        
    </head>
    
    <body class="sb-nav-fixed">
      <!-- 네비게이션바 -->
	 <%@ include file ="./main/include/layout/header.jsp"%>
        
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                 <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                	<!-- 사이드바 -->
                    <%@ include file ="./main/include/layout/sidebar.jsp"%>    
                </nav>
        </div>
            
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                    <!-- table 내용 -->
                        <h1 class="mt-4">Q_chpro_테이블</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">Q_chpro_테이블</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                고객만족을 위한 DDACK!<br> DDACK의 노력은 계속되어야 한다.
                           	 <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                                .
                            </div>
                        </div>
                        <ul class="nav nav-tabs mb-4">
						  <li class="nav-item">
						    <a class="nav-link active" href="q_chpro.admin">공정</a>
						  </li>
						  <li class="nav-item">
						    <a class="nav-link" href="q_line.admin">라인</a>
						  </li>
						  <li class="nav-item">
						    <a class="nav-link" href="q_product.admin">완제품</a>
						  </li>
						  <li class="nav-item">
						    <a class="nav-link" href="q_bom.admin">BOM</a>
						  </li>
						</ul>   
                        
                        
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>Q_chpro_테이블
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>불량 코드</th>
                                            <th>공정 코드</th>
                                            <th>체크 버튼</th>
                                            <th>불량 결과</th>
                                        </tr>
                                    </thead>
                                    
                                
                                    <tbody>
                                      	<c:if test="${!empty chpro_q_list}">
							         		<c:forEach var="chpro_qu" items="${chpro_q_list }">
							         			<tr>
							         				<td>${chpro_qu.q_code}</td>
							         				<td>${chpro_qu.ch_pro_code}</td>
							         				<td>
							         					<a href="q_chpro_strt.admin?q_code=${chpro_qu.q_code}&chpro_code=${chpro_qu.ch_pro_code}" 
							         					id="makestart" class="btn btn-warning" onclick="">
															불량체크 버튼
														</a>
							         				</td>
							         				<td>${chpro_qu.q_result}</td>							         											         				
							         			</tr>
							         		</c:forEach>
						         		</c:if> 
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                        <div class="card mb-4">
	                            <div class="card-body">
	                               체크버튼 누르면 공정 과정마다 쓴 재료 상태 확인하고<br />
		                           재료상태에 따 결과값을 나타낸다. 하나라도 상태가 안좋으면 결과값 X
	                            </div>
	                        </div>
                    </div>
                </main>
	      
                <!-- footer -->   
            	<%@ include file ="./main/include/layout/footer.jsp"%>
            </div>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./js2/scripts.js"></script> 
        
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="./js2/datatables-simple-demo.js"></script>
        
    </body>
</html>
