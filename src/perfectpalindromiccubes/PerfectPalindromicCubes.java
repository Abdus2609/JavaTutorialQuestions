package perfectpalindromiccubes;

public class PerfectPalindromicCubes {

  static boolean isPalindrome(String str) {
    if (str.length() <= 1) {
      return true;
    }

    return str.charAt(0) == str.charAt(str.length() - 1)
        && isPalindrome(str.substring(1, str.length() - 1));
  }

  public static void main(String[] args) {

    for (int i = 0; i < 1500; i++) {
      if (isPalindrome(String.valueOf(i * i * i))) {
        System.out.println(i + " cubed is " + i * i * i);
      }
    }
  }
}
