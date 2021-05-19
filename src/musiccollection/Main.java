package musiccollection;

public class Main {

  public static void main(String[] args) {

    Artist usher = new Artist("Usher", Genre.RNB);

    usher.addRecord("My Boo");
    usher.addRecord("DJ Got Us Falling In Love", Genre.POP);
    usher.addRecord("Yeah!", Genre.HIP_HOP);

    System.out.println(
        "This is Usher's full catalogue. It is amazing to think he has eight "
            + "Grammy's with three songs!");
    usher.showCatalogue();
  }
}
