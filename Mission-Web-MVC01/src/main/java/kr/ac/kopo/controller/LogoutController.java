package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		// 세션 삭제, 세션 객체 받아와주어야함
		HttpSession session = request.getSession();
		session.invalidate();
		
		
//		response.sendRedirect(request.getContextPath()); 굳이 logout.jsp를 만들필요도 없음
		// jsp를 안쓰면 포워드를 안하겠다는 것
		// 어떨때는 포워드를 하고, 어떨 때는 포워드를 하도로 바꾸면 좋지 않을까? fcs로 가보자
		
		// forward
		//return "/logout/logout.jsp";
		
		// redirect, 접두어를 붙이면 redirect: 를 붙인다, 이게 안붙으면 일반적으로 forward
		return "redirect:/";
		// Mission-Web-MVC01로감 => 결국 index.jsp로 가겠지
	}

}
