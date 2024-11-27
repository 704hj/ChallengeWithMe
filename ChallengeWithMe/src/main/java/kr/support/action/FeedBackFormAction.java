package kr.support.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;


public class FeedBackFormAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");

        // 🐇 1. 세션에서 로그인 정보 확인
        HttpSession session = request.getSession();
        Long userNum = (Long) session.getAttribute("us_num");

        if (userNum == null) {
            // 로그인이 되어 있지 않으면 로그인 페이지로 리다이렉트 🐰
            request.setAttribute("error", "로그인 후 글을 작성할 수 있습니다. 로그인 페이지로 이동합니다.");
            return "redirect:/xuser/loginForm.jsp";
        }
            return "support/feedBack.jsp";
    }
}
