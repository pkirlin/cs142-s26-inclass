package poly3;

public class Triangle extends Shape {
    private int base, height;

    public Triangle(int newBase, int newHeight) {
        base = newBase;
        height = newHeight;
    }

    public int getArea() {
        return base * height / 2;
    }
}
