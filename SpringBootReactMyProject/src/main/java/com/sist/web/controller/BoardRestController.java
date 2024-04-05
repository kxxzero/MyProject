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

@RestController
@CrossOrigin(origins = "*")
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("/board/list_react")
	public Map BoardList(int page) {
		int rowSize=9;
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
	
	@GetMapping("/board/detail_react")
	public Board BoardDetail(int no) {
		Board vo=dao.findByNo(no);
		vo.setHit(vo.getHit()+1);
		dao.save(vo);
		vo=dao.findByNo(no);	
		
		return vo;
	}
	
	@GetMapping("/board/insert_react")
	public String boardInsert(Board vo) {
		String result="";
		try {
			result="yes";
			dao.save(vo);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			result="no";
		}
		return result;
	}
	
	@GetMapping("/board/update_react")
	public Board boardUpdate(int no) {
		Board vo=dao.findByNo(no);
		return vo;
	}
	
	@GetMapping("/board/update_ok_react")
	public String boardUpdateOk(Board vo) {
		Board updateVO=dao.findByNo(vo.getNo());
		String result="";
		if(vo.getPwd().equals(updateVO.getPwd())) {
			result="yes";
			vo.setHit(updateVO.getHit());
			dao.save(vo);
		} else {
			result="no";
		}		
		return result;
	}
	
	@GetMapping("/board/delete_react")
	public String boardDelete(int no, String pwd) {
		String result="";
		Board vo=dao.findByNo(no);
		if(vo.getPwd().equals(pwd)) {
			result="yes";
			dao.delete(vo);
		} else {
			result="no";
		}
		return result;
	}
}
