package ramda;

public class Main {

	public static void main(String[] args) {
		AnyInterf ai = new AnyInterf() {
			
			@Override
			public void method() {
				System.out.println("method");
				
			}
		};
		ai.method();

		AnyInterf ai1 = ()-> {
				System.out.println("method");
		};
		ai1.method();
	}

}
