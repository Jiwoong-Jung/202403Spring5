package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.Client;
import spring.Client2;

@Configuration
public class AppCtx {

	@Bean
	public Client client() throws Exception {
		Client client = new Client();
		client.setHost("host");
		client.afterPropertiesSet();
		return client;
	}
	
	@Bean(initMethod = "connect", destroyMethod = "close")
	public Client2 client2() {
		Client2 client = new Client2();
		client.setHost("host");
		return client;
	}
}
