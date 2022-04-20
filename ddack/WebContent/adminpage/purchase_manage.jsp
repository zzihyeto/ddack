<%@ page import="entity.Supplier" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
	List<Supplier> supdetail_list = (List<Supplier>) session.getAttribute("supdetail_list");
	
	request.setAttribute("supdetail_list", supdetail_list);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>발주관리_확인리스트</title>
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
        	 <h1 class="mt-4">구매 발주 관리</h1>
             <ol class="breadcrumb mb-4">
             	  <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                  <li class="breadcrumb-item active">발주관리</li>
             </ol>
             
         <div class="card mb-4">
             <div class="card-body">
				구매 발주 관리 <br> DDACK의 노력은 계속되어야 한다.
             </div>
          </div>
                       
  		 <!-- 네비탭바 -->
          <ul class="nav nav-tabs mb-4">
			 <li class="nav-item">
		    	<a class="nav-link" href="pur_choice_form.jsp">발주서 작성하기</a>
			 </li>
			 <li class="nav-item">
		    	<a class="nav-link active" href="pur_manage.admin">발주관리</a>
			 </li>
		   </ul>   
                                           
           <div class="card mb-4">
              <div class="card-header">
                  <i class="fas fa-table me-1"></i>발주관리내역
              </div>
                      
             <div class="card-body">
          <!--    <form action="supp_regist_form.jsp" method="post"> -->
                 <table id="datatablesSimple" class="text-center">
                    <thead align="center">
                         <tr>
                             <th>발주코드</th>
         					 <th>거래처코드</th>
         					 <th>발주일자</th>
	          				 <th>주문수량</th>      			
         					 <th>예상입고일</th> <!--  exp_in_d -->
         					 <th>실제입고일</th> <!-- tru_in_d -->
         					 <th>품질검사</th> <!-- quality  -->
                         </tr>
                     </thead>
                     
				      <tbody>
					     <c:if test="${ !empty supdetail_list }">
					  		<c:forEach var="supplier" items="${ supdetail_list }">
					  			<tr>
					  				<td><a href="pur_modi.admin?b_order_code=${ supplier.b_order_code }">${ supplier.b_order_code }</a></td>
					  				<td>${ supplier.b_comp_code }</td>
					  				<td>${ supplier.mat_order_d }</td>
					  				<td>${ supplier.mat_count }</td>  					  				
					  				<td>${ supplier.exp_in_d }</td>
					  				<td>${ supplier.tru_in_d }</td>
					  				<td>${ supplier.quality }</td>
					  				<td></td>
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
