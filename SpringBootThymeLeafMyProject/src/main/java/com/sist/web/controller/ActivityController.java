package com.sist.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.web.dao.ActivityDAO;
import com.sist.web.entity.Activity;

@Controller
public class ActivityController {
	@Autowired
	private ActivityDAO dao;
	
	@GetMapping("/activity/list")
	public String activity_list(String page, Model model) {
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-rowSize;
		List<Activity> list=dao.activityListData(start);
		int totalpage=dao.activityRowCount();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		
		model.addAttribute("main_html", "activity/list");
		
		return "main";
	}
	
	@GetMapping("/activity/detail")
	public String activity_detail(int no, Model model) {
		Activity vo=dao.findByNo(no);
		
		// 상세 이미지 URL들을 ^로 분리하여 리스트에 저장
	    List<String> deList=Arrays.asList(vo.getDeimage().split("\\^"));
	    List<String> tagList=Arrays.asList(vo.getTag().split(" "));
		
		model.addAttribute("vo", vo);
		model.addAttribute("deList", deList);
	    model.addAttribute("tagList", tagList);
		model.addAttribute("main_html", "activity/detail");
		
		return "main";
	}
	
	@RequestMapping("/activity/find")
	public String activity_find(String page, String title, Model model) {
		if(title==null) {
			title="";
		}
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-rowSize;
		List<Activity> list=dao.activityFindData(start, title);
		int totalpage=dao.activityFindTotalPage(title);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		model.addAttribute("title", title);
		
		model.addAttribute("main_html", "activity/find");
		return "main";
	}
}
