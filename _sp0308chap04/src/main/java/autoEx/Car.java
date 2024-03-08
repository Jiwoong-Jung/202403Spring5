package autoEx;

public class Car {
	private Engine engine;
	private Tire tire1;
	private Tire tire2;
	private Tire tire3;
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
