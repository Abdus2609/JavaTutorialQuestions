package clocks;

public enum RadioStation {
  NONE,
  RADIO_4,
  PLANET_ROCK,
  FIVE_LIVE,
  JAZZ_FM;

  public String getNoise() {
    return switch (this) {
      case NONE -> "";
      case RADIO_4 -> "Blah, blah, blah";
      case PLANET_ROCK -> "Rock rock 'till you drop";
      case FIVE_LIVE -> "...and it's a GOAL!!";
      case JAZZ_FM -> "Ba di bah, ba do bop";
    };
  }
}
