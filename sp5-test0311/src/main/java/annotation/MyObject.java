package annotation;

class MyObject {
    @MyAnnotation
    public void testMethod1() {
        System.out.println("This is testMethod1");
  }

    @MyAnnotation(value = "My new Annotation")
    public void testMethod2() {
        System.out.println("This is testMethod1");
  }
}
