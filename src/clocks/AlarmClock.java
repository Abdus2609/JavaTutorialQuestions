package clocks;

public class AlarmClock extends Clock {

  private final int alarm;
  private boolean alarmSounding = false;

  public AlarmClock(int time, int alarmSeconds) {
    super(time);
    this.alarm = alarmSeconds;
  }

  public AlarmClock(int hh, int mm, int ss, int hhAlarm, int mmAlarm, int ssAlarm) {
    super(hh, mm, ss);
    this.alarm = convertToSeconds(hhAlarm, mmAlarm, ssAlarm);
  }

  public static void main(String[] args) throws InterruptedException {

    AlarmClock clock = new AlarmClock(23, 59, 50, 23, 59, 58);

    for (int i = 0; i < 1000; i++) {
      System.out.println("Clock says: " + clock);
      clock.tick();
      Thread.sleep(1000);
    }
  }

  @Override
  public void tick() {
    super.tick();

    if (alarmSounding) {
      assert secondsSinceMidnight != alarm;

      int oneMinuteAgo = secondsSinceMidnight - SECONDS_IN_MINUTE;
      if (oneMinuteAgo < 0) {
        oneMinuteAgo += SECONDS_IN_DAY;
      }
      if (oneMinuteAgo == alarm) {
        alarmSounding = false;
      }
    } else if (secondsSinceMidnight == alarm) {
      alarmSounding = true;
    }
  }

  @Override
  public String toString() {
    return super.toString() + " " + (alarmSounding ? beep() : "");
  }

  public String beep() {
    return "BEEP!";
  }
}
