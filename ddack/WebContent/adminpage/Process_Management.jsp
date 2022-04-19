<%@page import="entity.Production_manage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
	List<Production_manage> process_manage = (List<Production_manage>) session.getAttribute("process_manage");
	
	request.setAttribute("process_manage", process_manage);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>공정관리</title>
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
        	 <h1 class="mt-4">공정관리</h1>
             <ol class="breadcrumb mb-4">
             	  <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                  <li class="breadcrumb-item active">생산지시</li>
             </ol>
             
         <div class="card mb-4">
             <div class="card-body">
				공정관리
				<br> DDACK의 노력은 계속되어야 한다.
			  <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                .
             </div>
          </div>
                       
  		 <!-- 네비탭바 -->
          <ul class="nav nav-tabs mb-4">
			 <li class="nav-item">
		    	<a class="nav-link active" href="process_manage.admin">공정관리</a>
			 </li>
			 <li class="nav-item">
		    	<a class="nav-link" href="production_order.admin">생산지시현황</a>
			 </li>
		   </ul>   
                                           
           <div class="card mb-4">
              <div class="card-header">
                  <i class="fas fa-table me-1"></i>공정관리
              </div>
                      
             <div class="card-body">

                 <table id="datatablesSimple" class="text-center">
                    <thead align="center">
                         <tr>
                             <th>공정코드</th>
         					 <th>주문코드</th>
         					 <th>제품코드</th>
	          				 <th>재료코드1</th> 
	          				 <th>재료코드2</th>     			
	          				 <th>재료코드3</th>     			
	          				 <th>재료코드4</th>     			
	          				 <th>조리코드</th>     			
	          				 <th>생산시간</th>     			
	          				 <th>관리자코드</th>     			
	          				 <th>라인코드</th>     			
	          				 <th>위생코드</th>     			
	          				 <th>품질코드</th>     			
	          				 <th>생산상태</th>  <!-- 버튼 -->
	          		      </tr>
                     </thead>
                     
				      <tbody>
					     <c:if test="${ !empty process_manage }">
					  		<c:forEach var="process_manage" items="${ process_manage }">
					  			<tr>
					  			    <th>${ process_manage.ch_pro_code }</th>
         					 		<th>${ process_manage.start_od_code }</th>
         					 		<th>${ process_manage.p_code }</th>
	          				 		<th>${ process_manage.mat_code1 }</th>
	          				 		<th>${ process_manage.mat_code2 }</th>
	          				 		<th>${ process_manage.mat_code3 }</th>
	          				 		<th>${ process_manage.mat_code4 }</th>
	          				 		<th>${ process_manage.cook_code }</th>
	          				 		<th>${ process_manage.mk_time }</th>
	          				 		<th>${ process_manage.mk_ps_code }</th>
	          				 		<th>${ process_manage.line_code }</th>
	          				 		<th>${ process_manage.clean_code }</th>
	          				 		<th>${ process_manage.q_code }</th>
	          				 		<td>
							        	<a href="starorder_enddate.admin?start_od_code=${ process_manage.start_od_code }" 
							         	 class="btn btn-warning">생산상태</a>
							        </td>
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
