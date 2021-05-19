package battlefighters;

public class Fighter {

  protected final String name;
  protected final String type;
  protected final int skill;
  protected int stamina;
  protected final GameEngine gameEngine;

  protected static final int DAMAGE = 2;

  public Fighter(String name, String type, int skill, int stamina, GameEngine gameEngine) {
    this.name = name;
    this.type = type;
    this.skill = skill;
    this.stamina = stamina;
    this.gameEngine = gameEngine;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public void takeDamage(int damage) {
    this.stamina = Math.max(stamina - damage, 0);
  }

  public int calculateDamage() {
    return DAMAGE;
  }

  public int calculateAttackScore() {
    return skill + gameEngine.rollDice() + gameEngine.rollDice();
  }

  public boolean isDead() {
    return this.stamina == 0;
  }

  public String toString() {
    return this.name + " - " + this.type + " - skill: " + skill + "; stamina: " + stamina;
  }
}
