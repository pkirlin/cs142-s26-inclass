package oop2;

public class Time {
    // instance variables
    private int hour;  // 1-12
    private int minute; // 0-59
    private boolean isAM; // true = time is AM, false = time is PM

    public Time(int newHour, int newMinute, boolean newIsAM) {
        hour = newHour;
        minute = newMinute;
        isAM = newIsAM;
    }

    public String toString() {
        // return a string that will be printed when I call System.out.println on a time object
        // we want times to be printed like 11:51 PM or 7:03 AM
        String timeString = "";
        timeString += hour;
        timeString += ":";
        if (minute <= 9) {
            timeString += "0";
        }
        timeString += minute;
        timeString += " ";
        if (isAM) {
            timeString += "AM";
        } else {
            timeString += "PM";
        }
        return timeString;
    }

    public boolean isBefore(Time otherTime) {
        if (isAM && !otherTime.isAM) {  // we are AM and otherTime is PM
            return true;
        }
        else if (!isAM && otherTime.isAM) {  // we are PM and otherTime is AM
            return false;
        }
        else {
            // we know that the 2 am/pm's match
            int compareHour = hour;
            int compareOtherHour = otherTime.hour;
            if (hour == 12) {
                compareHour = 0;
            }
            if (otherTime.hour == 12) {
                compareOtherHour = 0;
            }

            if (compareHour < compareOtherHour) {
                return true;
            }
            else if (compareHour > compareOtherHour) {
                return false;
            }
            // now we know that the hours match, so just compare minutes
            if (minute < otherTime.minute) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
