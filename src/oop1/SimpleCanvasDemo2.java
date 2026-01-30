package oop1;

import java.awt.*;

public class SimpleCanvasDemo2 {
    public static void main(String[] args) {

        // Declare a new SimpleCanvas variable called canvas and instantiate
        // a new SimpleCanvas object at the same time.
        SimpleCanvas canvas = new SimpleCanvas(400, 200, "My Canvas");

        // Instantiate a second SimpleCanvas object.
        SimpleCanvas canvas2 = new SimpleCanvas(300, 300, "Second Canvas");

        // Invoke some instance methods that operate on the canvas.
        canvas.setPenColor(Color.BLUE);
        canvas.drawFilledRectangle(100, 20, 50, 100);
        canvas.show();

        // Invoke some instance methods on the second canvas object.
        canvas2.setPenColor(Color.RED);
        canvas2.drawFilledCircle(150, 150, 100);
        canvas2.drawImage(50, 50, "lynx.png");
        canvas2.show();

        // Note that each object has its own identity
        // and the objects refer to different canvases.
    }
}
