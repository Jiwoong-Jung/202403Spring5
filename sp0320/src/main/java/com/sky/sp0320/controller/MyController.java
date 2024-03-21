package com.sky.sp0320.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sky.sp0320.dao.MemberDao;

@Controller
public class MyController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/")
	public String root() {
		System.out.println(memberDao.count());
		return "root";
	}

}
