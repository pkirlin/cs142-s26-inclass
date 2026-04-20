package interfaces1;

import java.awt.*;
import java.util.ArrayList;

public class DrawingDemo {
    public static void main(String[] args)
    {
        Circle circle = new Circle(50, Color.RED);
        Square square = new Square(60, Color.BLUE);
        Dog fido = new Dog("Fido", 2);
        ShowDog lassie = new ShowDog("Lassie", 5);
        Cat snowball = new Cat("Snowball", 3);

        // Write code here to make an arraylist and add the
        // objects we want to draw into the arraylist.

        // Call the drawAllObjects function.
    }

    /*public static void drawAllObjects(ArrayList<???> list)
    {
        SimpleCanvas canvas = new SimpleCanvas(500, 500);

        // code here to draw all the objects

        canvas.show()
    }*/
}
