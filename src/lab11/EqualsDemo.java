package lab11;

import java.util.ArrayList;
import java.util.List;

public class EqualsDemo {
    public static void main(String[] args)
    {
        testPointEquals();
        //testPersonEquals();
    }

    public static void testPointEquals()
    {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 1);
        Point p3 = new Point(1, 2);
        Point p4 = p1;

        // Tests using ==
        System.out.println("Is p1 == p2? " + (p1 == p2));
        System.out.println("Is p1 == p3? " + (p1 == p3));
        System.out.println("Is p2 == p3? " + (p2 == p3));
        System.out.println("Is p1 == p4? " + (p1 == p4));

        // Tests using equals()
        System.out.println("Is p1 equal to p2? " + p1.equals(p2));
        System.out.println("Is p1 equal to p3? " + p1.equals(p3));
        System.out.println("Is p2 equal to p3? " + p2.equals(p3));
        System.out.println("Is p1 equal to p4? " + p1.equals(p4));

        // Figuring out how remove() works for arraylists:
        List<Point> points = new ArrayList<Point>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        System.out.println("List of points before removing: " + points);
        points.remove(new Point(1, 2));
        System.out.println("List of points after removing: " + points);
    }

    public static void testPersonEquals()
    {
        Person p1 = new Person("George", "Washington");
        Person p2 = new Person("George", "Washington");
        Person p3 = new Person("george", "washington");
        Person p4 = p1;

        System.out.println("Is p1 == p2? " + (p1 == p2));
        System.out.println("Is p1 == p3? " + (p1 == p3));
        System.out.println("Is p2 == p3? " + (p2 == p3));
        System.out.println("Is p1 == p4? " + (p1 == p4));

        System.out.println("Is p1 equal to p2? " + p1.equals(p2));
        System.out.println("Is p1 equal to p3? " + p1.equals(p3));
        System.out.println("Is p2 equal to p3? " + p2.equals(p3));
    }
}
