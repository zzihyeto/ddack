<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>수요 예측 - AdminPage</title>
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
                    <!-- 차트 내용 -->
                        <h1 class="mt-4">수요 예측</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자페이지 메인</a></li>
                            <li class="breadcrumb-item active">수요 예측</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                수요 예측을 해봅시다.<br>
                    			시기별 닭가슴살 판매량 예측을 통해 생산하고 판매해 봅시다.
                            </div>
                        </div>
 
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i> 월별 닭가슴살 검색량
                                    </div>
                                    <div class="card-body"><canvas id="ddack3" width="100%" height="65"></canvas></div>
                                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i> 닭가슴살 검색량에 따른 매출량 예측
                                    </div>
                                    <div class="card-body"><canvas id="ddack1" width="100%" height="65"></canvas></div>
                                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                                </div>
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets2/demo/chart-bar-ddack.js"></script>
        <script src="assets2/demo/chart-bar-ddack2.js"></script>
    </body>
</html>