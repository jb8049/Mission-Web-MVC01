package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 로그인은 따로 비즈니스 로직이 필요없음
		
		// 최초 로그인할 때 사용하는 것 아님 
		HttpSession session = request.getSession();
		String msg = (String)session.getAttribute("msg");
		
		//session 영역에서 삭제, request영역에 추가 -> login.jsp에 전달
		//session에 등록한 "msg"를 삭제해야하는데, msg를 삭제하는 거 작성함..
		session.removeAttribute("msg");
		
		request.setAttribute("msg", msg);
		
		//포워드 시키려는 .jsp
		return "/login/login.jsp";
	}

}
