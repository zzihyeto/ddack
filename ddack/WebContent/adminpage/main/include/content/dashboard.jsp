<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>관리자페이지_메인</title>
	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>
     <main>
	     <div class="container-fluid px-4">
	         <ol class="breadcrumb mt-4 mb-4">
	             <li class="breadcrumb-item active">관리자 페이지</li>
	         </ol>
	         <div class="row">
	             <div class="col-xl-3 col-md-4">  
	                 <div class="card bg-danger text-white mb-4">
	                     <div class="card-body">물류 관리</div>
	                     <div class="card-footer d-flex align-items-center justify-content-between">
	                         <i class="fas fa-angle-right"></i>
	                         <a class="small text-white" href="release_order.admin">출고 지시</a>
	                     </div>
	                     <div class="card-footer d-flex align-items-center justify-content-between">
	                         <div class="small text-white"><i class="fas fa-angle-right"></i></div>
	                         <a class="small text-white" href="release_history.admin">출고 내역</a>
	                     </div>
	                 </div>
	             </div>
	             
	             <div class="col-xl-3 col-md-4">
	                 <div class="card bg-warning text-white mb-4">
	                     <div class="card-body">품질 관리</div>
	                     <div class="card-footer d-flex align-items-center justify-content-between">
	                         <div class="small text-white"><i class="fas fa-angle-right"></i></div>
	                         <a class="small text-white" href="Quality_Management.admin">제품 품질 현황</a>
	                     </div>
	                 </div>
	             </div>
	             
	             <div class="col-xl-3 col-md-4">
	                 <div class="card bg-success text-white mb-4">
	                     <div class="card-body">구매 관리</div>
	                     <div class="card-footer d-flex align-items-center justify-content-between">
	                         <div class="small text-white"><i class="fas fa-angle-right"></i></div>
	                         <a class="small text-white" href="supplier_info.admin">구매회사정보</a>
	                     </div>
	                     <div class="card-footer d-flex align-items-center justify-content-between">
	                         <div class="small text-white"><i class="fas fa-angle-right"></i></div>
	                         <a class="small text-white" href="pur_addform.admin">구매 발주관리</a>
	                     </div>
	                 </div>
	             </div>
	         </div>
	        	
	         <div class="row">
	             <div class="col-xl-6">
	                 <div class="card mb-4">
	                     <div class="card-header">
	                         <i class="fas fa-chart-bar me-1"></i> 월별 닭가슴살 검색량
	                     </div>
	                     <div class="card-body"><canvas id="ddack3" width="100%" height="60"></canvas></div>
	                 </div>
	             </div>

	             <div class="col-xl-6">
	                 <div class="card mb-4">
	                     <div class="card-header">
	                         <i class="fas fa-chart-bar me-1"></i> 닭가슴살 검색량에 따른 매출량 예측</div>
	                     <div class="card-body"><canvas id="ddack1" width="100%" height="60"></canvas></div>
	                 </div>
	             </div>	             
	         </div>
	     </div>
	 </main>
</body>
</html>