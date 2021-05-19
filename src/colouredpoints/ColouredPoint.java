package colouredpoints;

public class ColouredPoint extends Point {

  private final Colour colour;

  public ColouredPoint(double coordX, double coordY, double coordZ, Colour colour) {
    super(coordX, coordY, coordZ);
    this.colour = colour;
  }

  public static void main(String[] args) {

    Point firstPoint = new Point(5.0, 10.0, -2.6);

    ColouredPoint secondPoint = new ColouredPoint(-2.6, 5.0, 10.0, Colour.RED);

    // Observe that we can write exactly what we wrote in
    // PointDemo: because secondPoint *is* a Point

    System.out.println(
        "Two points: firstPoint = " + firstPoint + " and secondPoint = " + secondPoint);

    System.out.println("Magnitude of firstPoint is " + firstPoint.magnitude());

    System.out.println("Magnitude of secondPoint is " + secondPoint.magnitude());

    assert firstPoint.magnitude() == secondPoint.magnitude();

    System.out.println(
        "Distance between firstPoint and secondPoint is " + firstPoint.distanceFrom(secondPoint));

    System.out.println(
        "The origin is "
            + Point.getOrigin()
            + " and it has magnitude "
            + Point.getOrigin().magnitude());
  }

  @Override
  public String toString() {
    return "(" + super.toString() + " - colour: " + colour + ")";
  }

  @Override
  public boolean canEqual(Object other) {
    return (other instanceof ColouredPoint);
  }

  @Override
  public boolean equals(Object other) {
    if (!canEqual(other)) {
      return false;
    }

    ColouredPoint cp = (ColouredPoint) other;
    if (!cp.canEqual(this)) {
      return false;
    }

    return super.equals(cp) && this.colour == cp.colour;
  }

  @Override
  public int hashCode() {
    return super.hashCode() ^ colour.hashCode();
  }
}
