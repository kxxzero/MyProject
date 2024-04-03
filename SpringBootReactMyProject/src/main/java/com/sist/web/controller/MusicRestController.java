package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.MusicDAO;
import com.sist.web.entity.Music;

@RestController
@CrossOrigin(origins = "*")
public class MusicRestController {
	@Autowired
	private MusicDAO dao;

	@GetMapping("/music/list_react")
	public List<Music> musicListData() {
		List<Music> list = dao.musicMainData();

		return list;
	}

	@GetMapping("/music/find_react")
	public Map musicFindData(int page, String title) {
		int rowSize=20;
		int start=(rowSize*page)-rowSize;
		List<Music> list=dao.musicFindData(start, title);
		Map map=new HashMap();
		int count=(int)dao.count();
		int totalpage=dao.musicFindTotalPage(title);
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
		map.put("count", count);
		map.put("list", list);

		return map;
	}

	@GetMapping("/music/find_total_react")
	public String musicFindTotalPage(String title) {
		int total=dao.musicFindTotalPage(title);
		return String.valueOf(total);
	}
}
