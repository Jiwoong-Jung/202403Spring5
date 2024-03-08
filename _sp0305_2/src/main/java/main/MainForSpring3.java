package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import config.AppConf1;
import config.AppConf2;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.VersionPrinter;
import spring.WrongIdPasswordException;

public class MainForSpring3 {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException {
		ctx 
		= new AnnotationConfigApplicationContext
		                    (AppConf1.class, AppConf2.class);
		//@Configuration 의 해당 객체도 Bean 취급
		AppConf1 appConf1 = ctx.getBean(AppConf1.class);
		System.out.println(appConf1 != null);
		AppConf2 appConf2 = ctx.getBean(AppConf2.class);
		System.out.println(appConf2 != null);
	}
		
}