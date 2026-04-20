package interfaces1;

import java.awt.*;

public abstract class Shape {
    private Color color;

    public abstract double getArea();

    public void setColor(Color c) {
        color = c;
    }

    public Color getColor() {
        return color;
    }
}
