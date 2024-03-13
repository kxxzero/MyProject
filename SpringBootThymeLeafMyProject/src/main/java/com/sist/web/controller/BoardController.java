package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.web.dao.BoardDAO;
import com.sist.web.entity.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("/board/list")
	public String boardList(String page, Model model) {
		Board vo=new Board(); 
		model.addAttribute("vo", vo);
		
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowSize=10;
		int start=(rowSize*curpage)-rowSize; //Limit => 0
		List<Board> list=dao.boardListData(start);
		int count=(int)dao.count();
		int totalpage=(int)(Math.ceil(count/10.0));
	   
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		model.addAttribute("main_html", "board/list");
		return "main";
	}
	
	// 작성 => 모양 폼만 생성
	@GetMapping("/board/insert")
	public String boardInsert(Model model) {
		model.addAttribute("main_html", "board/insert");
		return "main";
	}
	
	// 실제 작성 => redirect
	@PostMapping("/board/insert_ok")
	public String boardInsertOk(Board vo) {
		dao.save(vo);
		return "redirect:/board/list";
	}
	
	// 상세보기
	// 수정
	// 실제 수정 => redirect => detail 보여주기
	// 삭제
	// 실제 삭제 => redirect => list 보여주기
}
