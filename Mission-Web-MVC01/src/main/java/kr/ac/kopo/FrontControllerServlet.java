package kr.ac.kopo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.controller.HandlerMapping;

// 실제 역할을 위해 httpservlet 상속필요 (대표서블릿이 되고 싶음)
public class FrontControllerServlet extends HttpServlet{
	
	private HandlerMapping mappings;
	
	
	// 최초 한 번만 실행하는 init, config는 서블릿에 대한 환경설정
	// 서비스 요청할 때마다 객체 만드는 것에 대한 메모리 부하가 많아지므로 한 번만 생성하고 같이 공유하려는 목적
	@Override
	public void init(ServletConfig config) throws ServletException{
		
		// bean.properties의 경로 뽑아오기
		String propLoc = config.getInitParameter("propertyLocation");
		//System.out.println(propLoc);
		
		// web.xml에 init 파라미터 입력이 안되어있을 경우
		if(propLoc != null)
			mappings = new HandlerMapping(propLoc);
		else
			mappings = new HandlerMapping();
	}
	
	
   // 라이프 사이클 중 서비스부터 구현
   public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      
	  String context = request.getContextPath(); // 앞에 /Mission-Web-MVC01 이 부분, 계속 써주는거 없애기 위함
	 // System.out.println("context : " + context);
	  
	  
	  String uri = request.getRequestURI();
	 // System.out.println("uri :" + uri);
	  // 전체 uri
	  
	  uri = uri.substring(context.length());
	  // 요청받은 uri를 뽑아냄, 달라지는 부분
	  //System.out.println("substring후 uri : " + uri);
      
	  
//	  String callPage = ""; //지역변수로 선언되어있는거 밖에서 선언 
//	  
//	  Controller control = null;
	  
	  
	  try {
			// 요청한 uri에 해당하는 컨트롤러를 받아옴
			Controller control = mappings.getController(uri);
			// ex Controller control = new BoardListController(); 이렇게 됨
			
			// 리턴된 값 (.jsp)를 callPage에 저장, 이곳으로 forward를 해라
			String callPage = control.handleRequest(request, response);
			
			
			if(callPage.startsWith("redirect:")) { // 어떨 때는 포워드하고, 어떨 때는 굳이 포워드 안해도된다
				//redirect 시작하면, sendRedirect
//				response.sendRedirect(callPage);
				
				//만약 로그아웃이라면, callPage ="redirect:/index.jsp"
				// /index.jsp만 추출하고 싶다!
				
				//System.out.println(callPage);
				callPage = callPage.substring("redirect:".length());
				
				// 이거는 xml, forward, include가 아니니까 경로 지정을 추가로 해야지
				response.sendRedirect(request.getContextPath() + callPage);
				
			}else {
				// forward 해주는게 RequestDispatcher
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
				dispatcher.forward(request, response);
			}
			

		} catch (Exception e) {
		e.printStackTrace();
		throw new ServletException(e);
	}
      
   }
}