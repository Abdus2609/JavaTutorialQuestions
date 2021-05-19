package clocks;

public class RadioAlarmClock extends AlarmClock {

  private final RadioStation radioStation;

  public RadioAlarmClock(int time, int alarmSeconds, RadioStation radioStation) {
    super(time, alarmSeconds);
    this.radioStation = radioStation;
  }

  public RadioAlarmClock(
      int hh, int mm, int ss, int hhAlarm, int mmAlarm, int ssAlarm, RadioStation radioStation) {
    super(hh, mm, ss, hhAlarm, mmAlarm, ssAlarm);
    this.radioStation = radioStation;
  }

  public static void main(String[] args) throws InterruptedException {

    AlarmClock clock = new RadioAlarmClock(23, 59, 50, 23, 59, 58, RadioStation.PLANET_ROCK);

    for (int i = 0; i < 1000; i++) {
      System.out.println("Clock says: " + clock);
      clock.tick();
      Thread.sleep(1000);
    }
  }

  @Override
  public String beep() {
    if (radioStation == RadioStation.NONE) {
      return super.beep();
    } else {
      return radioStation.getNoise();
    }
  }
}
