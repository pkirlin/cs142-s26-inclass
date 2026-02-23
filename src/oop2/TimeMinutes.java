package oop2;

public class TimeMinutes {
    private int minutesSinceMidnight;

    public TimeMinutes(int newHour, int newMinute, boolean newIsAM) {
        minutesSinceMidnight = newMinute;
        if (newHour == 12) {
            newHour = 0;
        }
        minutesSinceMidnight += (newHour * 60);
        if (!newIsAM) { // if we are PM
            minutesSinceMidnight += (12 * 60);
        }
    }

    public String toString() {
        int minute = minutesSinceMidnight % 60;
        int hour = minutesSinceMidnight / 60;
        // math to convert hour to 12-hour clock
        return hour + ":" + minute;
    }

    public boolean isBefore(TimeMinutes otherTime) {
        if (minutesSinceMidnight < otherTime.minutesSinceMidnight) {
            return true;
        }
        else {
            return false;
        }
    }
}
