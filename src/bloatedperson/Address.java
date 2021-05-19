package bloatedperson;

public class Address {

  private final int houseNumber;
  private final String addressLine1;
  private final String addressLine2;
  private final String postCode;

  public Address(int houseNumber, String addressLine1, String addressLine2, String postCode) {
    this.houseNumber = houseNumber;
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.postCode = postCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return houseNumber == address.houseNumber
        && addressLine1.equals(address.addressLine1)
        && addressLine2.equals(address.addressLine2)
        && postCode.equals(address.postCode);
  }

  @Override
  public int hashCode() {
    return 17 * houseNumber
        ^ addressLine1.hashCode()
        ^ addressLine2.hashCode()
        ^ postCode.hashCode();
  }

  @Override
  public String toString() {
    return houseNumber + " " + addressLine1 + ", " + addressLine2 + ", " + postCode;
  }
}
