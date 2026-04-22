package lab11;

public class FibonacciTest {
    public static void main(String[] args)
    {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Fibonacci of " + i + ": " + Fibonacci.fib(i));
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println("Fast Fibonacci of " + i + ": " + Fibonacci.fastfib(i));
        }
    }
}
