package practice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
    			 "select name from member where memberno = ?",
    			 String.class, memberno);
    }
    
    public void insert(Member member) {
    	jdbcTemplate.update(
    	   "insert into member(id, pw, name) values(?,?,?)",
    	   member.getId(), member.getPw(), member.getName());
    }
    
    public void update(Member member) {
    	jdbcTemplate.update(
    	   "update member set pw = ?, name = ? where memberno = ?",
    	   member.getPw(), member.getName(), member.getMemberno());
    }
    
    public void delete(int memberno) {
    	jdbcTemplate.update("delete from member where memberno = ?",
    			            memberno);
    }
    
    public List<Member> selectAll() {
    	List<Member> results = jdbcTemplate.query("select * from member",
    			new RowMapper<Member>() {

					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member dto = new Member(
								rs.getInt("memberno"),
								rs.getString("id"),
								rs.getString("pw"),
								rs.getString("name")
								);
						return dto;
					}
    		
    	});
    	return results;
    }
    public List<Member> selectAll2() {
    	List<Member> results = jdbcTemplate.query("select * from member",
    			(rs, n)->{
			          Member dto = new Member(
					         rs.getInt("memberno"),
					         rs.getString("id"),
					         rs.getString("pw"),
					         rs.getString("name")
					  );
			          return dto;
		        });
    	return results;
    }
}

