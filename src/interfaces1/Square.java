package interfaces1;

import java.awt.*;

public class Square extends Shape {
    private int sideLength;

    public Square(int newSideLength, Color c) {
        sideLength = newSideLength;
        setColor(c);
    }

    public double getArea() {
        return sideLength * sideLength;
    }

    public String toString() {
        return "Square with side length=" + sideLength;
    }

}
