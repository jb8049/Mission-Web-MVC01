package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.member.memberDAO;
import kr.ac.kopo.member.memberVO;

public class MemberDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		
		
		memberDAO dao = new  memberDAO();
		memberVO member = new memberVO();
		
		member = dao.selectOne(id);
		
		request.setAttribute("member", member);
		
		//íŽėë í  .jsp
		return "/member/memberDetail.jsp";
	}

}
