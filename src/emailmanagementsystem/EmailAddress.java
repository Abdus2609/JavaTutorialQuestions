package emailmanagementsystem;

import java.util.HashSet;
import java.util.Set;

public abstract class EmailAddress {

  private final String id;

  public EmailAddress(String id) {
    this.id = id;
  }

  public final Set<EmailAddress> getTargets() {
    return getTargets(new HashSet<>());
  }

  protected abstract Set<EmailAddress> getTargets(Set<EmailAddress> existing);

  @Override
  public String toString() {
    return id;
  }

  @Override
  public boolean equals(Object other) {
    return other instanceof EmailAddress && ((EmailAddress) other).id.equals(this.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
