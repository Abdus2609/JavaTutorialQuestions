package lotterynumbers;

import java.util.Random;

public class LotteryNumbers {

  private static final int NUM_NUMBERS = 7;
  private static final int NON_BONUS_NUMBERS = 6;
  static Random generator = new Random();

  static boolean checkDistinct(int[] array, int selectedNumber) {

    for (int num : array) {
      if (num == selectedNumber) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {

    int[] numbers = new int[NUM_NUMBERS];

    for (int i = 0; i < NUM_NUMBERS; i++) {
      int number = generator.nextInt(50);
      while (!checkDistinct(numbers, number) || number < 1) {
        number = generator.nextInt();
      }

      numbers[i] = number;
      if (i < NON_BONUS_NUMBERS) {
        System.out.println("Number " + (i + 1) + ": " + numbers[i]);
      }
    }

    System.out.println("Bonus Number: " + numbers[6]);
  }
}
