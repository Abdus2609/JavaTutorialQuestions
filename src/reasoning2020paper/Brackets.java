package reasoning2020paper;

public class Brackets {

  public static boolean wellBr(char[] str) {

    int i = 0;
    char[] stack = new char[str.length];
    int j = stack.length;
    System.out.println(j);

    while (i < str.length) {
      char c = str[i];
      if (c == '(' || c == '[') {
        if (c == '(') {
          stack[--j] = ')';
        }
        if (c == '[') {
          stack[--j] = ']';
        }
      } else if (c == ')' || c == ']') {
        if (j == stack.length || c != stack[j]) {
          return false;
        }
        j++;
      }
      i++;
      System.out.println(j);
    }

    return j == stack.length;
  }

  public static void main(String[] args) {
    wellBr(new char[]{'(', 'a', 'n', 'c', ')'});
  }
}
