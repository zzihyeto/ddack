<%@ page import="entity.CHprocess" %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("utf-8");
	List<CHprocess> line_state_list = (List<CHprocess>) session.getAttribute("line_state_list");
	//line_state_list에 line_name.. line_usable..  ch_pro_code.. check_date.. check_content 담겨있음
		
	request.setAttribute("line_state_list", line_state_list);
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
                        <h1 class="mt-4">Q_line_테이블</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">Q_line_테이블</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                라인 관리 테이블입니다.<br> DDACK의 노력은 계속되어야 한다.
                            </div>
                        </div>
                        <ul class="nav nav-tabs mb-4">
						  <li class="nav-item">
						    <a class="nav-link " href="q_chpro.admin">공정</a>
						  </li>
						  <li class="nav-item ">
						    <a class="nav-link active" href="q_line.admin">라인</a>
						  </li>
						  <li class="nav-item">
						    <a class="nav-link" href="q_product.admin">완제품</a>
						  </li>
						  <li class="nav-item">
						    <a class="nav-link" href="q_bom.admin">BOM</a>
						  </li>
						</ul> 
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>Q_line__테이블
                            </div>
                            <div class="card-body">
                                <form action="q_line_insert.admin" method="post">
	                                <table id="datatablesSimple">
	                                    <thead>
	                                        <tr>
	                                            <th>라인 이름</th>
	                                            <th>라인 체크내용</th>
	                                            <th>등록 버튼</th>
	                                        </tr>
	                                    </thead>
	                                    
	                                    <tbody>
	                                    	<td>
	                                    		<select name="line_name" id="" class="form-control">
		                                    		<c:if test="${!empty line_state_list}">
									         			<c:forEach var="li_state" items="${line_state_list }">
				                                    			<option value="${li_state.line_name }">${li_state.line_name }</option>
				                                    	</c:forEach>
				                                    </c:if>
			                                    </select>
			                                </td>	
	                                    	<td><input type="text" name="check_content" class="form-control" placeholder="사용할 수 없다 vs 사용할 수 있다"/></td>
	                                    	<td><input type="submit" class="form-control btn btn-success" value="등록"/></td>
	                                    </tbody>
	                                </table>
                                </form>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-body">
                               라인 이름을 클릭해서 해당되는 이름의 라인에 <br />
                               라인 체크한 내용을 입력해서 기록한다. <br />
                               기록하게 되면 기록한 날짜가 수정된다.
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
