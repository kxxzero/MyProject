package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.Board;
import com.sist.web.service.BoardService;

@RestController
@CrossOrigin(origins = "*")
public class BoardController {
	@Autowired
	private BoardService bService;
	
	@GetMapping("/board/list_react")
	public Map board_list(int page) {
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
}
