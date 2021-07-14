package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.BoardVO;

public class BoardDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// list.jsp에서 게시물을 선택할 때, 함께 넘어온 게시물 번호
		int no = Integer.parseInt(request.getParameter("no"));
		
		//이 번호에 해당하는 게시물을 db에서 가져오기

		kr.ac.kopo.board.BoardDAO dao = new kr.ac.kopo.board.BoardDAO();
		
		BoardVO board = dao.selectByNo(no);
		
		request.setAttribute("board", board);
		
		return "/board/detail.jsp";
		
		
		
	}

}
