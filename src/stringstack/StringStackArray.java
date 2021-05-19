package stringstack;

public class StringStackArray extends AbstractStringStack {

  private static final int STACK_LIMIT = 100;

  private final String[] stack;
  private int stackPointer;

  public StringStackArray() {
    this.stack = new String[STACK_LIMIT];
    this.stackPointer = 0;
  }

  @Override
  public void push(String s) {
    if (stackPointer < STACK_LIMIT) {
      stack[stackPointer] = s;
      stackPointer++;
    }
  }

  @Override
  public String pop() {
    if (stackPointer > 0) {
      stackPointer--;
      return stack[stackPointer];
    }

    return null;
  }

  @Override
  public boolean isEmpty() {
    return stackPointer == 0;
  }

  @Override
  public StringStackIterator iterator() {
    return new StringStackArrayIterator(stack, stackPointer);
  }
}
