package stringstack;

import java.util.ListIterator;

public class StringStackListIterator implements StringStackIterator {

  private final ListIterator<String> iterator;

  public StringStackListIterator(ListIterator<String> iterator) {
    this.iterator = iterator;
  }

  @Override
  public boolean hasNext() {
    return iterator.hasPrevious();
  }

  @Override
  public String next() {
    if (hasNext()) {
      return iterator.previous();
    }

    return null;
  }
}
