<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${ ban == 1 }">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 안내</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css" type="text/css">
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div>
		<div>
			<h2>계정 안내</h2>
			<div>
				<div>
					정지된 계정입니다.<br>
					<input type="button" value="메인으로"
					onclick="location.href='${ pageContext.request.contextPath }/main/main.do'">
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
	</c:when>
	<c:otherwise>
		<script>
			alert('아이디 또는 비밀번호가 불일치합니다.')
			history.go(-1)
		</script>
	</c:otherwise>
</c:choose>
	