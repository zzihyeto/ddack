<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Product_테이블</title>
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
                        <h1 class="mt-4">Product_테이블</h1>
                       	
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">관리자 페이지</a></li>
                            <li class="breadcrumb-item active">Product_테이블</li>
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
	                            <i class="fas fa-table me-1"></i>Product_테이블
	                        </div>
	                        <div class="card-body">
                                <form action="productinsert.add" method="post">
                                    <div class="form-floating mb-3">
                                        <input name="p_name" class="form-control"  type="text" placeholder="원자재 이름" />
                                        <label for="p_name">완제품이름</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                    	<select name="invent_code" id="" class="form-control">
                                    		<option value="창고코드_1">저장소이름_1</option>
                                    		<option value="창고코드_2">저장소이름_2</option>
                                    		<option value="창고코드_3">저장소이름_3</option>
                                    		<option value="창고코드_4">저장소이름_4</option>
                                    		<option value="창고코드_5">저장소이름_5</option>
                                    		<option value="창고코드_6">저장소이름_6</option>
                                    		<option value="창고코드_7">저장소이름_7</option>
                                    		<option value="창고코드_8">저장소이름_8</option>
                                    		<option value="창고코드_9">저장소이름_9</option>
                                    		<option value="창고코드_10">저장소이름_10</option>
                                    		<option value="창고코드_11">저장소이름_11</option>
                                    		<option value="창고코드_12">저장소이름_12</option>
                                    		<option value="창고코드_13">저장소이름_13</option>
                                    		<option value="창고코드_14">저장소이름_14</option>
                                    		<option value="창고코드_15">저장소이름_15</option>
                                    		<option value="창고코드_16">저장소이름_16</option>
                                    		<option value="창고코드_17">저장소이름_17</option>
                                    		<option value="창고코드_18">저장소이름_18</option>
                                    		<option value="창고코드_19">저장소이름_19</option>
                                    		<option value="창고코드_20">저장소이름_20</option>
                                    	</select>
                                        <input name="invent_storname" class="form-control"  type="text" placeholder="원자재 종류"/>
                                        <label for="invent_storname">창고 코드</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="invent_total" class="form-control"  type="text" placeholder="원자재 단위" />
                                        <label for="invent_total">창고최대 갯수</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="invent_qty" class="form-control"  type="text" placeholder="원자재 갯수"/>
                                        <label for="invent_qty">완제품 갯수</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input name="eq_code" class="form-control"  type="text" placeholder="원자재 관리자" />
                                        <label for="eq_code">완제품 상태</label>
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
