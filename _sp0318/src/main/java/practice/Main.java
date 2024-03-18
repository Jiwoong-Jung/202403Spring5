package practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	private static Logger LOGGER 
    			= LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx 
		= new AnnotationConfigApplicationContext
		               (DbConfig.class, DbQueryConfig.class);

		MemberDao dbQuery = ctx.getBean(MemberDao.class);
		int count = dbQuery.count();
		LOGGER.info("인원: {}명",count);
		String name = dbQuery.memberName(2);
		LOGGER.info("고객이름: {}", name);

		Member dto = 
				new Member("Kim", "kim@korea.com", "김하나");
		dbQuery.insert(dto);
	}

}
