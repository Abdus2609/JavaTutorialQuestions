package emailmanagementsystem;

import java.util.HashSet;
import java.util.Set;

public class GroupEmailAddress extends EmailAddress {

  Set<EmailAddress> participants;

  public GroupEmailAddress(String id) {
    super(id);
    this.participants = new HashSet<>();
  }

  public void addEmailAddress(EmailAddress e) {
    participants.add(e);
  }

  @Override
  public Set<EmailAddress> getTargets(Set<EmailAddress> existing) {
    Set<EmailAddress> targets = new HashSet<>();

    if (existing.contains(this)) {
      return existing;
    }

    existing.add(this);

    for (EmailAddress e : participants) {
      targets.addAll(e.getTargets(existing));
    }

    return targets;
  }
}
