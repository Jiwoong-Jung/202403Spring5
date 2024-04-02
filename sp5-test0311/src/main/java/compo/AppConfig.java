package compo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//AppConfig.java
@Configuration
@ComponentScan
public class AppConfig {
	@Bean
	public Calculator calculator() {
		return new Calculator();
	}
}
