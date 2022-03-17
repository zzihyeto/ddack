<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setAttribute("re_list","");
%>
<c:set var="pro_list" value="${pro_list }"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Modern Business - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css1/styles.css" rel="stylesheet" />
    </head>
    <body class="d-flex flex-column">
        <main class="flex-shrink-0">
            <!-- layout폴더 > navbar.jsp -->
            <jsp:include page="./layout/navbar.jsp"/>
            
            <!-- Pricing section-->
            <section class="bg-light py-5">
                <div class="container px-5 my-5">
                    <div class="text-center mb-5">
                        <h1 class="fw-bolder">상품 나열</h1>
                        <p class="lead fw-normal text-muted mb-0">장바구니에 담으세요</p>
                    </div>
                    
                    <div class="row gx-5 justify-content-center mb-5">
                        <!-- Pricing card free-->
                        <c:if test="${ empty pro_list }">
							<h5>
								<p class="bg-danger text-white">등록된 게시물이 존재하지않습니다.</p>
							</h5>
						</c:if>	
                        <c:foreach var="product" items="${pro_list }">
                        	<div class="col-lg-6 col-xl-4">
	                            <div class="card mb-5 mb-xl-0">
	                                <div class="card-body p-5">
	                                    
	                                    <div class="mb-3">
	                                        <span class="display-6 fw-bold">${prodcut.p_name }</span>
	                                    </div>
	                                    <ul class="list-unstyled mb-4">
	                                        <li class="mb-2">
	                                            <i class="bi bi-check text-primary"></i>
	                                            ${product.p_pay }
	                                        </li>
	                                        <li class="mb-2">
	                                            <i class="bi bi-check text-primary"></i>
	                                            ${product.p_kg }
	                                        </li>
	                                        <li class="mb-2">
	                                            <i class="bi bi-check text-primary"></i>
	                                            ${product.p_life }
	                                        </li>
	                                    </ul>
	                                    <div class="d-grid"><a class="btn btn-outline-success" href="#!">장바구니</a></div>
	                                </div>
	                            </div>
	                        </div>
                        </c:foreach>
                       
                  
                        
                    </div>
                    

                </div>
            </section>
        </main>
        <!-- layout폴더 > footer.jsp -->
       <jsp:include page="./layout/footer.jsp"/>
    </body>
</html>
