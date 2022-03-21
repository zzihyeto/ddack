<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String loginmsg = (String) request.getAttribute("login_ing");
	//System.out.println("==loginmsg=>"+loginmsg);
	
%>
<c:set var="loginmsg" value="<%= loginmsg %>"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>DDACK_Home</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="./css1/styles.css" rel="stylesheet" />
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
         	<!-- layout폴더 > navbar.jsp -->
            <jsp:include page="./layout/navbar.jsp"/>

            <!-- 큰 머리부분 -->
            <header class="bg-warning py-5">
                <div class="container px-5">
                    <div class="row gx-5 align-items-center justify-content-center">
                        <div class="col-lg-8 col-xl-7 col-xxl-6">
                            <div class="my-5 text-center text-xl-start">
                                <h1 class="display-5 fw-bolder text-white mb-2">DDACK</h1>
                                <p class="lead fw-normal text-white-50 mb-4">뭔가 다른데? 맛있게 다르다!</p>
                                <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start">
                                    <c:if test="${!empty loginmsg}">
										<a class="btn btn-success btn-lg px-4 me-sm-3" href="login_form.jsp">로그아웃</a>				
									</c:if>
									<c:if test="${empty loginmsg}">
                                    	<a class="btn btn-success btn-lg px-4 me-sm-3" href="login_form.jsp">로그인</a>
                                    	<a class="btn btn-outline-light btn-lg px-4" href="join_form.jsp">회원가입</a>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-5 col-xxl-6 d-none d-xl-block text-center">
                        	<img class="img-fluid rounded-3 my-5" src="https://dummyimage.com/600x400/343a40/6c757d" alt="..." />
                        </div>
                    </div>
                </div>
            </header>
             
            
             
            <!-- 인기 완제품 3개만 나열 -->
            <section class="py-5">
                <div class="container px-5 my-5">
	                <c:if test="${!empty loginmsg }">
						<div class="alert alert-warning" role="alert">
							${loginmsg} 로그인 되었습니다.
						</div>
					</c:if>
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-8 col-xl-6">
                            <div class="text-center">
                                <h2 class="fw-bolder">인기 상품</h2>
                                <p class="lead fw-normal text-muted mb-5">가장 인기가 많은 제품입니다.</p>
                            </div>
                        </div>
                    </div>
                    <div class="row gx-5">
                        <div class="col-lg-4 mb-5">
                            <div class="card h-100 shadow border-0">
                                <img class="card-img-top" src="https://dummyimage.com/600x350/ced4da/6c757d" alt="..." />
                                <div class="card-body p-4">
                                    <div class="badge bg-danger bg-gradient rounded-pill mb-2">인기</div>
                                    <a class="text-decoration-none link-dark stretched-link" href="#!"><h5 class="card-title mb-3">슬라이스 닭가슴살</h5></a>
                                    <p class="card-text mb-0">먹기 좋게 슬라이스 되어서 한입에 쏙</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 mb-5">
                            <div class="card h-100 shadow border-0">
                                <img class="card-img-top" src="https://dummyimage.com/600x350/adb5bd/495057" alt="..." />
                                <div class="card-body p-4">
                                    <div class="badge bg-danger bg-gradient rounded-pill mb-2">인기</div>
                                    <a class="text-decoration-none link-dark stretched-link" href="#!"><h5 class="card-title mb-3">큐브 닭가슴살</h5></a>
                                    <p class="card-text mb-0">큐브 모양으로 식감을 늘리고 한입에 쏙</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 mb-5">
                            <div class="card h-100 shadow border-0">
                                <img class="card-img-top" src="https://dummyimage.com/600x350/6c757d/343a40" alt="..." />
                                <div class="card-body p-4">
                                    <div class="badge bg-danger bg-gradient rounded-pill mb-2">인기</div>
                                    <a class="text-decoration-none link-dark stretched-link" href="#!"><h5 class="card-title mb-3">핫바 닭가슴살</h5></a>
                                    <p class="card-text mb-0">들기 편하게 바빠도 간편하게 쏙</p>
                                </div> 
                            </div>
                        </div>
                    </div>
                   <!-- 검색창 -->
		           <aside class="bg-success bg-gradient rounded-3 p-4 p-sm-5 mt-5">
		               <div class="d-flex align-items-center justify-content-between flex-column flex-xl-row text-center text-xl-start">
		                   <div class="mb-4 mb-xl-0">
		                       <div class="fs-3 fw-bold text-white">빠르게 제품 검색하기</div>
		                   </div>
		                   <div class="ms-xl-4">
		                       <div class="input-group mb-2">
		                           <input class="form-control" type="text" placeholder="상품이름을 입력해주세요..." />
		                           <button class="btn btn-outline-light" id="button-newsletter" type="button">검색하기</button>
		                       </div>
		                   </div>
		               </div>
		           </aside>
                </div>
            </section>
            <!-- Testimonial section-->
            <div class="py-5 bg-light">
                <div class="container px-5 my-5">
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-10 col-xl-7">
                            <div class="text-center">
                                <div class="fs-4 mb-4 fst-italic">"There may be tough times, but the difficulties which you face will make you more DETERMINED."</div>
                                <div class="fs-4 mb-4 fst-italic"> 힘든 시기가 있을 수 있지만, 당신이 직면하고 있는 어려움들은 당신을 더욱 확고하게 만들어 줄 것입니다. </div>
                               	<div class="d-flex align-items-center justify-content-center">
                                    <div class="fw-bold">
                                        -Marta-
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </main>
        
        <!-- layout폴더 > footer.jsp -->
        <jsp:include page="./layout/footer.jsp"/>
        
    </body>
</html>
