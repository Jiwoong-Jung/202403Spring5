package practice;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	@Autowired
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}



	public void regist() {
		memberDao.process();
//		if (memberDao == null) {
//			System.out.println("memberDao가 null입니다.");
//		}
		System.out.println("regist()");
	}
}
