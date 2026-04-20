package interfaces1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingDemo {
    public static void main(String[] args)
    {
        ArrayList<Integer> someInts = new ArrayList<Integer>(List.of(6, 4, 7, 5, 3, 1, 2, 9, 8, 0));
        System.out.println(someInts);
        Collections.sort(someInts);
        System.out.println(someInts);

        ArrayList<Double> someDoubles = new ArrayList<Double>(List.of(8.7, 4.2, 3.5, 7.8, 4.3, 2.1, 6.7, 5.4));
        System.out.println(someDoubles);
        Collections.sort(someDoubles);
        System.out.println(someDoubles);

        ArrayList<Fraction> someFractions = new ArrayList<Fraction>();
        someFractions.add(new Fraction(2, 3)); //   2/3
        someFractions.add(new Fraction(1, 4)); //   1/4
        someFractions.add(new Fraction(7, 6)); //   7/6
        someFractions.add(new Fraction(5, 9)); //   5/9
        someFractions.add(new Fraction(3, 4)); //   3/4

        System.out.println(someFractions);
        //Collections.sort(someFractions);
        System.out.println(someFractions);
    }
}
