package anno1;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		Method[] methodList = MyObject.class.getDeclaredMethods();

        for (Method method : methodList) {
        	
            if(method.isAnnotationPresent(MyAnnotation.class)) {
//            	System.out.println(method);
                MyAnnotation annotation=
                		method.getDeclaredAnnotation(MyAnnotation.class);
                String value=annotation.value123();
                System.out.println(method.getName() + ":" + value);
            }
        }

	}

}
