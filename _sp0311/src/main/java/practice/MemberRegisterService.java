package practice;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public void regist() {
		memberDao.process();
		System.out.println("regist()");
	}
}
