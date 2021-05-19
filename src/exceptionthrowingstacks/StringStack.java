package exceptionthrowingstacks;

public interface StringStack {

  void push(String string);

  String pop() throws StringStackUnsupportedPopException;

  boolean isEmpty();
}
