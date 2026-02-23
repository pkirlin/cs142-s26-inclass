package oop2;

public class TimeDemo {
    public static void main(String[] args) {
        Time time1 = new Time(12, 0, false);
        Time time2 = new Time(2, 5, false);
        System.out.println(time1.isBefore(time2));

        TimeMinutes time3 = new TimeMinutes(12, 0, true);
        TimeMinutes time4 = new TimeMinutes(2, 5, true);
        System.out.println(time3);
        System.out.println(time4);
        System.out.println(time3.isBefore(time4));
    }
}
