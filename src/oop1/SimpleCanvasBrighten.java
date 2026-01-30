package oop1;

import java.awt.*;
import java.util.Scanner;

public class SimpleCanvasBrighten {
    public static void main(String[] args) {
        SimpleCanvas canvas = new SimpleCanvas(800, 572, "My Canvas");
        canvas.drawImage(0, 0, "briggs.jpg");
        canvas.show();

        System.out.println("Press enter to brighten the image.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // wait for enter keypress
        System.out.println("Beginning to brighten....");

        for (int x = 0; x < canvas.getWidth(); x++)
        {
            for (int y = 0; y < canvas.getHeight(); y++)
            {
                Color c = canvas.getPixelColor(x, y); // retrieve the color at pixel (x, y)
                Color brighter = c.brighter();
                canvas.setPixelColor(x, y, brighter);
            }
        }
        canvas.update(); // redraw the canvas
        System.out.println("Done brightening.");
    }
}
