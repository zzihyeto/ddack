<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Sucess_logout</title>
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
                        <h1 class="mt-4">Success_logout</h1>
                       	
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">Success_logout</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                Sucess_logout page<br> DDACK의 노력은 계속되어야 한다.
                            </div>
                        </div>
                        <div class="card mb-4">
	                        <div class="card-header">
	                            <i class="fas fa-table me-1"></i>Success_logout
	                        </div>
	                        
                            <div class="container">
			                <div class="row justify-content-center">
			                    <div class="col-lg-8">
			                        <div class="card shadow-lg border-0 rounded-lg my-5">
			                            <div class="card-header">
				                            <h3 class="text-center font-weight-light my-4">
				                           		로그아웃 되었습니다.
				                            </h3>
			                            </div>
			                            
                            		<div class="card-footer text-center py-3">
		                                <div class="small">
		                                	<a href="/adminpage/index.jsp" class="btn btn-warning">Adminpage</a>
		                                </div>
                            		</div>
                        		</div>
                    		</div>
                		</div>
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
