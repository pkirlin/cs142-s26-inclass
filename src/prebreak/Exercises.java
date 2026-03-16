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

        System.out.println(wordsContainingEveryVowel());

    }

    public static ArrayList<Integer> noDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> newArrayList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (!newArrayList.contains(list.get(i))) {
                newArrayList.add(list.get(i));
            }
            //if (newArrayList.indexOf(list.get(i)) == -1) {
            //    newArrayList.add(list.get(i));
            //}
        }
        return newArrayList;
    }

    public static String reverseString(String str) {
        String answer = "";
        //for (int i = str.length() - 1; i >= 0; i--) {
        //    answer += str.charAt(i);
        //}
        for (int i = 0; i < str.length(); i++) {
            answer = str.charAt(i) + answer;
        }
        return answer;
    }

    public static ArrayList<String> wordsContainingEveryVowel() {
        ArrayList<String> dictionary = readWords();
        ArrayList<String> answerList = new ArrayList<String>();
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).contains("a") &&
                    dictionary.get(i).contains("e") &&
                    dictionary.get(i).contains("i") &&
                    dictionary.get(i).contains("o") &&
                    dictionary.get(i).contains("u")) {
                answerList.add(dictionary.get(i));
            }
        }
        return answerList;
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