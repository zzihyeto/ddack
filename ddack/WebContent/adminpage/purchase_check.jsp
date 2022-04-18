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
        <title>발주체크</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="./css2/styles.css" rel="stylesheet" />
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
      
 <div id="layoutSidenav_content">
       <main>
  		  <div class="container-fluid px-4">
           <!-- table 내용 -->
        	 <h1 class="mt-4">발주체크</h1>
             <ol class="breadcrumb mb-4">
             	  <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                  <li class="breadcrumb-item active">발주관리정보</li>
             </ol>
             
         <div class="card mb-4">
             <div class="card-body">발주체크
				<br> 꼬치수량250개미만, 나머지 재료 1000개 미만일 경우 발주해야하는 목록이 나타납니다.
			  <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                .
             </div>
         </div>
                       
		<!-- 네비탭바 -->
          <ul class="nav nav-tabs mb-4">
			 <li class="nav-item">
		    	<a class="nav-link" href="pur_choice_form.jsp">발주서 작성하기</a>
			 </li>
			 <li class="nav-item">
		    	<a class="nav-link" href="pur_manage.admin">발주관리</a>
			 </li>
		  </ul>   
		   
                       
           <div class="card mb-4">
              <div class="card-header">
                   <i class="fas fa-table me-1"></i>발주체크
              </div>
                      
             <div class="card-body">
                 <table id="datatablesSimple">
                    <thead>
                         <tr>
                         	<!--  <th>발주코드</th> -->
                             <th>원재료코드</th>
         					 <th>필요수량</th>		
         					 <th>주문일자</th>
                         </tr>
                     </thead>
                     
				      <tbody>
					      <c:if test="${! empty need_list }">
					  		<c:forEach var="need" items="${ need_list }">
					  			<tr>
					  				<%-- <td>${ need_list.b_order_code }</td> --%>
					  				<td>${ need_list.mat_code }</td>
					  				<td>${ need_list.mat_count }</td>
					  				<td>${ need_list.mat_order_date }</td>
					  				<td>
					  				<a href="purchase_manage_form.jsp" id="makestart" class="btn btn-warning" onclick="changebutton(); return false;">
					  				주문서 작성
									</a>
					  				</td>
<%-- 					  				<td>${order.delay_date}</td>
					  				<td></td>
 --%>					  		</tr>
					  		</c:forEach>
						</c:if>                                       
				      </tbody>
         		  </table>
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
