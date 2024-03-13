package anno2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
// 적용대상은 method입니다.
@Retention(RetentionPolicy.RUNTIME)
// 유지정책은 runtime입니다. 컴파일 이후에도 JVM이 참조합니다.
public @interface MyAnno {
	// String 타입으로 사용 가능합니다.
	  public String value();
}
