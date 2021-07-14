package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.BoardDAO;
import kr.ac.kopo.board.BoardVO;

public class WriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		request.setCharacterEncoding("utf-8");
		
		// 최신 게시물 번호도 불러와야함
		BoardDAO dao = new BoardDAO();
		int no = dao.selectNo();
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardVO board = new BoardVO();
		
		board.setNo(no);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		// boardVO로 insert
		dao.insert(board);
		
		
		//forward 대상
		return "/board/write.jsp";
	}

}
