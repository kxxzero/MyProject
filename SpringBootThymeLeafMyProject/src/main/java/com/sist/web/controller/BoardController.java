package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.web.dao.BoardDAO;
import com.sist.web.entity.Board;
import com.sist.web.entity.Festival;

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
	@GetMapping("/board/detail")
	public String board_detail(int no, Model model) {
		Board vo=dao.findByNo(no);
		vo.setHit(vo.getHit()+1);
		model.addAttribute("vo", vo);
		model.addAttribute("main_html", "board/detail");
		
		return "main";
	}
	
	
	// 수정
	@GetMapping("/board/update")
	public String board_update(int no, Model model) {
		Board vo=dao.findByNo(no);
		model.addAttribute("vo", vo);
		
		return "board/update";
	}
	
	// 실제 수정 => redirect => detail 보여주기
	@PostMapping("/board/update_ok")
	@ResponseBody
	public String board_update_ok(Board vo) {
		String result="";
		Board en=dao.findByNo(vo.getNo());
		if(en.getPwd().equals(vo.getPwd())) {
			result="<script>"
					+"location.href=\"/board/detail?no="+vo.getNo()+"\""
					+"</script>";
			   
			dao.save(vo);
		} else {
			result="<script>"
					+"alert(\"비밀번호가 일치하지 않습니다.\");"
					+"history.back();"
					+"</script>";
		}
		return result;
	}
	
	// 삭제
	@GetMapping("/board/delete")
	public String board_delete(int no, Model model) {
		model.addAttribute("no", no);
		
		return "board/delete";
	}
	
	// 실제 삭제 => redirect => list 보여주기
	@PostMapping("/board/delete_ok")
	@ResponseBody
	public String board_delete_ok(int no, String pwd) {
		String result="";
		Board vo=dao.findByNo(no);
		if(pwd.equals(vo.getPwd())) {
			result="<script>"
					+"location.href=\"/board/list\""
					+"</script>";
			dao.delete(vo);
		} else {
			result="<script>"
					+"alert(\"비밀번호가 일치하지 않습니다.\");"
					+"history.back();"
					+"</script>";
		}
		return result;
	}
}
