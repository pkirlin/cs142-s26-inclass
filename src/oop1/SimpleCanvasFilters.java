package oop1;

import java.awt.*;
import java.util.Scanner;

public class SimpleCanvasFilters {
    public static void main(String[] args) {
        SimpleCanvas canvas = new SimpleCanvas(800, 572, "My Canvas");
        canvas.drawImage(0, 0, "briggs.jpg");
        canvas.show();

        System.out.println("Press enter to run the filter.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // wait for enter keypress

        // change this call to use a different filter
        runRemoveRedFilter(canvas);

        canvas.update(); // redraw the canvas
    }

    public static void runRemoveRedFilter(SimpleCanvas canvas)
    {
        for (int x = 0; x < canvas.getWidth(); x++)
        {
            for (int y = 0; y < canvas.getHeight(); y++)
            {
                // get the color at pixel (x, y)
                // get the individual R, G, B components
                // set the color at (x, y) to the same color as before, but with zero for red
            }
        }
    }

    public static void runSwapRedBlueFilter(SimpleCanvas canvas)
    {
        for (int x = 0; x < canvas.getWidth(); x++)
        {
            for (int y = 0; y < canvas.getHeight(); y++)
            {
                // get the color at pixel (x, y)
                // get the individual R, G, B components
                // set the color at (x, y) to the same color as before, but with R & B swapped
            }
        }
    }

    public static void runGrayscaleFilter(SimpleCanvas canvas)
    {
        for (int x = 0; x < canvas.getWidth(); x++)
        {
            for (int y = 0; y < canvas.getHeight(); y++)
            {
                // get the color at pixel (x, y)
                // get the individual R, G, B components
                // set the color at (x, y) to the use the average of the
                // individual R, G, and B components for all three components.
            }
        }
    }

    public static void runSepiaFilter(SimpleCanvas canvas)
    {
        for (int x = 0; x < canvas.getWidth(); x++)
        {
            for (int y = 0; y < canvas.getHeight(); y++)
            {
                // Use this idea:
                // outputRed = (inputRed * .393) + (inputGreen *.769) + (inputBlue * .189)
                // outputGreen = (inputRed * .349) + (inputGreen *.686) + (inputBlue * .168)
                // outputBlue = (inputRed * .272) + (inputGreen *.534) + (inputBlue * .131)
                // if any of the outputs are > 255, use 255 instead.
            }
        }
    }

    public static void runFlipHorizontallyFilter(SimpleCanvas canvas)
    {

    }

    public static void runFlipVerticallyFilter(SimpleCanvas canvas)
    {

    }
}
