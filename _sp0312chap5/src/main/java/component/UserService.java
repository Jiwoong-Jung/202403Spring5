package component;

public class UserService {
	private Calculator calculator;
	
	public void cal(double a, double b) {
		double result = calculator.add(a, b);
		System.out.println(result);
	}
}
