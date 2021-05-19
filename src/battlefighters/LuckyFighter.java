package battlefighters;

public class LuckyFighter extends Fighter {

  private final Strategy strategy;
  private final int initialStamina;
  private int luck;

  public LuckyFighter(
      String name,
      String type,
      int skill,
      int stamina,
      GameEngine gameEngine,
      int luck,
      Strategy strategy) {
    super(name, type, skill, stamina, gameEngine);
    this.initialStamina = stamina;
    this.luck = luck;
    this.strategy = strategy;
  }

  @Override
  public void takeDamage(int damage) {

    final int aggressiveLastResort = 3;
    final int averageLastResort = initialStamina / 2;

    if (luck > 0) {
      if (strategy == Strategy.AGGRESSIVE && stamina <= aggressiveLastResort
          || strategy == Strategy.AVERAGE && stamina <= averageLastResort
          || strategy == Strategy.DEFENSIVE) {
        System.out.println(name + " is trying to dodge their way out of this shot!");
        if (testLuck()) {
          damage--;
          System.out.println("The hit luckily missed by inches, scraping off some damage!");
        } else {
          damage++;
          System.out.println(name + "'s luck has gotten even worse! INCREASED DAMAGE!");
        }
      }
    } else {
      System.out.println(name + " is out of luck! They cannot dodge this hit!");
    }

    this.stamina = Math.max(stamina - damage, 0);
  }

  @Override
  public int calculateDamage() {

    final int defensiveLastResort = 3;
    final int averageLastResort = initialStamina / 2;

    if (luck > 0) {
      if (strategy == Strategy.DEFENSIVE && stamina <= defensiveLastResort
          || strategy == Strategy.AVERAGE && stamina <= averageLastResort
          || strategy == Strategy.AGGRESSIVE) {
        System.out.println(name + " is trying to get a lucky hit here!");
        if (testLuck()) {
          System.out.println("What a shot! DOUBLE DAMAGE!");
          return DAMAGE * 2;
        } else {
          System.out.println(name + "'s luck has missed, just like his shot!");
          return DAMAGE - 1;
        }
      }
    } else {
      System.out.println(name + " is out of luck! Their shot's gonna be WEAK!");
    }

    return DAMAGE;
  }

  public boolean testLuck() {
    luck--;
    return gameEngine.rollDice() + gameEngine.rollDice() <= luck;
  }

  @Override
  public String toString() {
    return super.toString() + "; luck: " + luck + "; strategy: " + strategy;
  }
}
