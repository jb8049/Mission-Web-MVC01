package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.login.dao.LoginDAO;
import kr.ac.kopo.login.vo.LoginVO;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id"); 
		String password = request.getParameter("password");
		
		LoginVO loginVO = new LoginVO();
		loginVO.setId(id);
		loginVO.setPassword(password);
		
		LoginDAO dao = new LoginDAO();
		LoginVO userVO = dao.login(loginVO);
		
		String msg="";
		String url="";
		
		if(userVO == null) {
			
			//로그인 실패
			msg = "아이디 또는 패스워드를 잘못입력하셨습니다.";

//			url = "redirect:/login.do";
//			HttpSession session
			
			
			//url="login.jsp" .jsp로 가면 안됨, .jsp는 화면단만 구성하기 때문임
//			url = request.getContextPath() + "/login/login.do";
			
			url = "redirect:/login/login.do";
			
			HttpSession session = request.getSession();
			session.setAttribute("msg", msg);
			
		}else {
			
			//로그인 성공
			msg = "로그인을 성공하였습니다.";
//			url = request.getContextPath();
			url = "redirect:/";
			
			//세션 등록, 이거는 jsp가 아니라 자바파일, session객체를 그냥 사용할 수 없음
			// 4가지의 공유영역 중,controller가 그냥 사용할 수 있는 공유영역은 request밖에 없음!!
			
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);	
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		
		// 여기서도 sendRedirect 사용할 수 있지 않을까
		//return "/login/loginProcess.jsp";
		
		return url;
	}

}
