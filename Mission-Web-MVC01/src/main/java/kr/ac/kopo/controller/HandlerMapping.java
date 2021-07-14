package kr.ac.kopo.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping { // 이것의 목적은 switch문을 대체하기 위한 것

	// getController에서 mappings를 보기 위해
	private Map<String, Controller> mappings;

	// 아무것도 없는 property 파일, web.xml에 init파라미터가 입력이 안되어 있을 경우
	public HandlerMapping() {
		
		this("C:\\Lecture\\web-workspace\\Mission-Web-MVC01\\bean.properties");
		
	}
	
	
	public HandlerMapping(String propLoc) {
		
		mappings = new HashMap<>();
		
		Properties prop = new Properties();

		try {
			
			// bean 파일 읽어오기, 근데 경로는 만드는 사람에 따라서 계속 바뀔 수 있다, properties파일의 경로도 유연하게 해주어야함
//			InputStream is = new FileInputStream("C:\\Lecture\\web-workspace\\Mission-Web-MVC01\\bean.properties");
			InputStream is = new FileInputStream(propLoc);
			prop.load(is);
			
			
			// key를 입력하면 value가 나옴
			//System.out.println(prop.getProperty("/board/list.do"));
			
			Set<Object> keys = prop.keySet();
			
			for(Object key : keys) {
				
				System.out.println(key);
				
				// object형(key)을 String형으로, getProperty는 String형
				// key로 value를 얻어오는 getProperty
				String className = prop.getProperty(key.toString());
				
				// key에 따른 value
				System.out.println(className);
				
				// 뽑아낸 className은 uri에 따른 컨트롤러 클래스 => 인스턴스를 생성해주어야함
				Class<?> clz = Class.forName(className);
				
				//mappings<String uri, Controller 객체>, 해당 클래스의 인스턴스를 만들어서 map에 저장
				mappings.put(key.toString(), (Controller)clz.newInstance());
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// key value형태로 uri와 control 저장
//		mappings = new HashMap<>();

		// 어떤 uri가 들어왔을 때 어떤 작업을 할 지 결정
		// forward 할 거기 때문에 경로가 이렇다
	     
		
//		  mappings.put("/board/list.do", new BoardListController());
//		  mappings.put("/board/writeForm.do", new WriteFormController());
//		  mappings.put("/board/write.do", new WriteController());
//		  mappings.put("/board/detail.do", new BoardDetailController());
//		 
//		 
//		  mappings.put("/member/member.do", new MemberListController());
//		  mappings.put("/member/memberDetail.do", new MemberDetailController());
		 
//	switch(uri) { => Map 형태로 변환
//	  
//	//해당 uri가 들어왔을 때 ~ 컨트롤러로 작업을 할거야
//
//	  case "/board/list.do" :
//		  	  
//		  control = new BoardListController();
//		  break;
//		  
//	  case "/board/writerForm.do" :
//
//		  control = new WriteFormController();
//		  break;
//	  }
	}

	public Controller getController(String uri) {

		// key에 해당하는 value를 얻어옴
		return mappings.get(uri);

	}
	
//	public static void main(String[] args) {
		
//		try {
//			Class<?> clz = Class.forName("kr.ac.kopo.controller.BoardListController");
////			객체 생성 => clz.newInstance();
//			// new BoardListController()를 만든것과 동일함
//			BoardListController list = (BoardListController)clz.newInstance();
//			System.out.println(list.handleRequest(null, null));
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
		
		
		
	}


