package practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForSpring {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		ChangePasswordService cps = ctx.getBean(ChangePasswordService.class);
		cps.changePassword();
		ctx.close();
	}

}
