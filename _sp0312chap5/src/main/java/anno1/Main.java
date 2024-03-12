package anno1;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		Method[] methodList = MyObject.class.getMethods();

        for (Method method : methodList) {
            if(method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation=
                		method.getDeclaredAnnotation(MyAnnotation.class);
                String value=annotation.value();
                System.out.println(method.getName() + ":" + value);
            }
        }

	}

}
