package _sp0311;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import practice.AppCtx;
import practice.MemberDao;
import practice.MemberRegisterService;

public class RegisterTest {

	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
	MemberRegisterService mrs = ctx.getBean(MemberRegisterService.class);
	@Test
	public void regTest() {
		System.out.println("test");

		mrs.regist();

		ctx.close();

	}
}
