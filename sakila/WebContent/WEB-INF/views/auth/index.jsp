<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
		
		<!-- 부트스트랩 로드 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<!-- jQuery 로드 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<!-- Font Awesome 5 아이콘 로드 -->
		<script src='https://kit.fontawesome.com/a076d05399.js'></script>
	</head>
	
	<body>
		<div class="container-xl">
			<div class="d-flex">
				<div style="width: 250px; background-color: #CCCCCC">asdf</div>
				<div class="bg-primary flex-grow-1">asdf</div>
			</div>
			
			<h1>인덱스 페이지</h1>
			<div>
				<span>${loginStaff.username}</span> 관리자님
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/auth/LogoutServlet">로그아웃</a>
			</div>
		</div>
	</body>
</html>