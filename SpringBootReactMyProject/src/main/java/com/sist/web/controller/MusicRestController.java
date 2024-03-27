package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.MusicDAO;
import com.sist.web.entity.Music;

@RestController
@CrossOrigin(origins="*")
public class MusicRestController {
	@Autowired
	private MusicDAO dao;
	
	@GetMapping("/music/list_react")
	public List<Music> musicListData() {
		List<Music> list=dao.musicMainData();
		
		return list;
	}
}
