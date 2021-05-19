package reasoning2019paper;

public class fibNacci {

  public static int fibonacci(int n, int N) {
    int[] a = new int[N];
    a[1] = 1;
    int i = 0;

    while (i < n) {
      int cnt = 0;
      int val = a[0];
      while (cnt < N - 1) {
        a[cnt] = a[cnt + 1] + val;
        cnt++;
      }

      a[cnt] = val;
      i++;
    }

    return a[0];
  }

  public static void main(String[] args) {
    for (int i = 2; i < 12; i++) {
      System.out.println(fibonacci(i, 340));
    }
  }
}
