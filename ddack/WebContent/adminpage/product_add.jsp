<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String invent_qty_warn = (String) request.getAttribute("invent_qty_warn");
%>
<c:set var="invent_qty_warn" value="<%=invent_qty_warn %>"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Product_테이블</title>
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
                        <h1 class="mt-4">Product_테이블</h1>
                       	
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">Product_테이블</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                Product_테이블<br> DDACK의 노력은 계속되어야 한다.
                            </div>
                        </div>
                        <div class="card mb-4">
	                        <div class="card-header">
	                            <i class="fas fa-table me-1"></i>Product_테이블
	                        </div>
	                        <c:if test="${!empty invent_qty_warn}">
						        <div class="alert alert-warning" role="alert">
						          ${invent_qty_warn} 
						        </div>
					    	</c:if>
	                        <div class="card-body">
                                <form action="productinsert.add" method="post">
                      		      	<div class="form-floating mb-3">
                                    	<input name="store_name" class="form-control"  type="text" placeholder="저장소이름"/>
                                        <label for="store_name">저장소이름</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                    	<input name="p_name" class="form-control"  type="text" placeholder="완제품 이름"/>
                                        <label for="p_name">완제품이름</label>
                                    </div>
                                    
                                    <div class="form-floating mb-3">
                                        <input name="invent_qty" class="form-control"  type="text" placeholder="완제품 개수"/>
                                        <label for="invent_qty">완제품 개수</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="eq_code" class="form-control"  type="text" placeholder="완제품 상태" />
                                        <label for="eq_code">O or X</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="p_kg" class="form-control"  type="text" placeholder="완제품 무게" />
                                        <label for="p_kg">완제품무게</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="p_life" class="form-control"  type="text" placeholder="완제품유통기한" />
                                        <label for="p_life">완제품유통기한</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="p_pay" class="form-control"  type="text" placeholder="완제품 가격" />
                                        <label for="p_pay">완제품가격</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="btn btn-success" type="submit" value="등록하기"/>
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