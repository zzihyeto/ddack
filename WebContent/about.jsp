<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <link href="./css1/styles.css" rel="stylesheet" />
    </head>
    <body class="d-flex flex-column">
        <main class="flex-shrink-0">
            <!-- layout폴더 > navbar.jsp -->
            <jsp:include page="./layout/navbar.jsp"/>
            
            <!-- Header-->
            <header class="py-5">
                <div class="container px-5">
                    <div class="row justify-content-center">
                        <div class="col-lg-8 col-xxl-6">
                            <div class="text-center my-5">
                                <h1 class="fw-bolder mb-3">팀 이름 "닭리고"</h1>
                                <p class="lead fw-normal text-muted mb-4">
                                	수업을 들으면서 다양한 곳에서 프로그래밍이 쓰이는 것을 보고 놀라웠습니다. 
									부족하지만 수업 들은 것을 기반으로 적용하고 앞으로 더 develop하기 위해 
									회원 관리,주문 서비스와 그 안에 MES 적용하여 프로젝트 만들었습니다.
								</p>
                                <a class="btn btn-success btn-lg" href="#scroll-target">Read our story</a>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- 회원관리 & 생산관리 요약설명-->
            <section class="py-5 bg-light" id="scroll-target">
                <div class="container px-5 my-5">
                    <div class="row gx-5 align-items-center">
                        <div class="col-lg-6"><img class="img-fluid rounded mb-5 mb-lg-0" src="https://dummyimage.com/600x400/343a40/6c757d" alt="..." /></div>
                        <div class="col-lg-6">
                            <h2 class="fw-bolder">회원 관리</h2>
                            <p class="lead fw-normal text-muted mb-0">회원가입 할 수 있고 로그인할 때 일반 회원과 관리자를 나워서 진행하였고, 상품들이 나열되고 리뷰도 볼수 있고 회원들이 주문한 상품을 조회가능 하게 하였습니다.</p>
                        </div>
                    </div>
                </div>
            </section>
            
            <section class="py-5">
                <div class="container px-5 my-5">
                    <div class="row gx-5 align-items-center">
                        <div class="col-lg-6 order-first order-lg-last"><img class="img-fluid rounded mb-5 mb-lg-0" src="https://dummyimage.com/600x400/343a40/6c757d" alt="..." /></div>
                        <div class="col-lg-6">
                            <h2 class="fw-bolder">생산 관리(MES)</h2>
                            <p class="lead fw-normal text-muted mb-0">관리자가 주문 들어온 것을 보고 생산지시를 하면 자동으로 재고파악하여 출고할 수 있는 것과 필요한 갯수를 계산해서 그만큼 생산하여 창고에 넣고 출고하게 하였습니다.</p>
                        </div>
                    </div>
                </div>
            </section>
            
            <!-- Team members section-->
            <section class="py-5 bg-light">
                <div class="container px-5 my-5">
                    <div class="text-center">
                        <h2 class="fw-bolder">Our Team</h2>
                        <p class="lead fw-normal text-muted mb-5">Dedicated to quality and your success</p>
                    </div>
                    <div class="row gx-5 row-cols-1 row-cols-sm-2 row-cols-xl-4 justify-content-center">
                        <div class="col mb-5 mb-5 mb-xl-0">
                            <div class="text-center">
                                <img class="img-fluid rounded-circle mb-4 px-4" src="https://dummyimage.com/150x150/ced4da/6c757d" alt="..." />
                                <h5 class="fw-bolder">BR.PARK</h5>
                                <div class="fst-italic text-muted">Group Member</div>
                            </div>
                        </div>
                        <div class="col mb-5 mb-5 mb-xl-0">
                            <div class="text-center">
                                <img class="img-fluid rounded-circle mb-4 px-4" src="https://dummyimage.com/150x150/ced4da/6c757d" alt="..." />
                                <h5 class="fw-bolder">JH.Lee</h5>
                                <div class="fst-italic text-muted">Group Leader</div>
                            </div>
                        </div>
                        <div class="col mb-5 mb-5 mb-sm-0">
                            <div class="text-center">
                                <img class="img-fluid rounded-circle mb-4 px-4" src="https://dummyimage.com/150x150/ced4da/6c757d" alt="..." />
                                <h5 class="fw-bolder">Kim</h5>
                                <div class="fst-italic text-muted">Group Member</div>
                            </div>
                        </div>
                       
                    </div>
                </div>
            </section>
        </main>
        
        <!-- layout폴더 > footer.jsp -->
        <jsp:include page="./layout/footer.jsp"/>
        
       
    </body>
</html>