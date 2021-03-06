package flawedhouse;

public class FlawedHouse {

  private Rectangle floorSize;
  private int floorArea;

  public FlawedHouse(Rectangle floorSize) {
    setFloorSize(floorSize);
  }

  public Rectangle getFloorSize() {
    return floorSize;
  }

  public void setFloorSize(Rectangle floorSize) {
    this.floorSize = floorSize;
    floorArea = floorSize.getWidth() * floorSize.getHeight();
  }

  public int getFloorArea() {
    return floorArea;
  }
}
