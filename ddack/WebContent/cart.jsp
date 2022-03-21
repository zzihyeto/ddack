<%@ page import="entity.Product" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<Product> cart_list = (List<Product>) request.getAttribute("cart_list");
	//request.setAttribute("cart_list", cart_list);
	
%>
<c:set var="car_list" value="cart_list"/>
<!DOCTYPE html>
<html>
<head>
       <meta charset="utf-8" />
       <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
       <meta name="description" content="" />
       <meta name="author" content="" />
       <title>Cart.jsp</title>
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
					<td align="left">
						<a href="#" class="btn btn-danger">
							삭제하기
						</a>
					</td>
					<td align="right">
						<a href="#" class="btn btn-success">
							주문하기
						</a>
					</td>
					<td align="right">
						<a href="product.show" class="btn btn-success">
							&raquo; 쇼핑 계속하기
						</a>
					</td>
				</tr>
			</table> 
			
			<table class="table table-hover mt-5">
				<tr>
					<th>상품</th>
					<th>가격</th>
					<th>수량</th>
					<th>소계</th>
					<th>삭제</th>					
				</tr>
				
				<c:forEach var="cart" items="${cart_list }">
					<tr>
						<td>${cart.getP_name }</td>
						<td>${cart.getP_pqy }</td>
						<td>
							<select name="count" id="count">
								<option value="1" selected>10</option>
								<option value="2">20</option>
								<option value="3">30</option>
								<option value="4">40</option>
								<option value="5">50</option>
							</select>
						</td>
						<td>${cart.getP_pay * count }</td>
						<td>삭제</td>					
					</tr>
				</c:forEach>
				
			</table>
			
		<%-- 
			<%
			int sum =0;
	
			for(int i=0; i<cart_list.size(); i++){
				Product product = cartList.get(i);
				// 소계 = 가격 * 수량
				int total = Integer.parseInt(product.getP_pay()) * product.getQuantity();
				sum = sum + total;
			%>
		
			<div style="padding-top:50px;">
			<table class="table table-hover">
				
				
					<td><%=product.getProductId() %>-<%=product.getPname() %></td>
					<td><%=product.getUniPrice() %></td>
					<td><%=product.getQuantity() %></td>
					<td><%=total%></td>
					<td>삭제</td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>총액</th>
					<th><%=sum %></th>
					<th></th>
				</tr>
			</table>
			
		</div> --%>
		
	</div>
    
         
	</main>
    <!-- layout폴더 > footer.jsp -->
    <jsp:include page="./layout/footer.jsp"/>

	
</body>
</html>