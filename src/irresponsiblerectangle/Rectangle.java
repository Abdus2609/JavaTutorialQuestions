package irresponsiblerectangle;

public class Rectangle {

  private final Point topLeft;
  private final int width;
  private final int height;

  public Rectangle(Point topLeft, int width, int height) {
    this.topLeft = topLeft;
    this.width = width;
    this.height = height;
  }

  public Point getTopLeft() {
    return topLeft;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Point getBottomRight() {
    return new Point(topLeft.getCoordX() + width, topLeft.getCoordY() + height);
  }

  public int area() {
    return width * height;
  }

  public boolean contains(Rectangle other) {
    return topLeft.getCoordX() <= other.topLeft.getCoordX()
        && topLeft.getCoordY() <= other.topLeft.getCoordY()
        && getBottomRight().getCoordX() >= other.getBottomRight().getCoordX()
        && getBottomRight().getCoordY() >= other.getBottomRight().getCoordY();
  }

  public String toString() {
    return "(top-left = " + topLeft + ", width = " + width + ", height = " + height + ")";
  }
}
