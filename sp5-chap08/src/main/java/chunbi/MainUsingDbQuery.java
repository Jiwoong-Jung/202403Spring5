package chunbi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainUsingDbQuery {

  private static Logger LOGGER = LoggerFactory.getLogger(MainUsingDbQuery.class);
//  private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
  
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class,
				DbQueryConfig.class);

		MemberDao dbQuery = ctx.getBean(MemberDao.class);
		int count = dbQuery.count();
		LOGGER.info("인원 {} 명",count);
		
		MemberDto dto1 = new MemberDto(2, "Kim", "kim@korea.com", "김하나");
		dbQuery.update(dto1);
		
		dbQuery.delete(3);
		
		MemberDto dto2 = new MemberDto("Kim2", "kim2@korea.com", "김하나2");
		dbQuery.insert(dto2);
		
		List<MemberDto> list = dbQuery.selectAll();
		for (MemberDto dto : list) {
			LOGGER.info("일련번호={}, id={}, email={}, name={}", dto.getMemberno(), dto.getId(), dto.getPw(), dto.getName());
		}
		
		
		ctx.close();
	}
}
