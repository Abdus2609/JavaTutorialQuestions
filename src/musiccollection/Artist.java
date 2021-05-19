package musiccollection;

import java.util.ArrayList;
import java.util.List;

public class Artist {

  private final String name;
  private final List<Record> catalogue;
  private final Genre mainGenre;

  public Artist(String name, Genre mainGenre) {
    this.name = name;
    this.catalogue = new ArrayList<>();
    this.mainGenre = mainGenre;
  }

  public void addRecord(String name) {
    this.catalogue.add(new Record(name, mainGenre));
  }

  public void addRecord(String name, Genre genre) {
    this.catalogue.add(new Record(name, genre));
  }

  public void showCatalogue() {
    for (Record rec : catalogue) {
      System.out.println(rec);
    }
  }

  public void showGenre(Genre genre) {
    for (Record rec : catalogue) {
      if (rec.getGenre() == genre) {
        System.out.println(rec);
      }
    }
  }
}
