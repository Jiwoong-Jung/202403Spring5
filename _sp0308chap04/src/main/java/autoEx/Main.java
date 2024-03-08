package autoEx;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext
				                          (AppContext.class);
		Car c = ctx.getBean("car", Car.class);
		c.run();
	
		ctx.close();

	}

}
