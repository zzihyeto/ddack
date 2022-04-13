<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>BOM_테이블</title>
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
                        <h1 class="mt-4">BOM_테이블</h1>
                       	
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">BOM_테이블</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                고객만족을 위한 DDACK!<br> DDACK의 노력은 계속되어야 한다.
                           	 <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                                .
                            </div>
                        </div>
                        <div class="card mb-4">
	                        <div class="card-header">
	                            <i class="fas fa-table me-1"></i>BOM_테이블
	                        </div>
	                        <div class="card-body">
                                <form action="bominsert.add" method="post">
                                    <div class="form-floating mb-3">
                                        <input name="mat_name" class="form-control"  type="text" placeholder="원자재 이름" />
                                        <label for="mat_name">원자재 이름</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="mat_type" class="form-control"  type="text" placeholder="원자재 종류"/>
                                        <label for="mat_type">원자재 종류</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="mat_unit" class="form-control"  type="text" placeholder="원자재 단위" />
                                        <label for="mat_unit">원자재 단위</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="mat_count" class="form-control"  type="text" placeholder="원자재 갯수"/>
                                        <label for="mat_count">원자재 갯수</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="mat_person" class="form-control"  type="text" placeholder="원자재 관리자" />
                                        <label for="mat_person">원자재 관리자</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="mat_container_code" class="form-control"  type="text" placeholder="원자재 창고코드" readonly value="D" />
                                        <label for="mat_container_code">D</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="mat_life_t" class="form-control"  type="text" placeholder="원자재 유통기한" />
                                        <label for="mat_life_t">원자재 유통기한</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="c_check" class="form-control"  type="text" placeholder="O or X" />
                                        <label for="c_check">원자재 위생상태 O or X</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="btn btn-success"  type="submit" value="등록하기"/>
                                        <input type="button" class="btn btn-primary" value="뒤로가기" onclick="history.back(-1);">
                                    </div>
                                </form>
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
