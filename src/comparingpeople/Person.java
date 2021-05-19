package comparingpeople;

public class Person {

  private final String forename;
  private final String surname;
  private final String telephoneNumber;

  public Person(String forename, String surname, String telephoneNumber) {
    this.forename = forename;
    this.surname = surname;
    this.telephoneNumber = telephoneNumber;
  }

  public String getForename() {
    return forename;
  }

  public String getSurname() {
    return surname;
  }

  public String getTelephoneNumber() {
    return telephoneNumber;
  }

  @Override
  public String toString() {
    return forename + " " + surname + " (" + telephoneNumber + ")";
  }
}
