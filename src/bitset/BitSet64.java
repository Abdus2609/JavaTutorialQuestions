package bitset;

public class BitSet64 implements BitSet {

  private long representation;

  public BitSet64() {
    this.representation = 0;
  }

  @Override
  public void add(int x) {
    if (!inRange(x)) {
      throw new RuntimeException("Value " + x + " is too large for this bit set.");
    }

    representation |= ((long) 1 << (long) x);
  }

  @Override
  public void remove(int x) {
    if (inRange(x)) {
      representation &= (~((long) 1 << (long) x));
    }
  }

  @Override
  public boolean contains(int x) {
    if (!inRange(x)) {
      return false;
    }
    return (((long) 1 << (long) x) & representation) != 0;
  }

  @Override
  public void intersectWith(BitSet other) {
    if (other instanceof BitSet64) {
      representation &= ((BitSet64) other).representation;
    } else {
      for (int x = 0; inRange(x); x++) {
        if (!other.contains(x)) {
          remove(x);
        }
      }
    }
  }

  @Override
  public String toString() {
    final StringBuilder result = new StringBuilder("{ ");
    boolean first = true;
    for (int x = 0; inRange(x); x++) {
      if (contains(x)) {
        if (first) {
          first = false;
        } else {
          result.append(", ");
        }
        result.append(x);
      }
    }
    return result + " }";
  }

  @Override
  public int maxStorableValue() {
    return Long.SIZE;
  }

  private boolean inRange(int x) {
    return x >= 0 && x < maxStorableValue();
  }
}
