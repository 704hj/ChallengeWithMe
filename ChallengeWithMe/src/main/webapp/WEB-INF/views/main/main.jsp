<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css" type="text/css">

</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="page-main">
		<div class="space100-div"></div>
		<div class="m-title-container align-center">
			<h1>작심삼일? 이제는 끝!</h1>
		</div>
		<div class="space150-div"></div>
		<div class="m-header1-container">
			<div class="header1-box box1">
				<div class="header-item item1 align-left">꼬박꼬박은?</div>
				<div class="header-item item2">
					꼬박꼬박은 모두가 함께 참여하는 챌린지 입니다<br> 2주 ~ 6주동안 진행하고, 목표를 완성할 수 있어요
				</div>
				<div class="header-item item3">
					<button class="item3-btn" type="button"
						onclick="location.href='${pageContext.request.contextPath}/challenge/challengeMain.do'">챌린지
						시작하기</button>
				</div>
			</div>
			<div class="header1-box box2">
				<c:if test="${us_num != null && admin == 0}">
					<div class="user-card shadow-effect">
						<div class="card-left">
							<div class="left1">
								<div class="left1Img align-center">
									<c:choose>
										<c:when test="${list.cate_num == 1}">
											<img src="../images/Level1.png">
										</c:when>
										<c:when test="${list.cate_num == 2}">
											<img src="../images/Level2.png">
										</c:when>
										<c:when test="${list.cate_num == 3}">
											<img src="../images/Level3.png">
										</c:when>
										<c:when test="${list.cate_num == 4}">
											<img src="../images/Level4.png">
										</c:when>
										<c:when test="${list.cate_num == 5}">
											<img src="../images/Level5.png">
										</c:when>
										<c:otherwise>
											<img src="../images/Level1.png">
										</c:otherwise>
									</c:choose>
									
								</div>
								<div>
									<p>나의 등급</p>
									<p>Lv${rank}</p>
								</div>
							</div>
							<div class="left2">
								<div class="left2-title">보유 배찌</div>
								<hr>
								<div class="left2-container">
									<div class="left2-box1">
										<img src="../images/face.png" width="50px" height="50px">
									</div>
									<div class="left2-box2">
										<ul>
											<li><label>보유배찌</label>6개</li>
											<li><label>미획득배찌</label>10개</li>
										</ul>
									</div>
								</div>

							</div>
							<div class="left3">
								<div class="info-link">나의배찌 -></div>
							</div>
						</div>
						<hr class="vertical">
						<div class="card-right">
							<div class="right1">
								<div class="right1-box1">
									<img src="../images/face.png">
									<div class="right-user">
										<p>환영합니다</p>
										<p>${xuser.nickname}님</p>
									</div>
								</div>
							</div>
							<div class="right2">
								<ul>
									<li><label>참여중인 챌린지</label>${ score_vo.join_num - score_vo.complete_num - score_vo.quit_amount}개</li>
									<li><label>완료한 챌린지</label>${score_vo.complete_num}개</li>
									<li><label>랭크 점수</label>${score_vo.us_score}점</li>
								</ul>
							</div>
							<div class="right3">
								<div class="info-link">마이페이지 -></div>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		<div class="space100-div"></div>
		<hr>
		<div class="space50-div"></div>
		<div class="m-content1-container">
			<div class="space50-div"></div>
			<div class="m-content1-title">누구나 할 수 있습니다!</div>
			<div class="content1-box c1-box1 ">
				<div class="c1b1-item itema1 shadow-effect">
					<div class="c1b1-title shadow-effect">달성률 100%</div>
					<div class="c1b1-content">계획해놨던 목표 제대로 끝까지 완료하고싶은 사람</div>
				</div>
				<div class="c1b1-item itema2 shadow-effect">
					<div class="c1b1-title shadow-effect">챌린지 소개</div>
					<div class="c1b1-content">매일 같이 물 먹어요!</div>
				</div>
				<div class="c1b1-item itema3 shadow-effect">
					<div class="c1b1-title shadow-effect">참여 챌린지</div>
					<div class="c1b1-content">매일 새로운 챌린지가 오픈! 매일  습관을 만들고 싶은 사람</div>
				</div>
				<div class="c1b1-item itema4 shadow-effect">
					<div class="c1b1-title shadow-effect">챌린지 소개</div>
					<div class="c1b1-content">매일 같이 물 먹어요!</div>
				</div>
			</div>
			<div class="content1-box c1-box2">
				<div class="c1b2-item itemb1">
					<div class="p1">현재 챌린지 수</div>
					<div class="p2">100개</div>
				</div>
				<div class="c1b2-item itemb2">
					<div class="p1">누적 참여 후기</div>
					<div class="p2">1360개</div>
				</div>
				<div class="c1b2-item itemb3">
					<div class="p1">누적 완료 챌린지</div>
					<div class="p2">630개</div>
				</div>
			</div>

		</div>
		<div class="space150-div"></div>
		<hr>
		<div class="m-content2-container">
			<div class="c2-title">어떻게 쓰는건가요</div>
			<div class="content2-box">
				<div class="c2b1-item itemc1">
					<div class="p1">
						<span>|</span> 함께하는 챌린지!
					</div>
					<div class="p2">아침 7시, 완료해야 하는 챌린지를 알려드립니다. 주어진 시간안에 인증해야
						합니다!</div>
				</div>
				<div class="c2b1-item itemc2">
					<div class="itemc2-btn">
						<button class="clicked">챌린지</button>
						<button>일정표</button>
						<button>커뮤니티</button>
						<button>후기</button>
					</div>
					<div class="c2b1-item itemc3 shadow-effect">content2 내용</div>
				</div>
			</div>
		</div>
		<div class="m-content3-container">
			<div class="c3-title">공식 챌린지</div>
			<div class="c3-content">
			<!-- ----------------------------슬라이더 시작----------------------------------- -->
				<div class="prev-btn align-center">
					<img src="../images/left.png" width="20vw" height="30vw">
				</div>
				<div class="slider-main align-center">
					<c:forEach var="list" items="${official_list}">
						<c:if test="${list.ch_title == ''}">
							내용 있음
						</c:if>
						<c:if test="${list.ch_title != ''}">
							내용 없음
						</c:if>
					</c:forEach>
				</div>
				<div class="next-btn align-center">
					<img src="../images/right.png" width="20vw" height="30vw">
				</div>
			<!-- -----------------------------슬라이더 끝----------------------------------- -->
			</div>
		</div>
		<div class="m-content4-container">
			<div class="c4-header">
				<div class="c4-title">사용자 챌린지</div>
				<div class="linkToChall" onclick="location.href='${pageContext.request.contextPath}/challenge/challengeList.do?'">챌린지 바로가기-></div>
			</div>
			<div class="c4-content">
				<c:forEach var="list" items="${chall_list}">
					<div class="ch-item">

						<div class="item-header">
							<div class="ch-category">${list.cate_name}</div>
						</div>
						<a
							href="${pageContext.request.contextPath}/challenge/challengeDetail.do?ch_num=${list.ch_num}">
							<div class="ch-background">
								<c:if test="${empty list.ch_img}">
									<c:choose>
										<c:when test="${list.cate_num == 1}">
											<img class="ch-bgImg" src="../images/health.jpg"
												style="max-width: 100%; max-height: 100%;" />
										</c:when>
										<c:when test="${list.cate_num == 2}">
											<img class="ch-bgImg" src="../images/food.jpg"
												style="max-width: 100%; max-height: 100%;" />
										</c:when>
										<c:when test="${list.cate_num == 3}">
											<img class="ch-bgImg" src="../images/self-develop.jpg"
												style="max-width: 100%; max-height: 100%;" />
										</c:when>
										<c:when test="${list.cate_num == 4}">
											<img class="ch-bgImg" src="../images/wakeup.jpg"
												style="max-width: 100%; max-height: 100%;" />
										</c:when>
										<c:when test="${list.cate_num == 5}">
											<img class="ch-bgImg" src="../images/economy.jpg"
												style="max-width: 100%; max-height: 100%;" />
										</c:when>
										<c:when test="${list.cate_num == 6}">
											<img class="ch-bgImg" src="../images/stop.jpg"
												style="max-width: 100%; max-height: 100%;" />
										</c:when>
										<c:otherwise>
											<img class="ch-bgImg" src="../images/face.png"
												style="max-width: 100%; max-height: 100%;" />
										</c:otherwise>
									</c:choose>
								</c:if>
								<c:if test="${!empty list.ch_img}">
									<img class="ch-bgImg"
										src="${pageContext.request.contextPath}/upload/${list.ch_img}"
										style="max-width: 100%; max-height: 100%;">
								</c:if>
								<p class="ch-title">${list.ch_title}</p>
								<div class="ch-dueDate align-center">
									<c:if test="${list.dateDifference > 0 && list.ch_status != 'finished'}">
										<div class="font-before">D-${list.dateDifference}</div>
									</c:if>
									<c:if test="${list.dateDifference <= 0  && list.ch_status != 'finished'}">
										D+${list.dateDifference * -1}
									</c:if>
									<c:if test="${list.ch_status == 'finished'}">
										<div class="font-end">OVER</div>
									</c:if>
								</div>
							</div>
							<div class="ch-info">
								<div class="ch-people">
									<img class="people-img"
										src="${pageContext.request.contextPath}/images/person.svg">
									<div class="info-val">${list.ch_person}/${list.ch_max}</div>
								</div>
								<div class="ch-like">
									<img class="like-img"
										src="${pageContext.request.contextPath}/images/chat-square-heart.svg">
									<div class="info-val">${list.ch_like}</div>
								</div>
								<div class="ch-view">
									<img class="view-img"
										src="${pageContext.request.contextPath}/images/eye.svg">
									<div class="info-val">${list.ch_view}</div>
								</div>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>

		<div class="space150-div"></div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>



