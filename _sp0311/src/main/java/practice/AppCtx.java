package practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

}
