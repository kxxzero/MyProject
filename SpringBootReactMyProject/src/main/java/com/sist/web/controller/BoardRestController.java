package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.BoardDAO;
import com.sist.web.entity.Board;
import com.sist.web.entity.Book;

@RestController
@CrossOrigin(origins = "*")
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("/board/list_react")
	public Map BoardList(int page) {
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		
		List<Board> list=dao.boardListData(start);
		
		Map map=new HashMap();
		int totalpage=dao.boardListTotalPage();
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("list", list);
		
		return map;
	}
}
