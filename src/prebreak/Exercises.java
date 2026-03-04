package prebreak;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercises {

    public static void main(String[] args) {
        // Test noDuplicates:
        ArrayList<Integer> intList = new ArrayList<Integer>();
        ArrayList<String> stringList = new ArrayList<String>();
        intList.add(10);
        intList.add(20);
        intList.add(10);
        intList.add(30);
        intList.add(30);
        intList.add(10);
        intList.add(20);
        intList.add(5);
        System.out.println("ArrayList with duplicates: " + intList);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }



        ArrayList<Integer> noDupes = noDuplicates(intList);
        System.out.println("ArrayList with duplicates: " + noDupes);

        // Test reverseString:
        String s = "abcde";
        String reversed = reverseString(s);
        System.out.println("reversed string is " + reversed);

    }

    public static ArrayList<Integer> noDuplicates(ArrayList<Integer> list) {
        return null;
    }

    public static String reverseString(String str) {
        return "";
    }

    public static ArrayList<String> wordsContainingEveryVowel() {
        return null;
    }

    public static ArrayList<String> wordsContainingEveryVowelExactlyOnce() {
        return null;
    }

    public static ArrayList<String> lettersInAlphaOrder() {
        return null;
    }

    public static ArrayList<String> findPalindromes() {
        return null;
    }

    public static ArrayList<String> readWords() {
        InputStream is = Exercises.class.getResourceAsStream("words.txt");
        if (is == null) {
            System.err.println("Could not open file: words.txt");
            System.exit(1);
        }
        Scanner scan = new Scanner(is);

        ArrayList<String> answer = new ArrayList<>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            answer.add(line);
        }

        return answer;
    }
}