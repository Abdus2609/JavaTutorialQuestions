package exceptionthrowingstacks;

public class StringStackUnsupportedPopException extends Exception {

  @Override
  public String toString() {
    return "Attempt to pop element from empty stack failed; stack was not modified";
  }
}
