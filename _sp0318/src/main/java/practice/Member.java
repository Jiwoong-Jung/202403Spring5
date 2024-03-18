package practice;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
	private int memberno;
	private String id;
	private String pw;   // email
	private String name;
	
}
