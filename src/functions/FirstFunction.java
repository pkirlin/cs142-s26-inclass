package functions;

public class FirstFunction {
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + ((y2 - y1) * (y2 - y1)));
    }

    public static void main(String[] args) {
        System.out.println(distance(1, 2, 3, 4));
        System.out.println(distance(0, 0, 1, 1));
    }
}
