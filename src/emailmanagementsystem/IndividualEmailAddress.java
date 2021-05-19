package emailmanagementsystem;

import java.util.HashSet;
import java.util.Set;

public class IndividualEmailAddress extends EmailAddress {

  public IndividualEmailAddress(String id) {
    super(id);
  }

  public Set<EmailAddress> getTargets(Set<EmailAddress> existing) {
    Set<EmailAddress> targets = new HashSet<>();
    targets.add(this);

    return targets;
  }
}
