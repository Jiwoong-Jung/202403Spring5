package anno3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MainClass {
    public static void main(String[] args) throws Exception {


        // 특정 메서드의 어노테이션을 가져올 수 있습니다.
        Method method = Target.class.getMethod("sub");
        Annotation[] annotations = method.getDeclaredAnnotations();

        for (Annotation anno : annotations) {
            MyAnno myAnno = (MyAnno) anno;
            System.out.println(myAnno.value());
        }

        // 동적 클래스 생성으로 객체를 얻어온 다음
        // 여러 메서드들의 어노테이션 value()를 얻어옵니다.
        String className = "anno3.Target";
        Class<?> cls = Class.forName(className);
        Target a = (Target) cls.getDeclaredConstructor().newInstance();
        a.sub();

        Method[] methods = cls.getDeclaredMethods();

        for (int i=0; i<methods.length; i++) {
            if (methods[i].isAnnotationPresent(MyAnno.class)) {
                MyAnno myAnno = methods[i].getAnnotation(MyAnno.class);
                System.out.println(myAnno.value());
            }
        }
    }
}
