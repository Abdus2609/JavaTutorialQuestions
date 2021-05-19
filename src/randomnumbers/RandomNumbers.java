package randomnumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbers {

  private static boolean check(int[] allPossible, List<Integer> generated) {

    for (int num : allPossible) {
      if (!generated.contains(num)) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {

    assert args.length == 1;

    int bound = Integer.parseInt(args[0]);
    int[] values = new int[bound];

    for (int i = 0; i < bound; i++) {
      values[i] = i;
    }

    Random generator = new Random();
    List<Integer> generated = new ArrayList<>();

    while (!check(values, generated)) {
      int num = generator.nextInt(bound);
      generated.add(num);
    }

    System.out.println("Generating numbers: ");

    for (int i = 0; i < generated.size() - 1; i++) {
      System.out.print(generated.get(i) + ", ");
    }

    System.out.println(generated.get(generated.size() - 1));
    System.out.println(
        "I had to generate " + generated.size() + " random numbers between 0 and " + (bound - 1)
            + " to have produced all such numbers at least once.");
  }
}
