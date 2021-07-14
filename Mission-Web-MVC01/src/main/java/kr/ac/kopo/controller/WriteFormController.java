package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormController implements Controller{

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//게시글 등록폼은 db접근할 필요없는데?
		// write.jsp에서 db에 접근해야함
		
		
		return "/board/writeForm.jsp";

	}
}
