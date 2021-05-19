package reusableimmutableobjects;

import java.util.ArrayList;
import java.util.List;

public class OriginalDemo {

  public static void main(String[] args) {

    List<OriginalPoint> pointList = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      pointList.add(new OriginalPoint(0, 0, 0));
    }

    if (allDifferent(pointList)) {
      System.out.println("The points are all different object references.");
    } else {
      System.out.println("Some of the points are identical references.");
    }
  }

  private static boolean allDifferent(List<OriginalPoint> pointList) {

    for (int i = 0; i < pointList.size() - 1; i++) {
      for (int j = i + 1; j < pointList.size(); j++) {
        if (pointList.get(i) == pointList.get(j)) {
          return false;
        }
      }
    }

    return true;
  }
}
