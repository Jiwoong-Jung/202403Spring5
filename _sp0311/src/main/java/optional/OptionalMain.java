package optional;

import java.util.Optional;

class Bbb {
	int x;
	public Bbb(int x) {
		this.x = x;
	}
	void print() {
		System.out.println("Bbb:"+x);
	}
}

class Aaa {
	void print(Bbb bb) {
		bb.print();
	}
}
public class OptionalMain {

	public static void main(String[] args) {
		Aaa aa = new Aaa();
//		Bbb bb = new Bbb(100);  // 가정: 값이 예상 안됨.
		Bbb bb = null;
//		if (bb == null) {
//			System.out.println("bb가 null입니다.");
//		} else {
//			aa.print(bb);
//		}
		
		Optional<Bbb> bb1 = Optional.ofNullable(bb);
		System.out.println(bb1);
		aa.print(bb1.orElseGet(()->new Bbb(0)));

	}

}




