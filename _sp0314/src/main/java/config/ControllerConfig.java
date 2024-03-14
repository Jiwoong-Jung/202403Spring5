package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import constroller.MyController;


@Configuration
public class ControllerConfig {
	
	@Bean
	public MyController myController() {
		return new MyController();
	}

}
