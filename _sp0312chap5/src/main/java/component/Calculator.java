package component;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class Calculator {

	public Double add(double x, double y) {
		return x + y;
	}
}
