package lab11;

public class Fibonacci {
    public static long fib(int n)
    {
        if (n <= 2) {
            return 1;
        }
        else {
            return fib(n-1) + fib(n-2);
        }
    }

    public static long fastfib(int n)
    {
        long[] values = new long[n+1];
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) {
                values[i] = 1;
            }
            else {
                values[i] = values[i-1] + values[i-2];
            }
        }
        return values[n];
    }
}
