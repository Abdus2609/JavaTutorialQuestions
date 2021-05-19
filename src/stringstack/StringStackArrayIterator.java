package stringstack;

public class StringStackArrayIterator implements StringStackIterator {

  private final String[] elements;
  private int current;

  public StringStackArrayIterator(String[] elements, int stackPointer) {
    this.elements = elements;
    this.current = stackPointer - 1;
  }

  @Override
  public boolean hasNext() {
    return current >= 0;
  }

  @Override
  public String next() {
    if (hasNext()) {
      String result = elements[current];
      current--;
      return result;
    }

    return null;
  }
}
