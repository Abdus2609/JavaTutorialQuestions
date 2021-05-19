package battlefighters;

public class Main {

  public static void main(String[] args) {

    GameEngine colosseum = new GameEngine();

    Fighter omar = new LuckyFighter("Omar", "Haji", 18, 24, colosseum, 12, Strategy.AGGRESSIVE);
    Fighter abdus = new LuckyFighter("Abdus", "Paki", 18, 24, colosseum, 12, Strategy.AGGRESSIVE);

    colosseum.simulateBattle(omar, abdus);
  }
}
