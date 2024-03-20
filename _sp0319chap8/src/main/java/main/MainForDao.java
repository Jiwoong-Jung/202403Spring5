package main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import dbquery.DbQuery;
import spring.ChangePasswordService;
import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;
import spring.WrongIdPasswordException;

public class MainForDao {

	private static Logger LOGGER = LoggerFactory.getLogger(MainForDao.class);
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx.class);

		MemberDao dao = ctx.getBean(MemberDao.class);
		
		List<Member> list = dao.selectAll();
		LOGGER.info("---Member 테이블 내용---");
		for (Member member : list) {
			LOGGER.info(member.toString());
		}
		LOGGER.info("---Member 테이블 내용 끝---");
		Member member = dao.selectByEmail3("madvirus@madvirus.net");
		if (member != null) {
//			LOGGER.info("{}", member);
			LOGGER.info("아이디:{}, 이메일:{}, 패스워드:{}, 이름:{}, 등록일:{}",
					                      member.getId(), 
					                      member.getEmail(),
					                      member.getPassword(),
					                      member.getName(),
					                      member.getRegisterDateTime());
		} else {
			LOGGER.info("이메일로 검색안됨");
		}


		ctx.close();

	}
}
