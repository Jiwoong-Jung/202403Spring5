package anno2;

import anno1.MyAnnotation;

public class Target {
	
    @MyAnno(value = "연습3")
    @MyAnnotation (value123 = "테스트123")
    public void sub123() {
        System.out.println("Target");
    }

}
