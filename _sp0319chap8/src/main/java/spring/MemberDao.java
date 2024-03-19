package spring;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	public Member selectByEmail(String email) {
		return null;
	}

	public void insert(Member member) {

	}

	public void update(Member member) {

	}

	public Collection<Member> selectAll() {
		return null;
	}
}
