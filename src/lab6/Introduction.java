package lab6;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Introduction {
    public static void main(String[] args) {
        arrayListDemo();
        //fileReadingDemo();
        //fileReadingDemo2();
    }

    public static void arrayListDemo() {
        // make a new ArrayList
        ArrayList<Integer> listOfInts = new ArrayList<Integer>(); // can also write with the <>'s empty

        // add some integers --- just like .append() in Python, adds to the end of the list
        listOfInts.add(2);
        listOfInts.add(4);
        listOfInts.add(6);

        // print the ArrayList (easier than printing an array!)
        System.out.println(listOfInts);

        // iterate over an ArrayList --- very similar to iterating over a regular array
        for (int i = 0; i < listOfInts.size(); i++) {
            // get(i) is like using square brackets [i] in a regular array
            int itemInTheList = listOfInts.get(i);
            System.out.println("Index " + i + " contains: " + itemInTheList);
        }
    }

    public static void fileReadingDemo() {
        InputStream is = Introduction.class.getResourceAsStream("sample.txt");
        if (is == null) {
            System.err.println("Could not open file: sample.txt");
            System.exit(1);
        }
        Scanner scan = new Scanner(is);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            System.out.println("Just read line: " + line);
            int i = Integer.parseInt(line);
            System.out.println("This is the integer: " + i);
        }
    }

    public static void fileReadingDemo2() {
        InputStream is = Introduction.class.getResourceAsStream("sample2.txt");
        if (is == null) {
            System.err.println("Could not open file: sample2.txt");
            System.exit(1);
        }
        Scanner scan = new Scanner(is);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            System.out.println("Just read line: " + line);
            String[] pieces = line.split(",");
            String last = pieces[0];
            String first = pieces[1];
            int i = Integer.parseInt(pieces[2]);
            System.out.println(first + " " + last + " scored a " + i);
        }
    }
}
