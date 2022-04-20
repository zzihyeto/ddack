<%@ page import="entity.Product" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
	List<Product> cart_list = (List<Product>) session.getAttribute("cart_list");
	request.setAttribute("cart_list", cart_list);
	
%>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>Finalbuy.jsp</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous"> 
	 <!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
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
			
			<table width="100%" class="mt-5">
				<tr>
					<td>
						<a href="product.show" class="btn btn-success">
							&raquo; 쇼핑 계속하기
						</a>
					</td>
				</tr>
			</table> 
			<c:if test="${empty cart_list}">
				<h5 class="mt-5 mb-5">
					<p class="bg-danger text-white" style="text-align:center">장바구니를 담지 않으셨어요</p>					
				</h5>
			</c:if>
			
			<table class="table table-hover mt-5" id="cartTable">
				<tr>
					<th>상품</th>
					<th>가격</th>
					<th>수량</th>
					<th>소계</th>
					<th>삭제</th>					
				</tr>
				
				<c:if test="${!empty cart_list}">
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
				</c:if>
			</table>
			<h5 class="mt-5 mb-5">
				<p class="bg-danger text-white" style="text-align:center">납기일을 넉넉하게 일주일이상 주세요!</p>					
			</h5>
			<form action="finalbuy.member?today=${today }" method="post">
				<table  class="table mt-5" width="50%" height="100%">
					<%-- <colgroup>
						<col style="width:30%"/>
					</colgroup> --%>
				
					<tr>
						<th colspan="4">주문일</th>
						<th colspan="4">희망 납기일</th>
					</tr>
					<tr>
						<td colspan="4"><c:out value="${today}"/></td>					
						<td colspan="4"><input type="text" name="due_date" class="form-control" placeholder="'0000-00-00' 로 적어주세요"/></td>
					</tr>
					<tr>
						<td colspan="8">
							<input type="submit" class="btn btn-warning" value="&raquo; 총 주문하기" />
						</td>
					</tr>
				</table>		
			</form>
		</div>
        
        
	</main>
	<!-- layout폴더 > footer.jsp -->
    <jsp:include page="./layout/footer.jsp"/>
</body>
</html>