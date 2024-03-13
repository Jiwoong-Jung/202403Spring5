package spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberRegSvc")
public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;

//	public MemberRegisterService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}

	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(), 
				LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
