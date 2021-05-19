package intsets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SpeedEfficientIntSet extends AbstractIntSet {

  private final Set<Integer> members;

  public SpeedEfficientIntSet() {
    this.members = new HashSet<>();
  }

  @Override
  public void add(int x) {
    members.add(x);
  }

  @Override
  public boolean remove(int x) {
    return members.remove(x);
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
    return new SpeedEfficientIntSetIterator();
  }

  private class SpeedEfficientIntSetIterator implements IntSetIterator {

    private final Iterator<Integer> iterator;

    private SpeedEfficientIntSetIterator() {
      this.iterator = members.iterator();
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
