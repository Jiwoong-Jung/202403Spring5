package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.board.BoardService;

@Configuration
public class AppContext {
	
	@Bean
	public BoardService boardService() {
		return new BoardService();
	}
	

	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요!");
		return g;
	}

}
