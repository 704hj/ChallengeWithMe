![메인 화면](images/main.png)

## 꼬박꼬박

## 목차
📖 [프로젝트 개요](https://github.com/704hj/ChallengeWithMe/tree/main?tab=readme-ov-file#-%EB%AC%B8%EC%A0%9C-%ED%95%B4%EA%B2%B0)
⚙️ [개발환경 및 기술 스택](https://github.com/704hj/ChallengeWithMe/tree/main?tab=readme-ov-file#-%EB%AC%B8%EC%A0%9C-%ED%95%B4%EA%B2%B0)
😊 [담당 기능](https://github.com/704hj/ChallengeWithMe/tree/main?tab=readme-ov-file#-%EB%AC%B8%EC%A0%9C-%ED%95%B4%EA%B2%B0)
💡 [문제 해결](https://github.com/704hj/ChallengeWithMe/tree/main?tab=readme-ov-file#-%EB%AC%B8%EC%A0%9C-%ED%95%B4%EA%B2%B0)
❓ [느낀 점](https://github.com/704hj/ChallengeWithMe/tree/main?tab=readme-ov-file#-%EB%AC%B8%EC%A0%9C-%ED%95%B4%EA%B2%B0)

## 📖 프로젝트 개요


**1. 소개**  
  - 개   요 : 건강한 습관 형성을 위한 플랫폼 개발  
  - 작업기간: 2024/10/23 ~ 2024/12/03  
  - 팀원구성: 총 5명  

**2. 목표**  
  - 효율적인 시간 관리와 습관 형성을 돕는 도전 기록 및 상호 동기부여 플랫폼 구축

**3. 주요 기능**  
  - 효율적인 시간 관리와 건강한 습관 형성을 지원하는 플랫폼
  - 사용자가 직접 도전에 참여하고 목표를 공유하며 불특정 다수와 인증을 통해 지속성 유지 도모
  - 커뮤니티를 통해 상호 동기부여와 협력을 유도하여 긍정적인 변화를 함께 만들어가는 환경 제공


    
## ⚙️ 개발환경 및 기술 스택  

  - **개발 환경**  
    - OS: Windows 11  
    - Database: Oracle  

  - **사용 기술**  
      ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white)
      ![CSS3](https://img.shields.io/badge/CSS-239120?&style=for-the-badge&logo=css3&logoColor=white)
      ![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
      ![jQuery](https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white)

    
      ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
      ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=black)
      ![JDBC](https://img.shields.io/badge/JDBC-4479A1?style=for-the-badge&logo=oracle&logoColor=white)
      ![Servlet](https://img.shields.io/badge/Servlet-007396?style=for-the-badge&logo=java&logoColor=white)
      ![JSP](https://img.shields.io/badge/JSP-323330?style=for-the-badge&logo=eclipse&logoColor=white)
      ![Eclipse](https://img.shields.io/badge/eclipse-F2A13E?style=for-the-badge&logo=eclipse&logoColor=2C2255)




## 😊 담당 기능

**1. 메인**  
   ![main](https://github.com/704hj/ChallengeWithMe/blob/main/images/main.gif?raw=true)  
  - `HttpSession`을 활용하여 **로그인 상태 유지**  
  - 챌린지 목록 조회 (DAO를 활용하여 데이터 조회)  
  - 사용자의 점수를 기반으로 **등급 설정**  

**2. 헤더**  
   ![header](https://github.com/704hj/ChallengeWithMe/blob/main/images/header.gif?raw=true)  
  - jQuery를 활용한 **프로필 정보 노출/숨김 기능**  
  - JSTL을 이용하여 **등록된 프로필 사진 표시**  

**3. CRUD 기반 커뮤니티**  
   ![community](https://github.com/704hj/ChallengeWithMe/blob/main/images/comm.gif?raw=true)  

  - **검색 기능**  
    - Java와 SQL을 활용하여 **제목, 닉네임, 내용 기반의 다중 조건 검색 기능** 구현  
    - `LIKE 연산자`를 활용하여 필터링 처리  
  
  - **페이징 기능**  
    - `PagingUtil` 클래스를 활용하여 **게시글을 페이지 단위로 표시**  
    - 총 게시글 개수를 기반으로 동적 페이지네이션 구현  
  
  - **게시글 CRUD 기능**  
    - `session` 값을 활용하여 **작성자와 일치할 경우에만 수정/삭제 버튼 활성화**  
  
  - **댓글 기능**  
    - Java & SQL을 활용한 **댓글 등록, 수정, 삭제 및 페이징 처리**  
    - JavaScript & Ajax를 활용하여 **비동기 처리(페이지 새로고침 없이 반영)**  
    - `session` 값을 활용하여 **댓글 작성자에게만 수정/삭제 버튼 노출**  
  
  - **좋아요 기능**  
    - Java & SQL을 활용하여 **좋아요 상태 및 개수 관리**  
    - JavaScript & Ajax를 활용하여 **실시간 업데이트 구현**  



## 💡 문제 해결

**[NULL 값으로 인한 SQL 오류 방지]**  

- **문제점**  
  - `sub_sql` 값이 `NULL`일 경우, SQL 실행 시 오류 발생  

- **해결 과정**  
  - `sub_sql`을 **빈 문자열("")로 초기화**하여 안전한 SQL 조합  
  - NULL 값이 발생해도 예외 없이 실행될 수 있도록 예외 처리 추가  

- **결과**  
  - SQL 실행 오류 방지 및 유지보수성 향상  



## ❓ 느낀 점

- **프로젝트 진행 상황을 기록하며 성장**  
  - 프로젝트 진행 중 **매일 작성한 상세 일지**를 통해 개발 과정을 돌아볼 수 있었음  
  - 완료 후에도 **기록을 통해 문제 해결 과정 및 배운 점을 복습**할 수 있었음  
    ➡️[프로젝트 일지](https://www.notion.so/1718913a4d278078a4b1dc6da0fecf11)

