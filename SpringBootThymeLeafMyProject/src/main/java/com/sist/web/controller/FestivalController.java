package com.sist.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.web.dao.FestivalDAO;
import com.sist.web.entity.Festival;

@Controller
public class FestivalController {
	@Autowired
	private FestivalDAO dao;
	
	@GetMapping("/festival/list")
	public String festival_list(String page, Model model) {
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-rowSize;
		List<Festival> list=dao.festivalListData(start);
		int totalpage=dao.festivalRowCount();
		
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
		
		model.addAttribute("main_html", "festival/list");
		
		return "main";
	}
	
	@GetMapping("/festival/detail")
	public String festival_detail(int no, Model model) {
		Festival vo=dao.findByNo(no);
		
		// 상세 이미지 URL들을 ^로 분리하여 리스트에 저장
	    List<String> deList=Arrays.asList(vo.getDeimage().split("\\^"));
	    List<String> tagList=Arrays.asList(vo.getTag().split(" "));
		
		model.addAttribute("vo", vo);
		model.addAttribute("deList", deList);
	    model.addAttribute("tagList", tagList);
		model.addAttribute("main_html", "festival/detail");
		
		return "main";
	}
	
	@RequestMapping("/festival/find")
	public String festival_find(String page, String title, Model model) {
		if(title==null) {
			title="";
		}
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-rowSize;
		List<Festival> list=dao.festivalFindData(start, title);
		int totalpage=dao.festivalFindTotalPage(title);
		
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
		
		model.addAttribute("main_html", "festival/find");
		return "main";
	}
}
