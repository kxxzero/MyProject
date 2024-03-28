package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.ExhibitionDAO;
import com.sist.web.entity.Exhibition;

@RestController
@CrossOrigin(origins = "*")
public class ExhibitionRestController {
	@Autowired
	private ExhibitionDAO dao;

	@GetMapping("/exhibition/list_react")
	public List<Exhibition> exhibitionListData() {
		List<Exhibition> list = dao.exhibitionMainData();

		return list;
	}

	@GetMapping("/exhibition/find_react")
	public Map exhibitionFindData(int page, String ename) {
		int rowSize=20;
		int start=(rowSize*page)-rowSize;
		List<Exhibition> list=dao.exhibitionFindData(start, ename);
		Map map=new HashMap();
		int totalpage=dao.exhibitionFindTotalPage(ename);
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if (endPage>totalpage) {
			endPage=totalpage;
		}
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("list", list);

		return map;
	}

	@GetMapping("exhibition/find_total_react")
	public String exhibitionFindTotalPage(String ename) {
		int total=dao.exhibitionFindTotalPage(ename);
		return String.valueOf(total);
	}
}
