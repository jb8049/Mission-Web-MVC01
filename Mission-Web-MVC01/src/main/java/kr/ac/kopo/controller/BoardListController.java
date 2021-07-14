package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.BoardDAO;
import kr.ac.kopo.board.BoardVO;

public class BoardListController implements Controller {
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		 BoardDAO dao = new BoardDAO(); 
		 List<BoardVO> list = dao.selectAll();
		
		 //공유영역에 넣어놓고 포워드한 .jsp에서 사용할 것임 
		 request.setAttribute("list", list);
		 
		
		return "/board/list.jsp";
	}
}