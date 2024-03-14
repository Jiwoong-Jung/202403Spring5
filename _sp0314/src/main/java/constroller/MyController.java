package constroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
