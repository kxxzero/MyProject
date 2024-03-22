package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.Board;
import com.sist.web.service.BoardService;

@RestController
@CrossOrigin(origins = "*")
public class BoardRestController {
	@Autowired
	private BoardService bService;
	
	@GetMapping("/board/list_react")
	public Map boardList(int page) {
		Map map=new HashMap();
		int rowSize=10;
		int start=(rowSize*page)-rowSize;
		List<Board> list=bService.boardListData(start);
		int count=(int)bService.count();
		int totalpage=(int)(Math.ceil(count/10.0));
		map.put("board_list", list);
		map.put("totalpage", totalpage);
		
		return map;
	}
	
	@GetMapping("/board/total_react")
	public String boardTotal() {
		int count=(int)bService.count();
		int totalpage=(int)(Math.ceil(count/10.0));
		
		return String.valueOf(totalpage);
	}
	
	@GetMapping("board/detail_react")
	public Board boardDetail(int no) {
		Board vo=bService.findByNo(no);
		
		return vo;
	}
	
	// 작성
	@PostMapping("/board/insert_react")
	public String boardInsert(Board vo) {
		String result="";
		try {
			bService.save(vo);
			result="yes";  
		} catch(Exception ex) {
			result="no";
		}
	  
	  return result;
	}

	// 수정
	@GetMapping("/board/update_react")
	public Board boardUpdate(int no) {
		Board vo=bService.findByNo(no);
		return vo;
	}
	@PostMapping("/board/update_ok_react")
	public String boardUpdateOk(Board vo) {
		Board dbVO=bService.findByNo(vo.getNo());
		String result="";
		if(vo.getPwd().equals(dbVO.getPwd())) {
			result="yes";
			vo.setHit(dbVO.getHit());
			bService.save(vo);
		} else {
			result="no";
		}
		return result;  
	}
	
	// 삭제
	@PostMapping("/board/delete_react")
	public String boardDelete(int no,String pwd) {
		String result="";
		Board vo=bService.findByNo(no);
		if(vo.getPwd().equals(pwd)) {
			result="yes";
			bService.delete(vo);
		} else {
			result="no";
		}
		return result;
	}
	
}
