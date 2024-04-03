package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.MovieDAO;
import com.sist.web.entity.Movie;

@RestController
@CrossOrigin(origins = "*")
public class MovieRestController {
	@Autowired
	private MovieDAO dao;

	@GetMapping("/movie/list_react")
	public List<Movie> movieListData() {
		List<Movie> list = dao.movieMainData();

		return list;
	}

	@GetMapping("/movie/find_react")
	public Map movieFindData(int page, String subject) {
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		List<Movie> list=dao.movieFindData(start, subject);
		Map map=new HashMap();
		int count=(int)dao.count();
		int totalpage=dao.movieFindTotalPage(subject);
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

	@GetMapping("/movie/find_total_react")
	public String movieFindTotalPage(String subject) {
		int total=dao.movieFindTotalPage(subject);
		return String.valueOf(total);
	}
	
	@GetMapping("/movie/detail_react")
	public Map movieDetail(int no) {
		Movie vo=dao.findByNo(no);
		
		Map map=new HashMap();
		List<Movie> list=dao.movieRandData();
		
		map.put("list", list);
		map.put("vo", vo);
		return map;
	}
}
