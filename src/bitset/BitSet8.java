package bitset;

public class BitSet8 implements BitSet {

  private byte representation;

  public BitSet8() {
    this.representation = 0;
  }

  @Override
  public void add(int value) {
    if (!inRange(value)) {
      throw new RuntimeException("Value " + value + " is too large for this bit set.");
    }

    representation |= ((byte) 1 << (byte) value);
  }

  @Override
  public void remove(int value) {
    if (inRange(value)) {
      representation &= (~((byte) 1 << (byte) value));
    }
  }

  @Override
  public boolean contains(int x) {
    if (!inRange(x)) {
      return false;
    }

    return (((byte) 1 << (byte) x) & representation) != 0;
  }

  @Override
  public void intersectWith(BitSet s) {
    if (s instanceof BitSet8) {
      representation &= ((BitSet8) s).representation;
    } else {
      for (int i = 0; inRange(i); i++) {
        if (!s.contains(i)) {
          remove(i);
        }
      }
    }
  }

  @Override
  public int maxStorableValue() {
    return Byte.SIZE;
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

  private boolean inRange(int x) {
    return x >= 0 && x < maxStorableValue();
  }
}
