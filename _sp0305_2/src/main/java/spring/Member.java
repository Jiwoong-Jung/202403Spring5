package spring;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;

	public Member(String email, String password, 
			String name, LocalDateTime regDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = regDateTime;
	}



	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

}
