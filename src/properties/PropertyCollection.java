package properties;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PropertyCollection {

  private final Set<Property> properties;

  public PropertyCollection() {
    this.properties = new HashSet<>();
  }

  public void addProperty(Property p) {
    properties.add(p);
  }

  public Set<House> getHouses() {
    return properties.stream()
        .filter(p -> p instanceof House)
        .map(h -> (House) h)
        .collect(Collectors.toSet());
  }

  public Set<Bungalow> getBungalows() {
    return properties.stream()
        .filter(p -> p instanceof Bungalow)
        .map(b -> (Bungalow) b)
        .collect(Collectors.toSet());
  }

  public Set<Flat> getFlats() {
    return properties.stream()
        .filter(p -> p instanceof Flat)
        .map(f -> (Flat) f)
        .collect(Collectors.toSet());
  }

  public Set<Maisonette> getMaisonettes() {
    return properties.stream()
        .filter(p -> p instanceof Maisonette)
        .map(m -> (Maisonette) m)
        .collect(Collectors.toSet());
  }

  public Set<TerracedHouse> getTerracedHouses() {
    return properties.stream()
        .filter(p -> p instanceof TerracedHouse)
        .map(t -> (TerracedHouse) t)
        .collect(Collectors.toSet());
  }
}
