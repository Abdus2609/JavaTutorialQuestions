package comparingpeople;

public class TelephoneNumberComparator implements PersonComparator {

  @Override
  public int compareTo(Person person1, Person person2) {
    return person1.getTelephoneNumber().compareTo(person2.getTelephoneNumber());
  }
}
