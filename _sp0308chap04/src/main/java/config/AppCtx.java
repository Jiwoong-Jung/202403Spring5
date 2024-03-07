package config;

import org.springframework.context.annotation.Bean;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;

public class AppCtx {

	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService();
	}
	
	public ChangePasswordService changePwdSvc() {
		return new ChangePasswordService();
	}
	
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter();
	}
	
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
