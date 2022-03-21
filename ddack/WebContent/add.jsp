<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
 %>
 
 <%
 	String p_code = request.getParameter("p_code");
 	String p_name = request.getParameter("p_name");
 	String p_pay = request.getParameter("p_pay");
 	String p_kg = request.getParameter("p_kg");
 	String p_life = request.getParameter("p_life");
 	String p_count = request.getParameter("count");
 	
 	Product product = new Product();
 	product.setP_code(p_code);
 	product.setP_name(p_name);
 	product.setP_kg(p_kg);
 	product.setP_pay(p_pay);
 	product.setP_life(p_life);
 	int p_pay2 = Integer.parseInt(p_pay);
 	int p_count2 = Integer.parseInt(p_count);
 	product.setP_count_pay(p_pay2 *p_count2);
 	product.setP_count(p_count2);
 	
 	List<Product> cart_list = (List<Product>) session.getAttribute("cart_list");
 	if (cart_list == null ){
 		cart_list = new ArrayList<Product>();
 	}
 	cart_list.add(product);

	session.setAttribute("cart_list", cart_list);
 	
 %>
 <script type="text/javascript">
 	alert("<%=p_name %> 가 추가 되었습니다.");
 	history.go(-1);
 </script>
