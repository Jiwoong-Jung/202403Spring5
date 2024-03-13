package anno2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// 특정 메서드의 어노테이션을 가져올 수 있습니다.
        Method method = Target.class.getMethod("sub");
        Annotation[] annotations = method.getDeclaredAnnotations();
        
        for (Annotation anno : annotations) {
            MyAnno myAnno = (MyAnno) anno;
            System.out.println(myAnno.value());
        }

	}

}
