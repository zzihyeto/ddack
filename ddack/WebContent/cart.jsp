<%@ page import="entity.Product" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<Product> cart_list = (List<Product>) request.getAttribute("cart_list");
	request.setAttribute("pro_list", cart_list);
	
%>
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
<body>
	<main class="flex-shrink-0">
		<!-- layout폴더 > navbar.jsp -->
        <jsp:include page="./layout/navbar.jsp"/>
    
    	<div class="container">
		<div class="row">
			<table width="100%">
				<tr>
					<td align="left">
					<a href="deleteCart.jsp?cartId=<%=cartId%>" class="btn btn-danger">
					삭제하기
					</a>
					</td>
					<td align="right">
					<a href="shippingInfo.jsp?cartId=<%=cartId %>" class="btn btn-success">주문하기</a>
					</td>
				</tr>
			</table> 
		</div>
		<div style="padding-top:50px;">
			<table class="table table-hover">
				<tr>
					<th>상품</th>
					<th>가격</th>
					<th>수량</th>
					<th>소계</th>
					<th>비고</th>
				</tr>
	<%
		ArrayList<Product> cartList = (ArrayList<Product>)session.getAttribute("cartlist");
		//out.print("cartList크기: "+ cartList.size());
		if(cartList == null){
			cartList = new ArrayList<Product>();
		}
		int sum = 0; 
		for(int i=0; i<cartList.size(); i++){
			Product product = cartList.get(i);
			// 소계 = 가격 * 수량
			int total = product.getUniPrice() * product.getQuantity();
			sum = sum + total;
	%>
				<tr>
					<td><%=product.getProductId() %>-<%=product.getPname() %></td>
					<td><%=product.getUniPrice() %></td>
					<td><%=product.getQuantity() %></td>
					<td><%=total%></td>
					<td>삭제</td>
				</tr>
	<%
		}
	%>			<tr>
					<th></th>
					<th></th>
					<th>총액</th>
					<th><%=sum %></th>
					<th></th>
				</tr>
			</table>
			<a href="products.jsp" class="btn btn-secondary">&raquo; 쇼핑 계속하기</a>
		</div>
		
	</div>
    
         
	</main>
    <!-- layout폴더 > footer.jsp -->
    <jsp:include page="./layout/footer.jsp"/>

	
</body>
</html>