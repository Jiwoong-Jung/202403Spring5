package com.sky.sp0320.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sky.sp0320.dao.MemberDao;

@Controller
public class MyController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/")
	public String root(Model model) {
//		System.out.println(memberDao.count());
		model.addAttribute("str", "DB에서 받은 값");
		model.addAttribute("count", memberDao.count());
		return "root";
	}

}
