<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    	<title>DDACK_관리자 페이지</title>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css2/styles.css" rel="stylesheet"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    
<body class="sb-nav-fixed">
	 <!-- 네비게이션바 -->
	 <%@ include file ="main/include/layout/header.jsp"%>
	 
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                   <!-- sidebar.jsp -->
                    <%@ include file ="main/include/layout/sidebar.jsp"%>
                </nav>
        	</div>
            
           <!-- dashboard.jsp + footer.jsp -->
        	<div id="layoutSidenav_content">
				<!-- sidebar.jsp에서 dashboard.jsp로 이동  -->	            
 				<%@ include file ="main/include/content/dashboard.jsp"%> 	
 				 
 				<!-- footer -->   
            	<%@ include file ="main/include/layout/footer.jsp"%> 	
            </div>
           
        </div>
    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js2/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets2/demo/chart-area-demo.js"></script> <!--대쉬보드 안 차트 바꾸려면 ID 및 경로 수정하세요. -->
        <script src="assets2/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js2/datatables-simple-demo.js"></script>
    </body>
</html>
