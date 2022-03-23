<%@ page import="entity.Product" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
	List<Product> cart_list = (List<Product>) session.getAttribute("cart_list");
	
	request.setAttribute("cart_list", cart_list);
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>Cart.jsp</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous"> 
	 <!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
	<!-- Bootstrap icons-->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="css1/styles.css" rel="stylesheet" />
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- layout폴더 > navbar.jsp -->
        <jsp:include page="./layout/navbar.jsp"/>
    
    	<div class="container mb-5" >
			
			<table width="100%" class="mt-5">
				<tr>
					<td>
						<a href="#" class="btn btn-danger">
							삭제하기
						</a>
					</td>
					<td>
						<a href="#" class="btn btn-success">
							총 주문하기
						</a>
					</td>
					<td>
						<a href="product.show" class="btn btn-success">
							&raquo; 쇼핑 계속하기
						</a>
					</td>
				</tr>
			</table> 
			
			<table class="table table-hover mt-5" id="cartTable">
				<tr>
					<th>상품</th>
					<th>가격</th>
					<th>수량</th>
					<th>소계</th>
					<th>삭제</th>					
				</tr>
				
				
				<c:forEach var="cart" items="${cart_list }">
						
					<tr>
						<td>${cart.p_name }</td>
						<td>${cart.p_pay }</td>
						<td >${cart.p_count }</td>
						<td class="col_value"><fmt:formatNumber value="${cart.p_count_pay }" /></td>
						
						<td>
							<a href="del_cart.show?p_code=${cart.p_code }"  class="btn btn-danger">
								<i class="fas fa-trash"></i>
							</a>
						</td>					
					</tr>
					
				</c:forEach>
				
				<tr>
					<th>합계</th>
					<th></th>
					<th></th>
					<%
						int sum =0;
						for(int i=0;i<cart_list.size();i++){
							sum += cart_list.get(i).getP_count_pay();
						}
					%>
					<th class="col_sum"><%=sum %></th>
					<th></th>					
				</tr>
			</table>
	</div>
    
         
	</main>
    <!-- layout폴더 > footer.jsp -->
    <jsp:include page="./layout/footer.jsp"/>
	
	<!-- <script>
		window.onload = function(){
			let sum = 0;
			var i = '';
			console.log(i);
			
			
			
		}
	</script> -->
	
</body>
</html>