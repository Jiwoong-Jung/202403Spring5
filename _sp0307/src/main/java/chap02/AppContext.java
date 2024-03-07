package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.board.BoardDao;
import com.board.BoardService;

@Configuration
public class AppContext {
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDao();
	}
	
	@Bean
	public BoardService boardService() {
		return new BoardService(boardDao());
	}
	

	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요!");
		return g;
	}

}
