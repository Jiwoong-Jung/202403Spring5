package ramda;

public class Main {

	public static void main(String[] args) {
		InterA ia = new InterA() {
			
			@Override
			public void method(String s) {
				System.out.println("안녕, " + s);
				
			}
		};
		
		ia.method("홍길동");

		InterA ib = (x) -> System.out.println("안녕, " + x);
		ib.method("홍길동");
	}

}
