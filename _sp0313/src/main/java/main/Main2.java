package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.Client2;

public class Main2 {
	public static void main(String[] ar) {
		AnnotationConfigApplicationContext ctx 
		      = new AnnotationConfigApplicationContext(AppCtx.class);
		Client2 client = ctx.getBean(Client2.class);
		client.send();
		ctx.close();
		
	}

}
