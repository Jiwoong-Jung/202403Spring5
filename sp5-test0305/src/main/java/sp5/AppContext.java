package sp5;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

//	@Bean
//	public Greeter greeter() {
//		Greeter g = new Greeter();
//		g.setFormat("%s, 안녕하세요!");
//		return g;
//	}
	
	@Bean
//	@Qualifier("tire1")
	Tire tire() {
		Tire tire = new Tire();
		return tire;
	}
	
	@Bean
	Engine engine() {
		return new Engine();
	}
	
	@Bean
	Car car() {
		return new Car();
	}
	

}
