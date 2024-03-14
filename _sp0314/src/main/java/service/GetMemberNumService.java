package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;

@Service
public class GetMemberNumService {
	
	@Autowired
	private MemberDao memberDao;
	
	public int getNumRecords() {
		return memberDao.getNumRecords();
	}

}
