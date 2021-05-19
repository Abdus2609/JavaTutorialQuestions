package intsets;


import genericcollections.GenericIterator;
import genericcollections.GenericSet;

public class UnmodifiableSet<E> implements GenericSet<E> {

  private final GenericSet<E> set;

  public UnmodifiableSet(GenericSet<E> set) {
    this.set = set;
  }

  @Override
  public void add(E item) {
    throw new UnsupportedOperationException("Attempted to add to unmodifiable set.");
  }

  @Override
  public boolean remove(E item) {
    throw new UnsupportedOperationException("Attempted to remove from unmodifiable set.");
  }

  @Override
  public boolean isEmpty() {
    return set.isEmpty();
  }

  @Override
  public boolean contains(E item) {
    return set.contains(item);
  }

  @Override
  public GenericIterator<E> iterator() {
    return null;
  }
}
