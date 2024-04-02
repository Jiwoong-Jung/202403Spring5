package compo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//UserSerrvice.java
//@Service
@Component
public class UserService {
	// 선언
//	private final Calculator calculator;
	@Autowired
	private Calculator calculator;

	// Bean 받기
//	@Autowired
//	public UserService(Calculator calculator) {
//		this.calculator = calculator;
//	}

	// 계산기 사용 메서드
	public void cal(double a, double b) {
		double result = calculator.add(a, b);
		System.out.println(result);
	}
}
