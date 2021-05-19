package apparentandactualtypes;

public class Test {

  public static void main(String[] args) {

    B b = new B();

    C c = new C();
    c.accept(b);

    D d = new D();
    d.accept(b);
  }
}
