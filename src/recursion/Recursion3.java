package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion3 {
    public static void main(String[] args) {
        // test reversing a string:
        String s = "abc";
        System.out.println("first test: " + reverse(s));
        System.out.println("second test: " + reverse2(s));

        // test sum of arraylist:
        ArrayList<Integer> mylist = new ArrayList<>(List.of(2, 4, 6));
        System.out.println("Sum is " + sumOfArrayList(mylist));

        // test max of arraylist:
        ArrayList<Integer> mylist2 = new ArrayList<>(List.of(5, 7, 2, 3));
        System.out.println("Sum is " + maxOfArrayList(mylist2));

    }

    /**
     * Reverse a string, recursive version.
     * Recursive formulation:
     * BASE CASE: If string length is 1, return the string.
     * RECURSIVE CASE: If string length is > 1, then:
     *   firstChar = first character in string
     *   restOfChars = rest of characters in string
     *   answer = reverse2(restOfChars) + firstChar
     *   return answer
     */
    public static String reverse(String str) {
        if (str.length() == 1) {
            return str;
        } else {
            char lastChar = str.charAt(str.length()-1);
            String firstCharacters = str.substring(0, str.length()-1);
            String answer = lastChar + reverse(firstCharacters);
            return answer;
        }
    }

    /**
     * Reverse a string, recursive version.
     * Recursive formulation:
     * BASE CASE: If string length is 1, return the string.
     * RECURSIVE CASE: If string length is > 1, then:
     *   firstChar = first character in string
     *   restOfChars = rest of characters in string
     *   answer = reverse2(restOfChars) + firstChar
     *   return answer
     */
    public static String reverse2(String str) {
        if (str.length() == 1) {
            return str;
        } else {
            char firstChar = str.charAt(0);
            String restOfChars = str.substring(1);
            String answer = reverse2(restOfChars) + firstChar;
            return answer;
        }
    }

    // Calculate the sum of all the elements in an arraylist.
    public static int sumOfArrayList(ArrayList<Integer> list) {
        return sumOfArrayList(list, 0);
    }

    // Helper function for above.
    private static int sumOfArrayList(ArrayList<Integer> list, int leftIdx) {
        return 0;
    }

    // Calculate the largest element in an arraylist.
    public static int maxOfArrayList(ArrayList<Integer> list) {
        return 0;
    }

    // Helper function for above.
    private static int maxOfArrayList(ArrayList<Integer> list, int leftIdx) {
        return 0;
    }

}