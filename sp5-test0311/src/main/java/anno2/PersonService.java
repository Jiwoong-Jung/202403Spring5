package anno2;

import java.lang.annotation.Annotation;

public class PersonService {

	public static void main(String[] args) {
		PersonService p = new PersonService();
		p.printPerson(new Person("kim", 20));
	}
	
	public void printPerson(Person p) {
		Annotation[] annotations = Person.class.getDeclaredAnnotations();
		for(Annotation annotation : annotations) {
			if (annotation instanceof PersonInfo) {
				PersonInfo personInfo = (PersonInfo) annotation;
				System.out.println(p.getName() + "(" + p.getAge() + ") 가 말합니다 : " + personInfo.mention());
			}
		}
	}

}
