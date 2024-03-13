package anno2;

public class Target {
	
    @MyAnno(value = "연습입니다.")
    public void sub() {
        System.out.println("Target");
    }

}
