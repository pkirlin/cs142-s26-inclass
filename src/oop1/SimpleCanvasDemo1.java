package oop1;

import java.awt.*;

public class SimpleCanvasDemo1 {
    public static void main(String[] args) {

        // Declare a new SimpleCanvas variable called canvas.
        SimpleCanvas canvas;

        // Instantiate a new SimpleCanvas object by calling a constructor.
        // This creates a new instance of the SimpleCanvas class, and assigns
        // that instance to the canvas variable.
        canvas = new SimpleCanvas(400, 200, "My Canvas");

        // Note that we could have done both lines together:
        // SimpleCanvas canvas = new SimpleCanvas(400, 200, "My Canvas");

        // Invoke some instance methods that operate on the canvas.
        canvas.setPenColor(Color.BLUE);
        canvas.drawFilledRectangle(100, 50, 50, 100);
        canvas.setPenColor(Color.RED);
        canvas.setLineThickness(5);
        canvas.drawCircle(300, 100, 50);
        canvas.show();
    }
}
