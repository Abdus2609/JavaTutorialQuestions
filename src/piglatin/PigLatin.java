package piglatin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PigLatin {

  static final List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

  private static boolean isVowel(char letter) {
    return vowels.contains(Character.toLowerCase(letter));
  }

  private static String translate(String word) {

    assert word.length() > 0;

    String translated = null;

    char firstLetter = word.charAt(0);
    if (isVowel(firstLetter)) {
      translated = word + "way";
    } else {
      translated = word.substring(1) + firstLetter + "ay";
    }

    if (Character.isUpperCase(firstLetter)) {
      return translated.substring(0, 1).toUpperCase() + translated.substring(1).toLowerCase();
    }

    return translated;
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    StringBuilder sentence = new StringBuilder();
    StringBuilder word = new StringBuilder();

    while (line != null) {
      for (int i = 0; i < line.length(); i++) {
        if (Character.isLetterOrDigit(line.charAt(i))) {
          word.append(line.charAt(i));
        } else {
          if (word.length() > 0) {
            sentence.append(translate(word.toString()));
            word = new StringBuilder();
          }
          sentence.append(line.charAt(i));
        }
      }

      System.out.println(sentence.toString());

      sentence = new StringBuilder();
      line = br.readLine();
    }
  }
}
