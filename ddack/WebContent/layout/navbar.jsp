<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String loginmsg = (String) session.getAttribute("login_ing");
	//System.out.println("==loginmsg=>"+loginmsg);
%>
<c:set var="loginmsg" value="<%= loginmsg %>"/>
<!-- Navigation-->
 <nav class="navbar navbar-expand-lg navbar-dark bg-success">
     <div class="container px-5">
         <a class="navbar-brand" href="index.jsp">DDACK_HOME</a>
         <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
             <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                 <li class="nav-item"><a class="nav-link" href="index.jsp">DDACK</a></li>
                 <li class="nav-item"><a class="nav-link" href="about.jsp">About</a></li>
                 <li class="nav-item"><a class="nav-link" href="join_form.jsp">Join</a></li>
                 <li class="nav-item"><a class="nav-link" href="faq.jsp">FAQ</a></li>
                 <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" id="navbarDropdownBlog" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Product</a>
                     <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownBlog">
                         <li><a class="dropdown-item" href="product.show">Product</a></li>
                         <li><a class="dropdown-item" href="review.jsp">Review</a></li>
                     </ul>
                 </li>
                 <li class="nav-item dropdown">
                       	<c:if test="${loginmsg eq 'member'}">
                       		<a class="nav-link dropdown-toggle" id="navbarDropdownPortfolio" href="#"
                     			role="button" data-bs-toggle="dropdown" aria-expanded="false">Member</a>
                     		<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownPortfolio">
	                       		<li><a class="dropdown-item" href="portfolio-overview.html">Info</a></li>
		                        <li><a class="dropdown-item" href="./cart.jsp">Order Info</a></li>
		                        <li><a class="dropdown-item" href="#">Member Out</a></li>
	                        </ul>
                       	</c:if>
                       	<c:if test="${loginmsg eq 'admin' }">
                       		<a class="nav-link dropdown-toggle" id="navbarDropdownPortfolio" href="#"
                     			role="button" data-bs-toggle="dropdown" aria-expanded="false">Member</a>
                     		<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownPortfolio">
                       		<li ><a class="dropdown-item" href="./adminpage/index.jsp">Admin page</a></li>
                       		</ul>
                       	</c:if >
                 </li> 
               </ul>
                 
         </div>
     </div>
 </nav>