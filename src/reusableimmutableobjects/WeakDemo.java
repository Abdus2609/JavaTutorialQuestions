package reusableimmutableobjects;

public class WeakDemo {

  public static void main(String[] args) throws InterruptedException {

    for (int i = 0; i < 2000000; i++) {
      WeakPoint.makePoint(0, 0, i);
    }

    System.out.println("Size of pool is " + WeakPoint.poolSize());
  }
}
