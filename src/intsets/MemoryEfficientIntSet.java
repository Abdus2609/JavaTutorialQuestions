package intsets;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MemoryEfficientIntSet extends AbstractIntSet {

  private final List<Integer> members;

  public MemoryEfficientIntSet() {
    this.members = new ArrayList<>();
  }

  @Override
  public void add(int x) {
    members.add(x);
  }

  @Override
  public boolean remove(int x) {
    return members.remove(Integer.valueOf(x));
  }

  @Override
  public boolean isEmpty() {
    return members.isEmpty();
  }

  @Override
  public boolean contains(int x) {
    return members.contains(x);
  }

  @Override
  public IntSetIterator iterator() {
    return new MemoryEfficientIntSetIterator();
  }

  private class MemoryEfficientIntSetIterator implements IntSetIterator {

    private final ListIterator<Integer> iterator;

    private MemoryEfficientIntSetIterator() {
      this.iterator = members.listIterator();
    }

    @Override
    public boolean hasNext() {
      return iterator.hasNext();
    }

    @Override
    public int next() {
      return iterator.next();
    }
  }
}
