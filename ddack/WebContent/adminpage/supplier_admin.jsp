<%@ page import="entity.Supplier" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
	List<Supplier> supplier_list = (List<Supplier>) session.getAttribute("supplier_list");

	request.setAttribute("supplier_list", supplier_list );
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>외부거래처정보</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css2/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    
    <body class="sb-nav-fixed">
     <!-- 네비게이션바 -->
	 <jsp:include page="main/include/layout/header.jsp"/>
    
    <div id="layoutSidenav">
      <div id="layoutSidenav_nav">
         <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
          	<!-- 사이드바 -->
            <jsp:include page="main/include/layout/sidebar.jsp"/>    
         </nav>
      </div>
      
    <div id="layoutSidenav_content">
       <main>
  		  <div class="container-fluid px-4">
           <!-- table 내용 -->
        	 <h1 class="mt-4">외부거래처 정보</h1>
             <ol class="breadcrumb mb-4">
             	  <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                  <li class="breadcrumb-item active">외부거래처 정보</li>
             </ol>
             
         <div class="card mb-4">
             <div class="card-body">
				외부거래처 정보 <br> DDACK의 노력은 계속되어야 한다.
             </div>
          </div>
                                           
           <div class="card mb-4">
              <div class="card-header">
                  <i class="fas fa-table me-1"></i>거래처정보
                  <a href="./supp_regist_form.jsp" class="btn btn-primary">신규거래처등록</a>
              </div>
                    
             <div class="card-body">
                 <table id="datatablesSimple" class="text-center">
                    <thead align="center">
                         <tr>
                             <th>거래처코드</th>
         					 <th>거래처명</th>
         					 <th>거래처 유형</th>
         					 <th>주소</th>
         					 <th>연락처</th>
         					 <th>이메일주소</th>
                         </tr>
                     </thead>
                     
				      <tbody>
					     <c:if test="${ !empty supplier_list }">
					  		<c:forEach var="supplier" items="${ supplier_list }">
					  			<tr>
					  				<td>${ supplier.b_comp_code }</td>
					  				<td>${ supplier.b_comp_name }</td>
					  				<td>${ supplier.mat_code }</td>	
					  				<td>${ supplier.b_comp_addr }</td>
					  				<td>${ supplier.b_comp_tel }</td>
					  				<td>${ supplier.b_email }</td>
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
 	<jsp:include page="main/include/layout/footer.jsp"/>
    
      </div>
  </div>
    	
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js2/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js2/datatables-simple-demo.js"></script>
    </body>
</html>