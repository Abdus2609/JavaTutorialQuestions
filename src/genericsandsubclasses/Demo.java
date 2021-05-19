package genericsandsubclasses;

import java.util.HashSet;
import java.util.Set;

public class Demo {

  public static void main(String[] args) {
    Set<B> setOfB = new HashSet<B>();
    Set<? extends A> setOfA = setOfB;
  }
}
