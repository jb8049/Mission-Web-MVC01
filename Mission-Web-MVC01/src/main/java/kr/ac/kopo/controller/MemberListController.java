package kr.ac.kopo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.member.memberDAO;
import kr.ac.kopo.member.memberVO;

public class MemberListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<memberVO> memberList = new ArrayList<>();
		
		memberDAO dao = new memberDAO();
		
		memberList = dao.selectAll();
		
		request.setAttribute("memberList", memberList);
		
		// return 하는건 포워드할 .jsp 화면에 보여줄 부분임 ;
		return "/member/memberList.jsp";
	}

}
