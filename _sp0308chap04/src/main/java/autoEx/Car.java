package autoEx;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {

	private Engine engine;
	
	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Autowired
	private Tire tire1;
	
	@Autowired
	private Tire tire2;
	
	@Autowired
	private Tire tire3;
	
	@Autowired
	private Tire tire4;

	public void run() {
		engine.engineRunning();
		tire1.setPostion("왼쪽 앞");
		tire1.roll();
		tire2.setPostion("오른쪽 앞");
		tire2.roll();
		tire3.setPostion("왼쪽 뒤");
		tire3.roll();
		tire4.setPostion("오른쪽 뒤");
		tire4.roll();

	}
}
