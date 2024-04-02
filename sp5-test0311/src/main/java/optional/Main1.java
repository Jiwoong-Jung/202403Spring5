package optional;

import java.util.Optional;

class Bbb {
	void print() {
		System.out.println("Bbb");
	}
}
class Aaa {
	
	void print(Bbb bb1) {
		bb1.print();
	}
}
public class Main1 {

	public static void main(String[] args) {
		Aaa aa = new Aaa();
		Bbb bb = null;
//		aa.print(bb);
		
		Optional<Bbb> bb1 = Optional.ofNullable(bb);
		System.out.println(bb1);
		aa.print(bb1.orElseGet(()->new Bbb()));

	}

}
