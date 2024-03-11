package practice;

public class ChangePasswordService {
	private MemberDao memberDao;
	
	public void changePassword() {
		memberDao.process();
		System.out.println("changePassword()");
	}

}
