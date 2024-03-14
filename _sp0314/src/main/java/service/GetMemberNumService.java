package service;

import dao.MemberDao;

public class GetMemberNumService {
	private MemberDao memberDao;
	
	public int getNumRecords() {
		return memberDao.getNumRecords();
	}

}
