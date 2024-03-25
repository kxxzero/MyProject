package com.sist.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.dao.ActivityDAO;
import com.sist.web.dao.BoardDAO;
import com.sist.web.dao.FestivalDAO;
import com.sist.web.dao.TourDAO;
import com.sist.web.entity.Activity;
import com.sist.web.entity.Board;
import com.sist.web.entity.Festival;
import com.sist.web.entity.Tour;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	@Autowired
	private TourDAO tDao;
	
	@Autowired
	private FestivalDAO fDao;
	
	@Autowired
	private ActivityDAO aDao;
	
	@Autowired
	private BoardDAO bDao;
		
	@GetMapping("/")
	public String main_page(Model model, HttpServletRequest request) {
		List<Tour> tList=tDao.mainTourData();
		List<Festival> fList=fDao.mainFestivalData();
		List<Activity> aList=aDao.mainActivityData();
		List<Board> bList=bDao.mainBoardData();
		
		Cookie[] cookies=request.getCookies();
		List<Tour> cList=new ArrayList<Tour>();
		int k=0;
		if(cookies!=null) {
			for(int i=cookies.length-1; i>=0; i--) {
				if(cookies[i].getName().startsWith("tour")) {
					if(k>8) {
						break;
					}
					String no=cookies[i].getValue();
					Tour t=tDao.findByNo(Integer.parseInt(no));
					cList.add(t);
					k++;
				}
			}
		}
		
		model.addAttribute("tList", tList);
		model.addAttribute("fList", fList);
		model.addAttribute("aList", aList);
		model.addAttribute("bList", bList);
		
		model.addAttribute("cList", cList);
		
		model.addAttribute("main_html", "main/home"); // 확장자를 붙이면 안 됨
		return "main";
	}
}