package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.MemberDAO;
import com.sist.web.entity.Member;

import jakarta.servlet.http.HttpSession;

@RestController
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@PostMapping("/member/login")
	public String member_login(String id, String pwd, HttpSession session) {
		String result="";
		int count=dao.memberIdCount(id);
		if(count==0) {
			result="NOID";
		} else {
			Member vo=dao.memberInfoData(id);
			if(pwd.equals(vo.getPwd())) {
				result="OK";
				session.setAttribute("id", vo.getId());
				session.setAttribute("name", vo.getName());
			} else {
				result="NOPWD";
			}
		}
		return result;	
	}
	
	
	@GetMapping("/member/logout")
	public String member_logout(HttpSession session) {
		String result="";
		try {
			result="yes";
			session.invalidate();
		} catch(Exception ex) {
			result="no";
		}
		return result;
	}
}
