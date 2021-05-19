package comparingpeople;

public class SurnameComparator implements PersonComparator {

  @Override
  public int compareTo(Person person1, Person person2) {
    return person1.getSurname().compareTo(person2.getSurname());
  }
}
