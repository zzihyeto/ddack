<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content />
        <meta name="author" content />
        <title>login_form.jsp</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="./css1/styles.css" rel="stylesheet" />
     </head>

<body class="d-flex flex-column">
	<div id="layoutAuthentication">
	    <div id="layoutAuthentication_content">
	        <main>
	         <!-- layout폴더 > navbar.jsp -->
	   		<jsp:include page="./layout/navbar.jsp" />	
            
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                            <div class="card-body">
                                <form>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="userID" type="text" placeholder="ID를 입력하세요" />
                                        <label for="inputEmail">Id</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputPassword" type="password" placeholder="Password" />
                                        <label for="inputPassword">Password</label>
                                    </div>
                                    <div class="form-check mb-3">
                                        <input class="form-check-input" id="inputRememberPassword" type="checkbox" value="" />
                                        <label class="form-check-label" for="inputRememberPassword">Remember Password</label>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                        <a class="small" href="password.html">비밀번호 찾기</a>
                                        <a class="btn btn-primary" href="index.html">Login</a>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer text-center py-3">
                                <div class="small"><a href="join.jsp">건강하기를 원합니까? DDACK에회원가입 ㄱㄱ </a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
	        </main>
	    </div>
	</div>
     <!-- layout폴더 > footer.jsp -->
	<jsp:include page="./layout/footer.jsp" />
    
</body>
</html>