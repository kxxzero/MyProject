package com.sist.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.News;
import com.sist.web.manager.NewsManager;

@RestController
@CrossOrigin(origins = "*")
public class NewsRestController {
	@Autowired
	private NewsManager nm;
	
	// News 검색
	@GetMapping("/news/list_react")
	public List<News> newListData(String fd) {
		List<News> list=new ArrayList<News>();
	
		return list;
	}
}
