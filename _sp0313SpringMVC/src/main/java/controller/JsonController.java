package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class JsonController {

	@GetMapping("/getTodos")
	public String getTodos() {
		List<String> todos = Arrays.asList("First task", "Second task");
		return new Gson().toJson(todos);
	}
	
	@PostMapping("/addTodo")
	public String addTodo() {
		return "";
	}
	
	@PostMapping("/removeTodo")
	public String removeTodo() {
		return "";
	}
	
}
