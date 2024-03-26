package com.sist.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.web.dao.TourDAO;
import com.sist.web.entity.Tour;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TourController {
	@Autowired
	private TourDAO dao;
	
	@GetMapping("/tour/list")
	public String tour_list(String page, Model model) {
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-rowSize;
		List<Tour> list=dao.tourListData(start);
		int totalpage=dao.tourRowCount();
		
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
		
		model.addAttribute("main_html", "tour/list");
		
		return "main";
	}
	
	@GetMapping("/tour/before_detail")
	public String tour_before(int no, RedirectAttributes ra, HttpServletResponse response) {
		// 쿠키에 저장 
		Cookie cookie=new Cookie("tour"+no, String.valueOf(no)); // cookie는 저장 시 문자열만 저장 가능 
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie); // 클라이언트 브라우저로 전송
		ra.addAttribute("no", no);
   
		return "redirect:../tour/detail";
	}
	
	@GetMapping("/tour/detail")
	public String tour_detail(int no, Model model) {
		Tour vo=dao.findByNo(no);
		
	    List<String> deList=Arrays.asList(vo.getDeimage().split("\\^")); // 상세 이미지 URL들을 ^로 분리하여 리스트에 저장
	    List<String> tagList=Arrays.asList(vo.getTag().split(" "));
		
//		String cookieName="tour"+no;
//	    String cookieValue=null;
//	    Cookie[] cookies=request.getCookies();
//	    if (cookies!=null) {
//	        for (Cookie cookie:cookies) {
//	            if (cookie.getName().equals(cookieName)) {
//	                cookieValue=cookie.getValue();
//	                break;
//	            }
//	        }
//	    }
//	    // 쿠키 값 사용
//	    if (cookieValue != null) {
//	        // 쿠키 값이 존재할 때 처리하는 내용 작성
//	    }
		
	    model.addAttribute("vo", vo);
	    model.addAttribute("deList", deList);
	    model.addAttribute("tagList", tagList);
		model.addAttribute("main_html", "tour/detail");
	    
		return "main";
	}
	
	@RequestMapping("/tour/find")
	public String tour_find(String page, String title, Model model) {
		if(title==null) {
			title="";
		}
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-rowSize;
		List<Tour> list=dao.tourFindData(start, title);
		int totalpage=dao.tourFindTotalPage(title);
		
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
		
		model.addAttribute("main_html", "tour/find");
		return "main";
	}
}
