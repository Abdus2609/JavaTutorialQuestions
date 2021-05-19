package battlefighters;

import java.util.Random;

public class GameEngine {

  private static final String LINE = "----------------------------------------------";
  private final Random generator;

  public GameEngine() {
    this.generator = new Random();
  }

  public int rollDice() {
    return generator.nextInt(6) + 1;
  }

  public void simulateBattle(Fighter first, Fighter second) {

    System.out.println("Welcome to the match of the century. Let's introduce the fighters: ");
    System.out.println(first.toString());
    System.out.println(second.toString());
    System.out.println(LINE);
    System.out.println("Let the match begin!");
    System.out.println();

    while (true) {

      int firstAttackScore = first.calculateAttackScore();
      int secondAttackScore = second.calculateAttackScore();

      if (firstAttackScore == secondAttackScore) {
        System.out.println(first.getName() + " draws with " + second.getName());
      } else {

        Fighter winner;
        Fighter loser;
        int winningAttackScore;

        if (firstAttackScore > secondAttackScore) {
          winner = first;
          loser = second;
          winningAttackScore = firstAttackScore;
        } else {
          winner = second;
          loser = first;
          winningAttackScore = secondAttackScore;
        }

        loser.takeDamage(winner.calculateDamage());

        System.out.println(
            winner.getName()
                + " hits "
                + loser.getName()
                + " with a damage of "
                + winningAttackScore);

        System.out.println("The stats are now: ");
        System.out.println(first.toString());
        System.out.println(second.toString());
        System.out.println(LINE);
        System.out.println();

        if (loser.isDead()) {
          System.out.println(loser.getName() + " the " + loser.getType() + " has been demolished.");
          System.out.println(winner.getName() + " is victorious!");
          return;
        }
      }
    }
  }
}
