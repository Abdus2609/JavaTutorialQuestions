package reusableimmutableobjects;

public class OriginalPoint {

  private final int coordX;
  private final int coordY;
  private final int coordZ;

  public OriginalPoint(int coordX, int coordY, int coordZ) {
    this.coordX = coordX;
    this.coordY = coordY;
    this.coordZ = coordZ;
  }

  @Override
  public String toString() {
    return "(" + coordX + ", " + coordY + ", " + coordZ + ")";
  }

  @Override
  public boolean equals(Object that) {
    return that instanceof OriginalPoint
        && coordX == ((OriginalPoint) that).coordX
        && coordY == ((OriginalPoint) that).coordY
        && coordZ == ((OriginalPoint) that).coordZ;
  }

  @Override
  public int hashCode() {
    return Integer.valueOf(coordX).hashCode()
        ^ Integer.valueOf(coordY).hashCode()
        ^ Integer.valueOf(coordZ).hashCode();
  }
}
