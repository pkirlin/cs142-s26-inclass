package oop1;

import java.awt.*;

public class SimpleCanvasCountBlue {
    public static void main(String[] args) {
        SimpleCanvas canvas = new SimpleCanvas(400, 200, "My Canvas");

        canvas.setPenColor(Color.BLUE);
        canvas.drawFilledRectangle(100, 50, 50, 100);
        canvas.show();

        // Count the blue pixels.
        int bluePixels = 0;
        for (int x = 0; x < canvas.getWidth(); x++)
        {
            for (int y = 0; y < canvas.getHeight(); y++)
            {
                Color c = canvas.getPixelColor(x, y); // retrieve the color at pixel (x, y)
                if (c.equals(Color.BLUE)) {
                    bluePixels++;
                }
            }
        }
        System.out.println("There are " + bluePixels + " blue pixels.");
    }
}
