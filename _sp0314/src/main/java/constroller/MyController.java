package constroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	@GetMapping("/")
	public String root() {
		return "index";
	}

	@GetMapping("/hello") // 요청
	public String abc() { // 메소드 이름 상관 없음
		return "hello"; // view의 이름
	}

	@GetMapping("/login")
	public String login() {
		return "inputForm";
	}

	@GetMapping("/result")
	public String result() {
//		System.out.println(id);
//		System.out.println(email);
		return "result";
	}

//	public String result(@RequestParam String id, @RequestParam String email) {
//		System.out.println(id);
//		System.out.println(email);
//		return "result";
//	}
//	public String result(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		System.out.println(id);
//		return "result";
//	}
}
