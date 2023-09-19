package com.poscodx.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poscodx.mysite.repository.BoardRepository;
import com.poscodx.mysite.repository.PagingRepository;
import com.poscodx.mysite.service.BoardService;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.GuestbookVo;
import com.poscodx.mysite.vo.PagingVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("")
	public String main(@RequestParam("page") int page, Model model) {
		PagingVo paging = new PagingVo();

		paging.setPage(page);
		paging.setTotalCount(new PagingRepository().findTotalCount().getTotalCount());
		List<BoardVo> list = boardService.getBoardList(paging.getPage(), paging.getLimit());

		// userNo를 이용하여 userName 담기

		System.out.println(list);
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		return "board/list";
	}
	
	@RequestMapping("/view")
	public String main(@RequestParam("no") Long no, Model model) {
		BoardVo boardVo = new BoardRepository().findByNo(no);

		// 조회수 update
		new BoardRepository().updateHit(boardVo.getHit(), no);
		
		model.addAttribute("boardVo", boardVo);
		return "board/view";
	}
	

	@RequestMapping("/delete")
	public String delete(@RequestParam("no") Long no) {
		boardService.deleteContents(no);
		return "redirect:/board?page=1" ;
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(Model model) {
		return "board/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String delete(BoardVo vo) {
		boardService.addContents(vo);
		return "redirect:/board?page=1";
	}
	


}