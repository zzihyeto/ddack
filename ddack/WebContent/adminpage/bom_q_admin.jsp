<%@ page import="entity.BOM" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("utf-8");
	List<BOM> bom_list = (List<BOM>) session.getAttribute("bom_list");
	
	request.setAttribute("bom_list", bom_list);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Quality_테이블</title>
        
       <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        
        <link href="./css2/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
        
    </head>
    
    <body class="sb-nav-fixed">
      <!-- 네비게이션바 -->
	 <%@ include file ="./main/include/layout/header.jsp"%>
        
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                 <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                	<!-- 사이드바 -->
                    <%@ include file ="./main/include/layout/sidebar.jsp"%>    
                </nav>
        </div>
            
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                    <!-- table 내용 -->
                        <h1 class="mt-4">Q_bom_테이블</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">Q_bom_테이블</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                               Quality + BOM (Bills of Material)<br> DDACK의 노력은 계속되어야 한다.
                            </div>
                        </div>
                        <ul class="nav nav-tabs mb-4">
						  <li class="nav-item">
						    <a class="nav-link " href="q_chpro.admin">공정</a>
						  </li>
						  <li class="nav-item">
						    <a class="nav-link" href="q_line.admin">라인</a>
						  </li>
						  <li class="nav-item">
						    <a class="nav-link" href="q_product.admin">완제품</a>
						  </li>
						  <li class="nav-item ">
						    <a class="nav-link active" href="q_bom.admin">BOM</a>
						  </li>
						</ul>   
                        
                        
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>Q_bom_테이블
                            </div>
                            <div class="card-body">
                            	<form action="q_bom_insert.admin" method="post">
	                                <table id="datatablesSimple">
	                                    <thead>
	                                        <tr>
	                                            <th>원자재 이름</th>
	                                            <th>체크 갯수</th>
	                                            <th>체크 내용</th>
	                                            <th>등록 버튼</th>
	                                        </tr>
	                                    </thead>
	                                    	                                
	                                    <tbody>
							         		<td>
	                                    		<select name="mat_name" id="" class="form-control">
		                                    		<c:if test="${!empty bom_list}">
									         			<c:forEach var="bom_qu" items="${bom_list }">
				                                    			<option value="${bom_qu.mat_name }">${bom_qu.mat_name }</option>
				                                    	</c:forEach>
				                                    </c:if>
			                                    </select>
			                                </td>
			                                <td><input type="text" name="mat_count_update" class="form-control" placeholder="체크한 갯수"/></td>
	                                		<td><input type="text" name="c_check" class="form-control" placeholder="O or X 로 시작하기"/></td>
	                                    	<td><input type="submit" class="form-control btn btn-success" value="등록"/></td>
	                                    </tbody>
	                                </table>
                                </form>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-body">
                               원자재코드를 선택하고 체크한 개수를 입력하고 <br/>
                               체크 내용을 입력한다. <br />
                               등록하게 되면 기록한 날짜가 수정되고 <br/>
                               체크내용에 따라 체크한 개수가 더해지거나 감해진다.
                            </div>
                        </div>
                    </div>
                </main>
	      
                <!-- footer -->   
            	<%@ include file ="./main/include/layout/footer.jsp"%>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./js2/scripts.js"></script> 
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="./js2/datatables-simple-demo.js"></script>
    </body>
</html>
