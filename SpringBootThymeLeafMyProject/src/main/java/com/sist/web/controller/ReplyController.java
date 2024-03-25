package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.web.dao.ReplyDAO;
import com.sist.web.entity.Reply;

import jakarta.servlet.http.HttpSession;

public class ReplyController {
	@Autowired
	private ReplyDAO dao;
	
	@PostMapping("/reply/insert")
	public String replyInsert(Reply vo, HttpSession session, RedirectAttributes ra) {
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		vo.setId(id);
		vo.setName(name);
		dao.save(vo);
		ra.addAttribute("fno", vo.getFno());
		return "redirect:/food/detail";
	}
	
	@GetMapping("/reply/delete")
	public String replyDelete(int fno, int no, RedirectAttributes ra) {
		Reply vo=dao.findByNo(no);
		dao.delete(vo);
		ra.addFlashAttribute("fno", fno);
		return "redirect:/food/detail";
	}
	
	@PostMapping("/reply/update")
	public String replyUpdate(Reply vo, RedirectAttributes ra) {
		dao.save(vo);
		ra.addAttribute("fno", vo.getFno());
		return "redirect:/food/detail";
	}
}
