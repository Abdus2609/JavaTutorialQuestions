package comparingpeople;

public class ForenameComparator implements PersonComparator {

  @Override
  public int compareTo(Person person1, Person person2) {
    return person1.getForename().compareTo(person2.getForename());
  }
}
