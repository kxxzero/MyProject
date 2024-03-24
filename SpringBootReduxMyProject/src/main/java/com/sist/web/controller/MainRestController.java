package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.Board;
import com.sist.web.entity.Book;
import com.sist.web.service.BoardService;
import com.sist.web.service.BookService;

@RestController
@CrossOrigin(origins = "*")
public class MainRestController {
	@Autowired
    private BookService bkService;
	
	@Autowired
	private BoardService brService;
	
	@GetMapping("/book/main")
	public List<Book> bookMainData(){
		return bkService.bookMainData();
	}
	
	@GetMapping("/board/main")
	public List<Board> recipeMainList(){
		return brService.boardMainData();
	}
}
