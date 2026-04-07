package lab10;

import java.util.ArrayList;

public class ForEachDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayOfInts = new ArrayList<Integer>();
        arrayOfInts.add(2);
        arrayOfInts.add(4);
        arrayOfInts.add(6);

        // Old way, with manual indices:
        for (int i = 0; i < arrayOfInts.size(); i++) {  // i loops over the *indices* of arrayOfInts
            int thisInteger = arrayOfInts.get(i);
            System.out.println(thisInteger);
        }

        // New way, with for each loop:
        for (int thisInteger : arrayOfInts) {  // thisInteger loops over the *elements* inside arrayOfInts
            System.out.println(thisInteger);
        }

        /*
        The general syntax for this new kind of loop is:
        for (datatype variable : arraylistOfDatatype) {
            Do whatever you want with "variable", just as you would in a regular for loop.
        }

        Which means the same thing as:

        for (int i = 0; i < arraylistOfDatatype.size(); i++) {
            datatype variable = arraylistOfDatatype.get(i);
            Do whatever you want with "variable".
        }
        */
    }
}
