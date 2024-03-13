package anno2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import anno1.MyAnnotation;

public class Main {

	public static void main(String[] args) throws Exception {
//		Target ta = new Target();
//		ta.sub123();
		
		String className = "anno2.Target";
		Class<?> cls = Class.forName(className);
        Target a = (Target) cls.getDeclaredConstructor().newInstance();
        a.sub123();
		
        Method[] methods = cls.getDeclaredMethods();

        for (int i=0; i<methods.length; i++) {
            if (methods[i].isAnnotationPresent(MyAnno.class)) {
                MyAnno myAnno = methods[i].getAnnotation(MyAnno.class);
                System.out.println(myAnno.value());
            }
            if(methods[i].isAnnotationPresent(MyAnnotation.class)) {
//            	System.out.println(method);
                MyAnnotation annotation=
                		methods[i].getDeclaredAnnotation(MyAnnotation.class);
                String value=annotation.value123();
                System.out.println(methods[i].getName() + ":" + value);
            }
        }
		
		
		// 특정 메서드의 어노테이션을 가져올 수 있습니다.
//        Method method = Target.class.getMethod("sub123");
//        Annotation[] annotations = method.getDeclaredAnnotations();
//        
//        for (Annotation anno : annotations) {
//            MyAnno myAnno = (MyAnno) anno;
//            System.out.println(myAnno.value());
//        }

	}

}
