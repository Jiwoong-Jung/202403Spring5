package chunbi;

import java.sql.*;
import java.time.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;
    

    public MemberDao(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 멤버 인원수 얻기
    public int count() {
       Integer count = jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
       return count;
    }

    public List<MemberDto> selectAll() {
    	List<MemberDto> results = jdbcTemplate.query("select * from member", new RowMapper<MemberDto>() {

			@Override
			public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto dto = new MemberDto(
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
    
    public void update(MemberDto dto) {
    	jdbcTemplate.update("update member set name = ?, pw = ? where memberno = ?", dto.getName(), dto.getPw(), dto.getMemberno());
    }
    
    public void insert(MemberDto dto) {
    	jdbcTemplate.update("insert into member(id, pw, name) values(?,?,?)", dto.getId(), dto.getPw(), dto.getName());
    }
    
    public void delete(int memberno) {
    	jdbcTemplate.update("delete from member where memberno = ?", memberno);
    }

}