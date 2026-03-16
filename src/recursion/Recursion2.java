package recursion;

public class Recursion2 {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            long factAnswer = fact(i);
            System.out.println("The factorial of " + i + " is " + factAnswer);
        }
        for (int i = 1; i <= 10; i++) {
            long factAnswer = factRec(i);
            System.out.println("The factorial of " + i + " is " + factAnswer);
        }

        // Test iterative string reverse:
        System.out.println("Iterative string reverse: " + reverse("abcde"));

        // Test recursive string reverse:
        System.out.println("Recursive string reverse: " + reverseRec("abcde"));
    }

    /**
     * Factorial, iterative version
     */
    public static long fact(int num) {
        long answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }
        return answer;
    }

    /**
     * Factorial, recursive version.
     * Recursive formulation:
     * BASE CASE: If n == 1, fact(1) = 1
     * RECURSIVE CASE: If n >= 2, fact(n) = fact(n-1) * n
     */
    public static long factRec(int num) {
        if (num == 1) {  // base case
            return 1;
        } else {  // recursive case
            long smallerAnswer = factRec(num - 1);
            return smallerAnswer * num;
            // two lines above often combined: return factRec(num-1) * num;
        }
    }

    /**
     * Reverse a string, iterative version
     */
    public static String reverse(String str) {
        String answer = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            answer = answer + str.charAt(i);
        }
        return answer;
    }

    /**
     * Reverse a string, recursive version.
     * Recursive formulation:
     * BASE CASE:
     * RECURSIVE CASE:
     */
    public static String reverseRec(String str) {
        return ""; // remove this when you start coding
    }

    /**
     * What does this function do?
     */
    public static void weird(int n) {
        if (n == 0) {
            return;
        } else {
            System.out.println(n);
            weird(n - 1);
        }
    }

    /**
     * Fibonacci sequence.
     */
    public static int fib(int n) {
        return 0; // remove this
    }
}