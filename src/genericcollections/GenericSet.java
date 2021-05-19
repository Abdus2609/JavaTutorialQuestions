package genericcollections;

public interface GenericSet<E> extends GenericCollection<E> {

  void add(E item);

  boolean remove(E item);

  boolean isEmpty();

  boolean contains(E item);

  default void addAll(E[] items) {
    for (E item : items) {
      add(item);
    }
  }
}
