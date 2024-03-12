package autoEx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	@Bean
	public Tire tire() {
		return new Tire();
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
	
	@Bean
	public Car car() {
		return new Car();
	}
}
