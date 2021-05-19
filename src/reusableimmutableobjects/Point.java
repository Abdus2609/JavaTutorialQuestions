package reusableimmutableobjects;

import java.util.HashMap;
import java.util.Map;

public class Point {

  private static final Map<Point, Point> pool = new HashMap<>();

  private final int coordX;
  private final int coordY;
  private final int coordZ;

  private Point(int coordX, int coordY, int coordZ) {
    this.coordX = coordX;
    this.coordY = coordY;
    this.coordZ = coordZ;
  }

  public static Point makePoint(int x, int y, int z) {
    Point p = new Point(x, y, z);
    if (pool.get(p) == null) {
      pool.put(p, p);
      return p;
    }
    return pool.get(p);
  }

  @Override
  public String toString() {
    return "(" + coordX + ", " + coordY + ", " + coordZ + ")";
  }

  @Override
  public boolean equals(Object that) {
    return that instanceof Point
        && coordX == ((Point) that).coordX
        && coordY == ((Point) that).coordY
        && coordZ == ((Point) that).coordZ;
  }

  @Override
  public int hashCode() {
    return Integer.valueOf(coordX).hashCode()
        ^ Integer.valueOf(coordY).hashCode()
        ^ Integer.valueOf(coordZ).hashCode();
  }
}
