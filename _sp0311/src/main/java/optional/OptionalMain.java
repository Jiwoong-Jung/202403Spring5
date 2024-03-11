package optional;

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
		aa.print(bb);

	}

}
