package defaultmethods;

public class A implements I {

  @Override
  public int foo() {
    return 0;
  }

  @Override
  public int foo(int x) {
    return 0;
  }

  @Override
  public int bar(int x) {
    return 0;
  }

  public int foobar() {
    return 42;
  }

  public void foobarOriginal(int x) {
    System.out.println(x);
  }
}
