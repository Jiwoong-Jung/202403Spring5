package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.ChangePasswordService;
import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;
import spring.WrongIdPasswordException;

public class MainForCPS {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx.class);

        MemberDao dao = ctx.getBean(MemberDao.class);
        Member member = dao.selectByEmail("madvirus@madvirus.net");
        
        System.out.println(member);

		ctx.close();

	}
}
