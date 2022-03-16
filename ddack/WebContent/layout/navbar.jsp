<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Navigation-->
 <nav class="navbar navbar-expand-lg navbar-dark bg-success">
     <div class="container px-5">
         <a class="navbar-brand" href="index.jsp">DDACK_HOME</a>
         <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
             <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                 <li class="nav-item"><a class="nav-link" href="index.jsp">DDACK</a></li>
                 <li class="nav-item"><a class="nav-link" href="about.jsp">About</a></li>
                 <li class="nav-item"><a class="nav-link" href="join.jsp">Join</a></li>
                 <li class="nav-item"><a class="nav-link" href="faq.jsp">FAQ</a></li>
                 <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" id="navbarDropdownBlog" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Product</a>
                     <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownBlog">
                         <li><a class="dropdown-item" href="product_show.jsp">Product</a></li>
                         <li><a class="dropdown-item" href="review.jsp">Review</a></li>
                     </ul>
                 </li>
                 <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" id="navbarDropdownPortfolio" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Member</a>
                     <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownPortfolio">
                         <li><a class="dropdown-item" href="portfolio-overview.html">Info</a></li>
                         <li><a class="dropdown-item" href="portfolio-item.html">Order Info</a></li>
                         <li><a class="dropdown-item" href="#">Member Out</a></li>
                     </ul>
                 </li>
                 <!-- 만약에 어드민으로 로그인 했으면 조건걸때 사용하기 -> 누르면 Admin 페이지로 가도록 
                  <li class="nav-item"><a class="nav-link" href="">Admin</a></li>
                  -->
             </ul>
         </div>
     </div>
 </nav>