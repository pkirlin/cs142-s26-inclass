package lab8;

public class RecursiveFunctions {

    public static void main(String[] args) {
        // Test factorial
        testFactorial();

        // Test fibonacci
        testFibonacci();

        // Write more tests or calls here.
        // Feel free to comment out earlier calls.
    }

    /**
     * Function for testing the factorial function.
     */
    public static void testFactorial() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("i = " + i + ", fact(i) = " + fact(i));
        }
    }

    /**
     * Function for testing the fibonacci function.
     */
    public static void testFibonacci() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("i = " + i + ", fib(i) = " + fib(i));
        }
    }

    /**
     * Recursive factorial
     */
    public static long fact(int n) {
        if (n == 1) {
            return 1;
        } else {
            return fact(n - 1) * n;
        }
    }

    /**
     * Recursive fibonacci
     */
    public static long fib(int n) {
        if (n <= 1) {
            return 1;
        } else {
            long call1 = fib(n - 1);
            long call2 = fib(n - 2);
            return call1 + call2;
            // normally these 3 lines are compressed into this:
            // return fib(n-1) + fib(n-2);
            // but I've written it here with variables to make the recursion
            // diagram easier to draw/understand.
        }
    }

    /**
     * A funky function.
     */
    public static void funky(int n) {
        if (n == 0) {
            return;
        } else {
            funky(n - 1);
            System.out.println(n);
            funky(n - 1);
        }
    }

    /**
     * Returns the sum of the first n integers, starting from 1.
     */
    public static long sumOfFirstN(int n) {
        return 0; // remove this when you start writing
    }

    /**
     * Returns 2 to the nth power.
     */
    public static long twoToNthPower(int n) {
        return 0; // remove this when you start writing
    }


}
