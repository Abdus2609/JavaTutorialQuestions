package genericcollections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GenericSpeedEfficientSet<E> implements GenericSet<E> {

  private final Set<E> items;

  public GenericSpeedEfficientSet() {
    this.items = new HashSet<>();
  }

  @Override
  public void add(E item) {
    items.add(item);
  }

  @Override
  public boolean remove(E item) {
    return items.remove(item);
  }

  @Override
  public boolean isEmpty() {
    return items.isEmpty();
  }

  @Override
  public boolean contains(E item) {
    return items.contains(item);
  }

  @Override
  public GenericIterator<E> iterator() {
    return new SpeedEfficientGenericSetIterator();
  }

  private class SpeedEfficientGenericSetIterator implements GenericIterator<E> {

    private final Iterator<E> iterator;

    private SpeedEfficientGenericSetIterator() {
      iterator = items.iterator();
    }

    @Override
    public boolean hasNext() {
      return iterator.hasNext();
    }

    @Override
    public E next() {
      return iterator.next();
    }
  }
}
