package com.spring.biz.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.view.controller.Controller;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">> 게시글 상세 보여주기");
		//1. 전달받은 데이터 추출(확인)
		String seq = request.getParameter("seq");
		
		//2-1. DB 연동작업(조회-SELECT)
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		//2-2. 찾은 데이터를 세션에 저장(뷰에서 사용할 수 있도록)
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		//3. 페이지 전환(상세보기 페이지)
		//response.sendRedirect("getBoard.jsp");
		
		return "getBoard";
	}

}
