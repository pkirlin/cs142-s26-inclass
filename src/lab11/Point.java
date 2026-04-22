package lab11;

public class Point {

    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /*public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        else if (!(other instanceof Point)) {
            return false;
        }
        Point otherPoint = (Point)other;
        return (x == otherPoint.x) && (y == otherPoint.y);
    }*/

}
