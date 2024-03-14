package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import constroller.MyController;
import dao.MemberDao;
import dto.MemberDto;


@Configuration
public class ControllerConfig {
	
	@Bean
	public MyController myController() {
		return new MyController();
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

}
