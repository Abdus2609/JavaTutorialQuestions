package bloatedperson;

public class NiNumber {

  private final String nationalInsuranceNumber;

  public NiNumber(String nationalInsuranceNumber) {
    this.nationalInsuranceNumber = nationalInsuranceNumber;
  }

  @Override
  public String toString() {
    return nationalInsuranceNumber;
  }
}
