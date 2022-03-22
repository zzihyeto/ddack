<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	ArrayList<Product> pro_list = (ArrayList<Product>) session.getAttribute("pro_list");
	request.setAttribute("pro_list", pro_list);
	//System.out.println("======type==="+pro_list.getClass().getSimpleName());
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Product_show.jsp</title>
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
                        <a href="./cart.jsp" class="btn btn-warning mt-3">장바구니</a>
                    </div>
                    
                    <div class="row gx-5 justify-content-center mb-5">
                        <!-- Pricing card free-->
                        <c:if test="${ empty pro_list }">
							<h5>
								<p class="bg-danger text-white">등록된 게시물이 존재하지않습니다.</p>
							</h5>
						</c:if>	
						
						
                        <c:forEach var="product" items="${pro_list }">
                       		<div class="col-lg-6 col-xl-4 mb-5">
	                            <div class="card mb-5 mb-xl-0">
									<form action="#" method="post" name ="addForm">
										<div class="card-body p-5">
		                                    <div class="mb-3">
		                                    	<span class="display-7 fw-bold">${product.p_name}</span>
		                                    </div>
		                                    <ul class="list-unstyled mb-4">
		                                    	<li class="mb-2">
		                                            <i class="bi bi-check text-primary">
				                                         <select name="count" id="count">
															<option value="10" selected>10</option>
															<option value="20">20</option>
															<option value="30">30</option>
															<option value="40">40</option>
															<option value="50">50</option>
														</select>
														갯수
		                                            </i>
		                                        </li>
		                                        <li class="mb-2">
		                                            <i class="bi bi-check text-primary">
		                                          ${product.p_pay} 원
		                                            </i>
		                                        </li>
		                                        <li class="mb-2">
		                                            <i class="bi bi-check text-primary">
		                                            ${product.p_kg } kg 
		                                            </i>
		                                        </li>
		                                        <li class="mb-2">
		                                            <i class="bi bi-check text-primary">
		                                            ${product.p_life }
		                                            </i>
		                                        </li>
		                                    </ul>
		                                    
		                                    <input type="hidden" name="p_code" value="${product.p_code }" />
		                                    <input type="hidden" id="p_name" name="p_name" value="${product.p_name }" />
		                                    <input type="hidden" name="p_count" value="${count }" />
		                                    <input type="hidden" name="p_pay" value="${product.p_pay }" />
		                                    <input type="hidden" name="p_kg" value="${product.p_kg }" />
		                                    <input type="hidden" name="p_life" value="${product.p_life }" />
		                                    
		                                    <div class="d-grid">
		                                    	<input class="btn btn-success" type="submit" value="추가하기" formaction="add.show"
		                                    	onclick="handleOnClick()" />
		                                    	
		                                    </div>
		                                </div>
	                                </form>
                                    <script type="text/javascript">
										function handleOnClick()  {
									    	alert("장바구니에 추가 되었습니다.");
										}        
									 </script>
	                            </div>
	                        </div>
                        </c:forEach>
                        
                        
                        
                    </div>
                </div>
            </section>
        </main>
        <!-- layout폴더 > footer.jsp -->
       <jsp:include page="./layout/footer.jsp"/>
       
    </body>
    
    
</html>
