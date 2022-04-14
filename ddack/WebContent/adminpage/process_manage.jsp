<%@ page import="entity.MemOrder" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>생산관리</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="/css2/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    
    <body class="sb-nav-fixed">
     <!-- 네비게이션바 -->
	 <%@ include file ="/adminpage/main/include/layout/header.jsp"%>
    <div id="layoutSidenav">
      <div id="layoutSidenav_nav">
         <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
          	<!-- 사이드바 -->
            <%@ include file ="/adminpage/main/include/layout/sidebar.jsp"%>    
         </nav>
         
      </div>
    <div id="layoutSidenav_content">
       <main>
  		  <div class="container-fluid px-4">
           <!-- table 내용 -->
        	 <h1 class="mt-4">생산관리 정보</h1>
             <ol class="breadcrumb mb-4">
             	  <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                  <li class="breadcrumb-item active">생산관리 정보</li>
             </ol>
             
         <div class="card mb-4">
             <div class="card-body">
             	생산관리
				<br> DDACK의 노력은 계속되어야 한다.
			  <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                .
             </div>
          </div>
                       
  		   <!-- 네비탭바 -->
          <ul class="nav nav-tabs mb-4">
			 <li class="nav-item">
		    	<a class="nav-link active" href="buy_comp_info.admin">거래처정보</a>
			 </li>
		     <li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
						role="button" aria-expanded="false">발주관리</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="order_list.admin">발주목록</a></li>
					<li><a class="dropdown-item" href="order_detail.admin">발주내역</a></li>
				</ul>
			</li>
		   </ul>   
                                           
           <div class="card mb-4">
              <div class="card-header">
                  <i class="fas fa-table me-1"></i>거래처정보
              </div>
                      
             <div class="card-body">
                 <table id="datatablesSimple">
                   
                    <thead>
                         <tr>
                             <th>거래처코드</th>
         					 <th>거래처명</th>
         					 <th>거래처 유형</th>
         					 <th>주소</th>
         					 <th>연락처</th>
         					 <th>발주내역</th>         			
                         </tr>
                     </thead>
                     
				      <tbody>
		<%-- 			      <c:if test="${! empty }">
					  		<c:forEach var="order" items="${ }"> --%>
					  			<tr>
					  				<td>${order.b_comp_code}</td>
					  				<td>${order.b_comp_name}</td>
					  				<td>${order.mat_order_d}</td>
					  				<td>${order.b_comp_addr}</td>
					  				<td>${order.b_comp_tel}</td>
					  				<td>${order.b_order_code}</td>
<%-- 					  				<td>
					  				<a href="#" id="makestart" class="btn btn-warning" 
					  					 onclick="changebutton(); return false;">
												생산 지시
									</a>
					  				</td>
					  				<td>${order.delay_date}</td>
					  				<td></td>
 --%>					  		</tr>
<%-- 					  		</c:forEach>
							</c:if>         --%>                               
				      </tbody>
         		  </table>
  				 </div>
              </div>
        	</div>
         </main>
	   
	      
   <!-- footer -->   
   <%@ include file ="/adminpage/main/include/layout/footer.jsp"%>
   
      </div>
    </div>
    	
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js2/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js2/datatables-simple-demo.js"></script>
    </body>
</html>
