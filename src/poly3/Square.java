package poly3;

public class Square extends Shape {
    private int sideLength;

    public Square(int newSideLength) {
        sideLength = newSideLength;
    }

    public int getArea() {
        return sideLength * sideLength;
    }
}
