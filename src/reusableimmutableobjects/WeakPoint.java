package reusableimmutableobjects;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakPoint {

  private static final Map<WeakPoint, WeakReference<WeakPoint>> pool = new WeakHashMap<>();
  private final int coordX;
  private final int coordY;
  private final int coordZ;

  private WeakPoint(int coordX, int coordY, int coordZ) {
    this.coordX = coordX;
    this.coordY = coordY;
    this.coordZ = coordZ;
  }

  /** Creates a point from the given coordinates, re-using from the pool if possible. */
  public static WeakPoint makePoint(int coordX, int coordY, int coordZ) {
    WeakPoint point = new WeakPoint(coordX, coordY, coordZ);
    if (pool.get(point) != null) {
      return pool.get(point).get();
      // point will now be garbage collected
    }
    pool.put(point, new WeakReference<>(point));
    return point;
  }

  /** Yields the size of the pool. */
  public static int poolSize() {

    return pool.size();
  }

  @Override
  public String toString() {
    return "(" + coordX + ", " + coordY + ", " + coordZ + ")";
  }

  @Override
  public boolean equals(Object that) {
    return that instanceof WeakPoint
        && coordX == ((WeakPoint) that).coordX
        && coordY == ((WeakPoint) that).coordY
        && coordZ == ((WeakPoint) that).coordZ;
  }

  @Override
  public int hashCode() {
    return Integer.valueOf(coordX).hashCode()
        ^ Integer.valueOf(coordY).hashCode()
        ^ Integer.valueOf(coordZ).hashCode();
  }
}
