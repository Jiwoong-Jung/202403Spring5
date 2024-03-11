package optional;

import java.util.Optional;

class Bbb {
	void print() {
		System.out.println("Bbb");
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
		Bbb bb = null;  // 가정: 값이 예상 안됨.
//		if (bb == null) {
//			System.out.println("bb가 null입니다.");
//		} else {
//			aa.print(bb);
//		}
		
		Optional<Bbb> bb1 = Optional.ofNullable(bb);
		System.out.println(bb1);

	}

}




