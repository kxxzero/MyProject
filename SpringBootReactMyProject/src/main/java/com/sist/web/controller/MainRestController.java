package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.ExhibitionDAO;
import com.sist.web.dao.MovieDAO;
import com.sist.web.dao.MusicDAO;
import com.sist.web.entity.Exhibition;
import com.sist.web.entity.Movie;
import com.sist.web.entity.Music;

@RestController
@CrossOrigin(origins="*")
public class MainRestController {
	@Autowired
	public MusicDAO muDao;
	
	@Autowired
	public MovieDAO moDao;
	
	@Autowired
	public ExhibitionDAO exDao;
	
	@GetMapping("/main")
	public Map mainData(){
		Map map=new HashMap();
		List<Music> muList=muDao.musicMainData();
		List<Movie> moList=moDao.movieMainData();
		List<Exhibition> exList=exDao.exhibitionMainData();
		
		map.put("muList", muList);
		map.put("moList", moList);
		map.put("exList", exList);
		
		return map;
	}
}
