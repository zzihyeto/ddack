<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--1/20 만드는것: 고객->문의게시글작성 -답변글게시 -->
<html>
<head>
	<title>review</title>
	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>	
</head>
<body>
	<div class="container" align="center">
		
		<div class="jumbotron">
			<h3>고객리뷰게시판</h3>
			<p>고객리뷰 게시판<br>글쓰기를 하려면 <strong class="text-danger"> 게시판글쓰기버튼</strong>을 클릭하세요.</p>
		</div>
		
		<a href="boardWriteForm.bo" class="btn btn-success mr-sm-2">게시판 글쓰기</a>
		<a href="boardList.bo" class="btn btn-success">게시판글 목록보기</a>
	</div>
</body>
</html>