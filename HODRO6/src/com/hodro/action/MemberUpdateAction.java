package com.hodro.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberUpdateAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url ="member_update.jsp";
		
		//회원 정보 수정을 하려면 반드시 선행 조건 
		// 로그인이 되있어야 함 !!!
		//session이 null이 아니면 =로그인
		HttpSession session = request.getSession(); //session값 취득
		if(session.getAttribute("loginUser") == null) {//로그인 안된경우
			url ="index.bizpoll";
		}else {// 로그인 된 경우 
			url="member_update.jsp";
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}
	
}
