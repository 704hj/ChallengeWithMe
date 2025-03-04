<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이첼린지 메인</title>

<link rel="stylesheet"href="${pageContext.request.contextPath}/css/header.css" type="text/css">
<link rel="stylesheet"href="${pageContext.request.contextPath}/css/khr.css" type="text/css">
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-3.7.1.min.js"></script>
	
<head>
<meta charset="UTF-8">
<title>참여 챌린지</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<h1>참여 챌린지</h1>
 
<div class="page-main-part">
    <div class="mychallenge-content-main-part">
         <div class="mychallenge-div-part">
            <ul>
                <li>
                    <c:if test="${empty xuser.photo}">
                        <img src="${pageContext.request.contextPath}/images/face.png" width="150" height="150" class="my-photo">
                    </c:if>
                    <c:if test="${!empty xuser.photo}">
                        <img src="${pageContext.request.contextPath}/upload/${xuser.photo}" width="150" height="150" class="my-photo">
                    </c:if>
                </li>
            </ul>
        <table id="simple_info_table3">
            <thead>
                <tr>
                    <th colspan="2">MY 챌린지 참여/개설 정보</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>시작전</td>
                    <td>${partTable1.part_count}</td>
                </tr>
                <tr>
                    <td>참여 중</td>
                    <td>${partTable2.part_count}</td>
                </tr>
                <tr>
                    <td>실패</td>
                    <td>${partTable3.part_count}</td>
                </tr>
                <tr>
                    <td>포기</td>
                    <td>${partTable4.part_count}</td>
                </tr>
                 <tr>
                    <td>완료</td>
                    <td>${partTable5.part_count}</td>
                </tr>
                <tr>
                    <td>개설</td>
                    <td>${partTable1.chall_count}</td>
                </tr>
            </tbody>
        </table>
        
        
        </div>
        
        </div>
        
    <div class="align-h">
    
      <!-- 버튼들을 세로로 정렬 -->
    <div class="button-wrapper">
        <input type="button" value="참여 챌린지" id="part_ch_btn" onclick="location.href='${pageContext.request.contextPath}/mychallenge/myChallengePart.do'">
        <input type="button" value="개설 챌린지" id="gen_ch_btn" onclick="location.href='${pageContext.request.contextPath}/mychallenge/myChallengeMake.do'">
    </div>

    <!-- 이미지가 가로로 정렬되는 부분 -->
    <div class="part-image-wrapper">
        
    <div class="part-image">
    
    <c:forEach var="part_list" items="${part_list}">
    
      <a href="${pageContext.request.contextPath}/mychallenge/myChallengePartDetail.do?ch_num=${part_list.ch_num}">
      <c:if test='${part_list.cate_num==1}'><img src="${pageContext.request.contextPath}/images/food.jpg" class="img1"></c:if>
                        <c:if test='${part_list.cate_num==2}'><img src="${pageContext.request.contextPath}/images/food.jpg" class="img1"></c:if>
                        <c:if test='${part_list.cate_num==3}'><img src="${pageContext.request.contextPath}/images/study.jpg" class="img1"></c:if>
                         <c:if test='${part_list.cate_num==4}'><img src="${pageContext.request.contextPath}/images/wakeup.jpg" class="img1"></c:if>
                         <c:if test='${part_list.cate_num==5}'><img src="${pageContext.request.contextPath}/images/economy.jpg" class="img1"></c:if>
                        <c:if test='${part_list.cate_num==6}'><img src="${pageContext.request.contextPath}/images/economy.jpg" class="img1"></c:if>
          
      </a>
    </c:forEach>            
    </div>

    </div>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>