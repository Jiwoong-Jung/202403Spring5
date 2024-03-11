package practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForSpring {

	public static void main(String[] args) {
//		MemberRegisterService mrs = new MemberRegisterService();
//		mrs.regist();

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MemberRegisterService mrs = ctx.getBean(MemberRegisterService.class);
		mrs.regist();

		ChangePasswordService cps = ctx.getBean(ChangePasswordService.class);
		cps.changePassword();

		ctx.close();
	}

}
