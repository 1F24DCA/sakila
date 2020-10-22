<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login</title>
		
		<!-- 부트스트랩 로드 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<!-- jQuery 로드 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<!-- Font Awesome 5 아이콘 로드 -->
		<script src='https://kit.fontawesome.com/a076d05399.js'></script>
		
		<script>
			$(document).ready(function() {
				$('#loginSubmit').click(function() {
					if ($('#loginId').val() == "") {
						alert("ID를 입력해주세요!");
						return;
					} else if ($('#loginPw').val() == "") {
						alert("PW를 입력해주세요!");
						return;
					}
					
					$('#loginForm').submit();
				});
			});
		</script>
	</head>
	
	<body>
		<div class="d-flex justify-content-center w-100">
			<div class="d-flex flex-column" style="width: 300px">
				<div class="text-center m-2">
					<i class='fas fa-user-circle text-secondary' style='font-size:125px'></i>
				</div>
				
				<form method="post" action="${pageContext.request.contextPath}/LoginServlet" id="loginForm">
					<div class="m-2">
						<input class="form-control" type="text" name="staffId" placeholder="ID" id="loginId">
					</div>
					<div class="m-2">
						<input class="form-control" type="password" name="password" placeholder="PW" id="loginPw">
					</div>
					<div class="m-2">
						<button class="btn btn-primary btn-block" type="button" id="loginSubmit">Log-in</button>
					</div>
				</form>
				
				<div class="text-center m-2">
					<div class="text-secondary small">
						오늘 방문자 수: ${todayStats.cnt}
					</div>
					<div class="text-secondary small">
						총 방문자 수: ${totalCount}
					</div>
				</div>
			</div>
		</div>
	</body>
</html>