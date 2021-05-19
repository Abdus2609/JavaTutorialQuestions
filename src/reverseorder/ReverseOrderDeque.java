package reverseorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseOrderDeque {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    Deque<String> inputs = new ArrayDeque<>();

    while (line != null) {
      inputs.push(line);
      line = br.readLine();
    }

    while (!inputs.isEmpty()) {
      System.out.println(inputs.pop());
    }
  }
}
