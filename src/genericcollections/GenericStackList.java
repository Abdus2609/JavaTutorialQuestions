package genericcollections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GenericStackList<E> implements GenericStack<E> {

  private final List<E> stack;

  public GenericStackList() {
    stack = new ArrayList<>();
  }

  @Override
  public void push(E item) {
    stack.add(item);
  }

  @Override
  public E pop() {
    if (stack.size() > 0) {
      return stack.remove(stack.size() - 1);
    }

    return null;
  }

  @Override
  public boolean isEmpty() {
    return stack.isEmpty();
  }

  @Override
  public GenericIterator<E> iterator() {
    return new GenericStackListIterator();
  }

  private class GenericStackListIterator implements GenericIterator<E> {

    private final ListIterator<E> iterator;

    private GenericStackListIterator() {
      iterator = stack.listIterator(stack.size());
    }

    @Override
    public boolean hasNext() {
      return iterator.hasPrevious();
    }

    @Override
    public E next() {
      if (hasNext()) {
        return iterator.previous();
      }
      return null;
    }
  }
}
