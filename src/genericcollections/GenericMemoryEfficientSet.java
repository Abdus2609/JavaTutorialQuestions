package genericcollections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GenericMemoryEfficientSet<E> implements GenericSet<E> {

  private final List<E> items;

  public GenericMemoryEfficientSet() {
    this.items = new ArrayList<>();
  }

  @Override
  public void add(E item) {
    if (!items.contains(item)) {
      items.add(item);
    }
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
  public void addAll(E[] array) {

    Set<E> alreadySeen = new HashSet<>(items);

    for (E item : array) {
      if (!alreadySeen.contains(item)) {
        items.add(item);
        alreadySeen.add(item);
      }
    }
  }

  @Override
  public GenericIterator<E> iterator() {
    return new MemoryEfficientGenericSetIterator();
  }

  private class MemoryEfficientGenericSetIterator implements GenericIterator<E> {

    private final Iterator<E> iterator;

    private MemoryEfficientGenericSetIterator() {
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
