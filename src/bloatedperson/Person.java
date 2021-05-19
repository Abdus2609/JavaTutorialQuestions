package bloatedperson;

public class Person {

  private final Name name;
  private final Date dateOfBirth;
  private final Address address;
  private final NiNumber nationalInsuranceNumber;

  public Person(Name name, Date dateOfBirth, Address address, NiNumber nationalInsuranceNumber) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.address = address;
    this.nationalInsuranceNumber = nationalInsuranceNumber;
  }

  public static void main(String[] args) {
    Name name = new Name("Mohammed Abdus Samad", "Hannan");
    Date dob = new Date(26, 9, 2001);
    Address address = new Address(70, "Coleridge House", "Churchill Gardens", "SW1V 3HX");
    NiNumber niNumber = new NiNumber("AA123456C");
    Person abdus = new Person(name, dob, address, niNumber);
    System.out.println(abdus);
  }

  public boolean sameAddress(Person other) {
    return address.equals(other.address);
  }

  public String toString() {
    return "Name: "
        + name
        + "\n"
        + "DOB: "
        + dateOfBirth
        + "\n"
        + "Address: "
        + address
        + "\n"
        + "NI: "
        + nationalInsuranceNumber;
  }
}
