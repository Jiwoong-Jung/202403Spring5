package practice;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
	@Autowired
	private MemberDao memberDao;
	
	public void changePassword() {
		memberDao.process();
		System.out.println("changePassword()");
	}

}
