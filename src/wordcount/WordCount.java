package wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class WordCount {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int lineCount = 0;
    int wordCount = 0;
    int charCount = 0;

    String line = br.readLine();

    while (line != null) {

      lineCount++;

      boolean inWord = false;

      for (int i = 0; i < line.length(); i++) {
        if (Character.isLetterOrDigit(line.charAt(i))) {
          charCount++;
          if (!inWord) {
            wordCount++;
          }
          inWord = true;
        } else {
          inWord = false;
        }
      }

      line = br.readLine();
    }

    System.out.println("Lines: " + lineCount);
    System.out.println("Words: " + wordCount);
    System.out.println("Characters: " + charCount);
  }
}
