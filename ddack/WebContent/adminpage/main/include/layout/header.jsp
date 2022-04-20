<%@page import="entity.Member"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String m_id = null;
	if(session.getAttribute("member_info")!=null){
		Member member = (Member) session.getAttribute("member_info");
		m_id = member.getM_id();		
	}
	
	
%>
<c:set var="m_id" value="<%=m_id %>"/>

<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
	<!-- Navbar Brand-->
	<a class="navbar-brand ps-3" href="index.jsp">DDACK_관리자페이지</a>
	
	<!-- Sidebar Toggle-->
	<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>

	<!-- Navbar -->
	<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" 
				aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
			<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">

				<li><a class="dropdown-item" href="/index.jsp">회원홈페이지</a></li>
				<c:if test="${!empty m_id}">
				<li><a class="dropdown-item" href="logout.check">Logout</a></li>
				</c:if>
				<c:if test="${empty m_id}">
				<li><a class="dropdown-item" href="/adminpage/login_admin.jsp">Login</a></li>
				</c:if>
			</ul>
		</li>
	</ul>
</nav>