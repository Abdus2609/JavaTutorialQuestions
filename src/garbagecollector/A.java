package garbagecollector;

public class A {

  static int numCollected = 0;

  private final int id;

  public A(int id) {
    this.id = id;
  }

  @Override
  public void finalize() {
    System.out.println("Instance " + id + " has been garbage collected.");
    numCollected++;
  }
}
