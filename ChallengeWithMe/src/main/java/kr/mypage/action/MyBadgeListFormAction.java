package kr.mypage.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.badge.vo.BadgeVO;
import kr.controller.Action;
import kr.mypage.dao.MyPageDAO;
import kr.xuser.vo.XuserVO;

public class MyBadgeListFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Long us_num = (Long)session.getAttribute("us_num");
		if(us_num == null) { // 로그인이 되지 않은 경우
			return "redirect:/xuser/registerXuserForm.do";
			
		}
		
		
	    MyPageDAO dao = MyPageDAO.getInstance();
	    XuserVO xuser = dao.getMyInfo(us_num);
	    List<BadgeVO> allBadges = dao.selectBadge();
	    List<Long> userBadgeNumbers = dao.getUserbadge(us_num);

	    // 소유 여부를 BadgeVO에 추가
	    for (BadgeVO badge : allBadges) {
	        badge.setOwned(userBadgeNumbers.contains(badge.getBg_num()));
	    }

	    // JSP로 전달
	    request.setAttribute("list", allBadges);
	    request.setAttribute("xuser", xuser);
	    
		return "mypage/mybadgelistForm.jsp";
	}

}
