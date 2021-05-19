package genericnumbermanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NumberManipulation {

  static <T extends Number> Set<T> readNumbers(int n, NumberParser<T> parser) throws IOException {

    Set<T> result = new HashSet<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < n; i++) {
      System.out.print("Enter a number of type " + parser.typeParsed() + " to be parsed: ");
      String line = br.readLine();
      result.add(parser.parseNumber(line));
    }

    return result;
  }

  static <T extends Number> T addNumbers(Set<T> nums, NumberAdder<T> adder) {

    T result = adder.zero();

    for (T num : nums) {
      result = adder.add(result, num);
    }

    return result;
  }

  public static void displayAsInts(Set<? extends Number> numbers) {
    System.out.print("[");

    for (Iterator<? extends Number> it = numbers.iterator(); it.hasNext(); ) {
      System.out.print(it.next().intValue());
      if (it.hasNext()) {
        System.out.print(", ");
      }
    }

    System.out.println("]");
  }

  public static void displayAsDoubles(Set<? extends Number> numbers) {
    System.out.print("[");

    for (Iterator<? extends Number> it = numbers.iterator(); it.hasNext(); ) {
      System.out.print(it.next().floatValue());
      if (it.hasNext()) {
        System.out.print(", ");
      }
    }

    System.out.println("]");
  }

  public static void main(String[] args) throws IOException {
    Set<Integer> setInt = readNumbers(5, new IntegerParser());
    Set<Double> setDouble = readNumbers(5, new DoubleParser());

    displayAsInts(setInt);
    displayAsDoubles(setDouble);
    System.out.println(addNumbers(setInt, new IntegerAdder()));
    System.out.println(addNumbers(setDouble, new DoubleAdder()));
  }
}
