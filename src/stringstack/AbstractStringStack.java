package stringstack;

public abstract class AbstractStringStack implements StringStack {

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    for (StringStackIterator it = iterator(); it.hasNext();) {
      sb.append(it.next());
      if (it.hasNext()) {
        sb.append(", ");
      }
    }

    sb.append("]");
    return sb.toString();
  }

}
