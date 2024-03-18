package practice;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDao {
	
    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
    
    public int count() {
        Integer count = jdbcTemplate
        		.queryForObject("select count(*) from member",
        				                        Integer.class);
        return count;
     }
    
    public String memberName(int memberno) {
    	return jdbcTemplate		
    	 .queryForObject(
    			 "select name from member where memberno = ? ",
    		     String.class);
    }

}
