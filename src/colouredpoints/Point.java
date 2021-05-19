package colouredpoints;

public class Point {

  private final double coordX;
  private final double coordY;
  private final double coordZ;

  public Point(double coordX, double coordY, double coordZ) {
    this.coordX = coordX;
    this.coordY = coordY;
    this.coordZ = coordZ;
  }

  public static Point getOrigin() {
    return new Point(0, 0, 0);
  }

  public static void main(String[] args) {

    Point point1 = new Point(5.0, 10.0, -2.6);

    Point point2 = new Point(-2.6, 5.0, 10.0);

    System.out.println("Two points: point1 = " + point1 + " and point2 = " + point2);

    System.out.println("Magnitude of point1 is " + point1.magnitude());

    System.out.println("Magnitude of point2 is " + point2.magnitude());

    assert point1.magnitude() == point2.magnitude();

    System.out.println("Distance between point1 and point2 is " + point1.distanceFrom(point2));

    System.out.println(
        "The origin is "
            + Point.getOrigin()
            + " and it has magnitude "
            + Point.getOrigin().magnitude());
  }

  public double distanceFrom(Point other) {
    return Math.sqrt(
        Math.pow(this.coordX - other.coordX, 2)
            + Math.pow(this.coordY - other.coordY, 2)
            + Math.pow(this.coordZ - other.coordZ, 2));
  }

  public double magnitude() {
    return distanceFrom(getOrigin());
  }

  @Override
  public String toString() {
    return "(" + coordX + ", " + coordY + ", " + coordZ + ")";
  }

  public boolean canEqual(Object other) {
    return other instanceof Point;
  }

  @Override
  public boolean equals(Object other) {
    if (!this.canEqual(other)) {
      return false;
    }

    Point point = (Point) other;

    if (!point.canEqual(this)) {
      return false;
    }

    return point.coordX == this.coordX
        && point.coordY == this.coordY
        && point.coordZ == this.coordZ;
  }

  @Override
  public int hashCode() {
    return Double.valueOf(coordX).hashCode()
        ^ Double.valueOf(coordY).hashCode()
        ^ Double.valueOf(coordZ).hashCode();
  }
}
