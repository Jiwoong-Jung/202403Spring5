package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/")
	public String hello(Model model) {
		model.addAttribute("str", "한글 나오나");
		return "hello";
	}
}
