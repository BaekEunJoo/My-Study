package com.spring.biz.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	//리턴타입 : ModelAndView ---> String
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println(">> 게시글 상세 보여주기");
		
		BoardVO board = boardDAO.getBoard(vo);
		
		//ModelAndView mav = new ModelAndView();
		//mav.addObject("board", board); // Model에 데이터 저장
		//mav.setViewName("getBoard.jsp"); // View 명칭 저장
		
		model.addAttribute("board", board);
		
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDAO boardDAO, Model model,
			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) 
			String condition,
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false)
			String keyword) {
		System.out.println(">> 게시글 목록 보여주기");
		System.out.println("condition : " + condition);
		System.out.println("keyword : -" + keyword + "-");

		List<BoardVO> list = boardDAO.getBoardList();
		
		//mav.addObject("boardList", list); // Model에 데이터 저장
		//mav.setViewName("getBoardList.jsp"); // View 명칭 저장
		
		model.addAttribute("boardList", list);
		
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO dao) {
		System.out.println(">>>>> 게시글 입력");
		System.out.println("vo : " + vo);
		dao.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">> 게시글 수정");
		System.out.println("vo : " + vo);
		
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">> 게시글 삭제");
		System.out.println("vo : " + vo);
		
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
	}
}
