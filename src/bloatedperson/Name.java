package bloatedperson;

import java.util.StringTokenizer;

public class Name {

  private final String forenames;
  private final String surname;

  public Name(String forenames, String surname) {
    this.forenames = forenames;
    this.surname = surname;
  }

  public String getForenames() {
    return forenames;
  }

  public String getSurname() {
    return surname;
  }

  public String getInitials() {
    final StringBuilder result = new StringBuilder();
    result.append(forenames.charAt(0));

    /*
     StringTokenizer tokenizer = new StringTokenizer(forenames);
     while(tokenizer.hasMoreTokens()) {
      result.append(tokenizer.nextToken().charAt(0));
     }
    */

    for (int i = 1; i < forenames.length(); i++) {
      if (forenames.charAt(i - 1) == ' ') {
        result.append(forenames.charAt(i));
      }
    }

    return result.toString() + surname.charAt(0);
  }

  @Override
  public String toString() {
    return forenames + " " + surname;
  }
}
