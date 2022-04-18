<%@page import="entity.Production_manage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
	List<Production_manage> production_order = (List<Production_manage>) session.getAttribute("production_order");
	
	request.setAttribute("production_order", production_order);
	System.out.println("==production_order===="+production_order);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>생산지시현황</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css2/styles.css" rel="stylesheet" />
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
        	 <h1 class="mt-4">생산지시현황</h1>
             <ol class="breadcrumb mb-4">
             	  <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                  <li class="breadcrumb-item active">생산지시</li>
             </ol>
             
         <div class="card mb-4">
             <div class="card-body">
				생산지시 관리
				<br> DDACK의 노력은 계속되어야 한다.
			  <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                .
             </div>
          </div>
                       
  		 <!-- 네비탭바 -->
          <ul class="nav nav-tabs mb-4">
			 <li class="nav-item">
		    	<a class="nav-link" href="process_manage.admin">공정관리</a>
			 </li>
			 <li class="nav-item">
		    	<a class="nav-link active" href="production_order.admin">생산지시현황</a>
			 </li>
		   </ul>   
                                           
           <div class="card mb-4">
              <div class="card-header">
                  <i class="fas fa-table me-1"></i>생산지시현황
              </div>
                      
             <div class="card-body">

                 <table id="datatablesSimple" class="text-center">
                    <thead align="center">
                         <tr>
                             <th>시작 주문 코드</th>
         					 <th>전체 날짜</th>
         					 <th>생산 시작일</th>
	          				 <th>생산 종료일</th>      			
                         </tr>
                     </thead>
                     
				      <tbody>
					     <c:if test="${ !empty production_order }">
					  		<c:forEach var="production_order" items="${ production_order }">
					  			<tr>
					  			    <th>${ production_order.start_od_code }</th>
         					 		<th>${ production_order.total_date }</th>
         					 		<th>${ production_order.begin_date }</th>
	          				 		<th>${ production_order.end_date }</th>
					  			</tr>
					  		</c:forEach>
						</c:if>                                       
				      </tbody>
         		  	</table>
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
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js2/datatables-simple-demo.js"></script>
    </body>
</html>
