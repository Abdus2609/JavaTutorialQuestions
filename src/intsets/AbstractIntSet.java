package intsets;

public abstract class AbstractIntSet implements IntSet {

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");

    for (IntSetIterator iterator = iterator(); iterator.hasNext(); ) {
      sb.append(iterator.next());
      if (iterator.hasNext()) {
        sb.append(", ");
      }
    }

    sb.append("]");
    return sb.toString();
  }

  @Override
  public void addAll(IntSet other) {

    for (IntSetIterator it = other.iterator(); it.hasNext();) {
      add(it.next());
    }
  }

  @Override
  public void removeAll(IntSet other) {

    for (IntSetIterator it = other.iterator(); it.hasNext();) {
      remove(it.next());
    }
  }

  @Override
  public boolean contains(IntSet other) {

    for (IntSetIterator it = other.iterator(); it.hasNext(); ) {
      if (!contains(it.next())) {
        return false;
      }
    }

    return true;
  }
}
