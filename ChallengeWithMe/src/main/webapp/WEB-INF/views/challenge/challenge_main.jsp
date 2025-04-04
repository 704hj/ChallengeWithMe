<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꼬박꼬박 챌린지</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/sw.css" type="text/css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="page-main">

		<div class="challenge_title">
			<p>당신의 도전을 환영합니다</p>
		</div>
		<div id="menu_container">
			<div class="ch-menu">
				<a href="${pageContext.request.contextPath}/challenge/challengeList.do">
				<img class="ch-img"
					src="${pageContext.request.contextPath}/images/teamwork.jpg">
				</a>
				<p>챌린지 참여</p>
			</div>
			<div class="ch-menu">
			<a href="${pageContext.request.contextPath}/challenge/challengeCreateForm.do">
				<img class="ch-img"
					src="${pageContext.request.contextPath}/images/start2.PNG">
			</a>
				<p>챌린지 개설</p>
			
			</div>
			<div class="ch-menu">
			<a href="${pageContext.request.contextPath}/challenge/challengeOfficialList.do">
				<img class="ch-img"
					src="${pageContext.request.contextPath}/images/success2.jpg">
			</a>
				<p>공식 챌린지 참여</p>
			</div>

		</div>
		<div class="space500-div"></div>

	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>