package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.Book;
import com.sist.web.service.BookService;

@RestController
@CrossOrigin(origins="*")
public class BookRestController {
	@Autowired
	private BookService bkService;
	
	@GetMapping("/book/find_react")
	public Map bookFind(int page, String title) {
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		List<Book> list=bkService.bookFindList(start, title);
		int totalpage=bkService.bookFindTotalPage(title);
		Map map=new HashMap();
		map.put("book_find", list);
		map.put("totalpage", totalpage);
		
		return map;
	}
	
	@GetMapping("/book/detail_react")
	public Book bookDetail(int no) {
		Book book=bkService.findByNo(no);
		   
		return book;
	}
	
}
