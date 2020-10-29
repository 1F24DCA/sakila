<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="sakila-nav">
	<span class="sakila-nav-header">Sakila Movie</span>
	
	<div class="sakila-nav-info">
		<div>
			<i class='fas fa-user-circle text-secondary' style='font-size:3.5rem'></i>
		</div>
		<div>
			<span>${loginStaff.storeId}</span> 지점<br>
			<span>${loginStaff.username}</span> 관리자님
		</div>
	</div>
	
	<a class="btn btn-dark btn-sm btn-block mt-2" href="${pageContext.request.contextPath}/auth/LogoutServlet">로그아웃</a>
	
	<div class="sakila-nav-menu">
		<span class="sakila-nav-menu-header">Menu</span>
		<a class="sakila-nav-menu-item" href="${pageContext.request.contextPath}/auth/IndexServlet">홈</a>
		<hr>
		<a class="sakila-nav-menu-item" href="${pageContext.request.contextPath}/auth/ReturnServlet">영화 반납</a>
		<hr>
		<a class="sakila-nav-menu-item" href="${pageContext.request.contextPath}/auth/CustomerServlet">회원목록 관리</a>
		<a class="sakila-nav-menu-item" href="${pageContext.request.contextPath}/auth/FilmServlet">영화목록 관리</a>
		<a class="sakila-nav-menu-item" href="${pageContext.request.contextPath}/auth/InventoryServlet">영화재고 관리</a>
		<a class="sakila-nav-menu-item" href="${pageContext.request.contextPath}/auth/FilmActorServlet">영화배우 관리</a>
		<a class="sakila-nav-menu-item" href="${pageContext.request.contextPath}/auth/ActorAddServlet">영화배우 등록</a>
		<hr>
		<a class="sakila-nav-menu-item" href="${pageContext.request.contextPath}/auth/StoreStatsServlet">매장 통계</a>
		<a class="sakila-nav-menu-item" href="${pageContext.request.contextPath}/auth/MVPServlet">MVP</a>
	</div>
</nav>