<%@ page import="entity.Product" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
	List<Product> order_list = (List<Product>) session.getAttribute("order_list");
	
	request.setAttribute("order_list", order_list);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>mem_orders.jsp</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous"> 
	 <!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="./assets1/favicon.ico" />
	<!-- Bootstrap icons-->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="css1/styles.css" rel="stylesheet" />
	<style>
	table {
	    margin-left:auto; 
	    margin-right:auto;
	}
	th, td {
	  text-align: center;
	}
	</style>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- layout폴더 > navbar.jsp -->
        <jsp:include page="./layout/navbar.jsp"/>
        
        <div class="container mb-5" >
			<h3 class="text-center font-weight-light my-4">Member Orders</h3>
			
			<table class="table table-hover mt-5" id="cartTable">
				<tr>
					<th>상품</th>
					<th>가격</th>
					<th>수량</th>
					<th>소계</th>
					<th>주문</th>
					<th>희망납기</th>			
				</tr>
				
				<c:if test="${!empty order_list}">
					<c:forEach var="order" items="${order_list }">
						<tr>
							<td>${order.p_name }</td>
							<td>${order.p_pay }</td>
							<td >${order.p_count }</td>
							<td class="col_value"><fmt:formatNumber value="${order.p_count_pay }" /></td>
							<td >${order.order_date }</td>					
							<td >${order.due_date }</td>				
						</tr>
						
					</c:forEach>
				
					<tr>
						<th>합계</th>
						<th></th>
						<th></th>
						<%
							int sum =0;
							for(int i=0;i<order_list.size();i++){
								sum += order_list.get(i).getP_count_pay();
							}
						%>
						<th class="col_sum"><%=sum %></th>
						<th></th>
						<th></th>
					</tr>
				</c:if>
			</table>
		</div>     
	</main>
	<!-- layout폴더 > footer.jsp -->
    <jsp:include page="./layout/footer.jsp"/>
</body>
</html>