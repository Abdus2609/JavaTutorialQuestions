package reverseorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseOrderArray {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    String[] array = new String[100];
    int counter = 0;

    while (line != null) {
      array[counter] = line;
      counter++;

      line = br.readLine();
    }

    for (int i = 0; i < counter; i++) {
      System.out.println(array[counter - i]);
    }
  }
}
