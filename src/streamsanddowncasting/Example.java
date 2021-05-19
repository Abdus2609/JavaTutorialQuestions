package streamsanddowncasting;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

  static Stream<Integer> restrictToPositiveIntegers(Stream<Number> numbers) {
    return numbers.filter(n -> n instanceof Integer).map(i -> (int) i).filter(n -> n > 0);
  }

  static Stream<Integer> restrictToPositiveIntegerBoundedWildcard(
      Stream<? extends Number> numbers) {
    return numbers.filter(n -> n instanceof Integer).map(i -> (int) i).filter(n -> n > 0);
  }

  public static void main(String[] args) {
    final List<Number> numberList = List.of(3, 56, 4.3, 1, 9, -5, -4.32);
    final List<Number> numbers = List.of(5, 2, 3.0f, -20.0, (short) -1, -12, -200, 200, 0);
    final List<Double> floats = List.of(10.0, -20.0, 31.0, 412.34);
    final List<Integer> integers = List.of(1, -1, 2, -2, 3, -3, 4, -4, 0);

    System.out.println("Positive integers from " + numberList + " are: ");
    System.out.println(
        restrictToPositiveIntegers(numberList.stream()).collect(Collectors.toList()));
    System.out.println("Positive integers from " + integers + " are: ");
    System.out.println(
        restrictToPositiveIntegerBoundedWildcard(integers.stream()).collect(Collectors.toList()));
  }
}
