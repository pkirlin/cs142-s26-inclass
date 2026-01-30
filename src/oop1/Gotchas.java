package oop1;

import java.awt.*;
import java.util.Scanner;

public class Gotchas {
    public static void main(String[] args)
    {
        demoGotcha1();
        //demoGotcha3();
    }

    public static void demoGotcha1()
    {
        SimpleCanvas bigCanvas = new SimpleCanvas(400, 400);
        SimpleCanvas smallCanvas = new SimpleCanvas(200, 200);
        SimpleCanvas thirdCanvas = bigCanvas;

        bigCanvas.show();
        smallCanvas.show();
        thirdCanvas.show();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to continue");
        scanner.nextLine();

        bigCanvas.setPenColor(Color.RED);
        bigCanvas.drawFilledCircle(100, 100, 50);
        bigCanvas.update();

        smallCanvas.setPenColor(Color.BLUE);
        smallCanvas.drawFilledCircle(100, 100, 50);
        smallCanvas.update();

        thirdCanvas.setPenColor(Color.ORANGE);
        thirdCanvas.drawFilledCircle(150, 150, 50);
        thirdCanvas.update();

        System.out.println("Press enter to continue");
        scanner.nextLine();

        thirdCanvas = smallCanvas;

        thirdCanvas.setPenColor(Color.GREEN);
        thirdCanvas.drawFilledCircle(50, 50, 50);
        thirdCanvas.update();
    }

    public static void demoGotcha3()
    {
        SimpleCanvas bigCanvas = new SimpleCanvas(400, 400);
        bigCanvas.show();
        someFunction(bigCanvas);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to continue");
        scanner.nextLine();

        bigCanvas.drawFilledCircle(50, 50, 50);
        bigCanvas.update();
    }

    public static void someFunction(SimpleCanvas parameterCanvas)
    {
        parameterCanvas.setPenColor(Color.MAGENTA);
        parameterCanvas.drawFilledCircle(200, 200, 50);
        parameterCanvas.update();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to continue");
        scanner.nextLine();

        parameterCanvas = new SimpleCanvas(200, 200);
        parameterCanvas.setPenColor(Color.GRAY);
        parameterCanvas.drawFilledCircle(100, 100, 50);
        parameterCanvas.show();
        parameterCanvas.update();
    }
}
