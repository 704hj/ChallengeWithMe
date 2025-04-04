package kr.support.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.support.dao.SupportDAO;
import kr.support.vo.SupportVO;
import kr.util.PagingUtil;
import kr.xuser.vo.XuserVO;
import kr.controller.Action;
import kr.mypage.dao.MyPageDAO;

import java.util.List;

public class ListAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 사용자에게 보여줄 페이지 번호를 받아오기
        String pageParam = request.getParameter("pageNum");
        int page = (pageParam == null) ? 1 : Integer.parseInt(pageParam);

        // 한 페이지에 몇 개의 항목을 보여줄지 설정
        int pageSize = 10;

        // DAO를 이용해서 데이터 가져오기
        SupportDAO dao = SupportDAO.getInstance(); // DAO 싱글톤 인스턴스 사용

        // 전체 게시글 수 가져오기 (페이지네이션 계산용)
        int totalCount = dao.getSupportCount();

        // 페이징 처리: 시작 행과 가져올 행 수 설정
        PagingUtil totalPages = new PagingUtil(page, totalCount, 20, pageSize, "List.do");

        // 전체 게시글 목록 가져오기
        List<SupportVO> list = dao.getAllSupports(totalPages.getStartRow(), totalPages.getEndRow());

        // 세션에서 로그인한 사용자 정보 가져오기
        HttpSession session = request.getSession();
        Long userNum = (Long)session.getAttribute("us_num");

        if (userNum == null) {
            request.setAttribute("error", "로그인 후에 확인 가능합니다! 🐇");
            return "support/loginRequired.jsp"; // 로그인 필요 안내 페이지로 이동
        }

        // 비공개 게시물의 경우 작성자 본인만 확인할 수 있도록 표시
        for (SupportVO support : list) {
            // 비공개 게시물의 경우, 작성자 본인이 아닐 때 내용 변경
            if (support.getSup_visi()==1 && support.getUs_num() != userNum) { // 수정된 부분
                support.setSup_content("작성자 본인만 확인할 수 있는 게시물입니다."); // 비공개 게시물에 메시지 추가
            }
        }
        // 팝업창에서 전달된 비밀번호 확인 로직 추가
        String supNumParam = request.getParameter("sup_num"); // 게시글 번호
        String supPwd = request.getParameter("sup_pwd"); // 팝업창에서 입력된 비밀번호

        if (supNumParam != null && supPwd != null) {
            long supNum = Long.parseLong(supNumParam); // 게시글 번호 파싱
            boolean isPasswordValid = dao.validatePrivatePwd(supNum, supPwd); // 비밀번호 확인 로직 호출

            if (isPasswordValid) {
                // 비밀번호가 맞으면 상세 페이지로 이동
                return "redirect:/support/Detail.do?sup_num=" + supNum;
            } else {
                // 비밀번호가 틀리면 에러 메시지를 추가하고 리스트로 복귀
                request.setAttribute("error", "비밀번호가 일치하지 않습니다! 🐇");
                return "support/list.jsp"; // 팝업에서 바로 리스트로 복귀
            }
        }
       MyPageDAO dao2 = MyPageDAO.getInstance();
       XuserVO xuser =  dao2.getMyInfo(userNum);
        // 뷰에 필요한 데이터를 request에 저장
        request.setAttribute("xuser", xuser);
        request.setAttribute("list", list);
        request.setAttribute("totalPages", totalPages.getPage());

        // 리스트 페이지로 이동
        return "support/list.jsp";
    }
}
