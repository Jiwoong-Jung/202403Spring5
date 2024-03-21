package com.sky.sp0320.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.sp0320.dao.MemberDao;
import com.sky.sp0320.dto.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public void insert(Member member) {
		memberDao.insert(member);
	}
	
	public void update(Member member) {
		memberDao.update(member);
	}
	
	public void delete(int id) {
		memberDao.delete(id);
	}
	
	public List<Member> listAll() {
		return memberDao.selectAll();
	}
	
	public Member findById(int id) {
		return memberDao.selectById(id);
	}

}
