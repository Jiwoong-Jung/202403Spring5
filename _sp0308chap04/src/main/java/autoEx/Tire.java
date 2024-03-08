package autoEx;

public class Tire {
	private String postion;
	
	public void roll() {
		System.out.print(postion+", ");
		System.out.println("바퀴가 돈다.");
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}
	
	
}
