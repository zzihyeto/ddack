<%@page import="entity.Supplier"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Supplier supplier = (Supplier) session.getAttribute("supplier");
	request.setAttribute("supplier", supplier);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>발주목록 수정하기</title>
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
                        <h1 class="mt-4">발주목록 수정하기</h1>
                       	
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">발주목록테이블</li>
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
	                            <i class="fas fa-table me-1"></i>발주관리 목록 수정
	                        </div>
	                        <c:if test="${!empty invent_qty_warn}">
						        <div class="alert alert-warning" role="alert">
						          ${invent_qty_warn} 
						        </div>
					    	</c:if>
	                        <div class="card-body">
                                <form action="pur_insert.admin" method="post">
                      		      	<div class="form-floating mb-3">
                                    	<input name="b_order_code" class="form-control"  type="text" value="${supplier.b_order_code }"/>
                                        <label for="b_order_code">발주코드</label>
                                    </div>
                                    
                                    <div class="form-floating mb-3">
                                    	<input name="b_comp_code" class="form-control"  type="text" value="${supplier.b_comp_code }"/>
                                        <label for="b_comp_code">발주회사코드</label>
                                    </div>
                                    
                                    <div class="form-floating mb-3">
                                        <input name="mat_order_d" class="form-control"  type="text" value="${supplier.mat_order_d }"/>
                                        <label for="mat_order_d">발주일자</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="mat_count" class="form-control"  type="text" value="${supplier.mat_count }" />
                                        <label for="mat_count">주문수량</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="exp_in_d" class="form-control"  type="text" value="${supplier.exp_in_d }" />
                                        <label for="exp_in_d">예상입고일</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="tru_in_d" class="form-control"  type="text" value="${supplier.tru_in_d }" />
                                        <label for="tru_in_d">실제입고일</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="quality" class="form-control"  type="text" value="${supplier.quality }" />
                                        <label for="quality">품질검사</label>
                                    </div>
                             
                                    <div class="form-floating mb-3">
                                        <input class="btn btn-success" type="submit" value="수정하기"/>
                                        <input type="button" class="btn btn-primary" value="뒤로가기" onclick="history.back(-1);">
                                    </div>
                                </form>
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
