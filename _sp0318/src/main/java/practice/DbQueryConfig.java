package practice;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbQueryConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource);
	}
}
