<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>챌린지 사용 가이드</title>
    
</head>
<body>
    <div class="container">
        <div class="header">챌린지 사용 가이드 🐥✨</div>

        <!-- 챌린지 소개 -->
        <div class="section">
            <div class="section-title">챌린지가 무엇인가요? 🐇</div>
            <div class="section-content">
                챌린지는 목표를 설정하고 꾸준히 도전하며 스스로 성장할 수 있도록 도와주는 서비스입니다. <br>
                재미있는 미션과 함께 목표를 달성해보세요! 🎯
            </div>
        </div>

        <!-- 챌린지 참여 방법 -->
        <div class="section">
            <div class="section-title">챌린지 참여 방법 🐥</div>
            <div class="section-content">
                챌린지에 참여하려면 아래 단계를 따라주세요:
                <ul>
                    <li>1️⃣ <strong>회원 가입:</strong> 먼저 회원 가입을 완료해주세요.</li>
                    <li>2️⃣ <strong>챌린지 선택:</strong> 다양한 카테고리 중 원하는 챌린지를 선택합니다.</li>
                    <li>3️⃣ <strong>참여 신청:</strong> 챌린지 페이지에서 "참여하기" 버튼을 클릭하세요.</li>
                    <li>4️⃣ <strong>미션 수행:</strong> 매일 주어진 미션을 수행하고 인증하세요!</li>
                    <li>5️⃣ <strong>성공 인증:</strong> 챌린지를 완료하면 보상이 기다리고 있어요! 🎉</li>
                </ul>
            </div>
        </div>

        <!-- 챌린지 유의 사항 -->
        <div class="section">
            <div class="section-title">챌린지 진행 시 유의 사항 🐰</div>
            <div class="section-content">
                <ul>
                    <li>✅ 챌린지 기간 내에 미션을 완료해야 성공으로 인정됩니다.</li>
                    <li>✅ 사진 인증이 필요한 경우 가이드라인을 꼭 확인해주세요.</li>
                    <li>✅ 다른 참가자와의 규칙을 존중하며 함께 즐겨주세요!</li>
                </ul>
            </div>
        </div>

        <!-- 고객센터 안내 -->
        <div class="section">
            <div class="section-title">추가 도움이 필요하세요? 🐇</div>
            <div class="section-content">
                더 궁금한 점이 있다면 <a href="SupportMain.do" style="color: #ff9900;">고객센터</a>를 방문하거나 <a href="SupportWrite.do" style="color: #ff9900;">문의하기</a>를 남겨주세요. <br>
                저희가 도와드릴게요! 🐥✨
            </div>
        </div>

        <!-- 버튼 -->
        <div class="btn-group">
            <button class="btn" onclick="window.history.back();">이전 페이지</button>
            <button class="btn" onclick="location.href='${ pageContext.request.contextPath }/mychallenge/myChallengePart.do'">챌린지 메인으로 이동</button>
        </div>
    </div>
</body>
</html>
