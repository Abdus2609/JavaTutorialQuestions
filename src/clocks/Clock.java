package clocks;

public class Clock {

  protected static final int SECONDS_IN_MINUTE = 60;
  private static final int SECONDS_IN_HOUR = 3600;
  private static final int HOURS_IN_DAY = 24;
  protected static final int SECONDS_IN_DAY = SECONDS_IN_HOUR * HOURS_IN_DAY;
  private final DisplayMode displayMode;
  protected int secondsSinceMidnight;

  public Clock(int secondsSinceMidnight) {
    this.secondsSinceMidnight = secondsSinceMidnight;
    this.displayMode = DisplayMode.SECONDS_SINCE_MIDNIGHT;
  }

  public Clock(int hh, int mm, int ss) {
    this.secondsSinceMidnight = convertToSeconds(hh, mm, ss);
    this.displayMode = DisplayMode.TWENTY_FOUR_HOUR;
  }

  private static String addZeroIfNeeded(int x) {
    return x < 10 ? "0" : "";
  }

  public static void main(String[] args) throws InterruptedException {

    Clock clock1 = new Clock(0);

    Clock clock2 = new Clock(23, 59, 53);

    for (int i = 0; i < 100000; i++) {

      System.out.println("Clock 1 shows: " + clock1 + ".  Clock 2 shows: " + clock2);

      clock1.tick();
      clock2.tick();

      Thread.sleep(1000);
    }
  }

  protected int convertToSeconds(int hh, int mm, int ss) {
    return (hh * SECONDS_IN_HOUR) + (mm * SECONDS_IN_MINUTE) + ss;
  }

  public void tick() {
    if (secondsSinceMidnight + 1 == SECONDS_IN_DAY) {
      this.secondsSinceMidnight = 0;
    } else {
      this.secondsSinceMidnight++;
    }
  }

  @Override
  public String toString() {
    if (displayMode == DisplayMode.SECONDS_SINCE_MIDNIGHT) {
      return secondsSinceMidnight + " seconds since midnight.";
    }

    int hh = secondsSinceMidnight / SECONDS_IN_HOUR;
    int mm = (secondsSinceMidnight - (hh * SECONDS_IN_HOUR)) / SECONDS_IN_MINUTE;
    int ss = secondsSinceMidnight - (hh * SECONDS_IN_HOUR) - (mm * SECONDS_IN_MINUTE);

    return addZeroIfNeeded(hh)
        + hh
        + ":"
        + addZeroIfNeeded(mm)
        + mm
        + ":"
        + addZeroIfNeeded(ss)
        + ss;
  }
}
