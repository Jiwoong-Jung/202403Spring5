package anno2;

import anno1.MyAnnotation;

public class Target {
	
    @MyAnno(value = "연습3")
    public void sub123() {
        System.out.println("Target");
    }

}
