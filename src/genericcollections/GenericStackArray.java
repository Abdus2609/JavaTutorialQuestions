package genericcollections;

public class GenericStackArray<E> implements GenericStack<E> {

  private static final int STACK_LIMIT = 100;
  private final E[] stack;
  private int stackPointer;

  @SuppressWarnings("unchecked")
  public GenericStackArray() {
    stack = (E[]) new Object[STACK_LIMIT];
  }

  @Override
  public void push(E item) {
    if (stackPointer < STACK_LIMIT) {
      stack[stackPointer] = item;
      stackPointer++;
    }
  }

  @Override
  public E pop() {
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
  public GenericIterator<E> iterator() {
    return new GenericStackArrayIterator();
  }

  private class GenericStackArrayIterator implements GenericIterator<E> {

    private int current;

    private GenericStackArrayIterator() {
      current = stackPointer - 1;
    }

    @Override
    public boolean hasNext() {
      return current >= 0;
    }

    @Override
    public E next() {
      if (hasNext()) {
        E result = stack[current];
        current--;
        return result;
      }
      return null;
    }
  }
}
