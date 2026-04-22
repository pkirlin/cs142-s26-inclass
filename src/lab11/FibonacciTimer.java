package lab11;

public class FibonacciTimer extends CodeTimer {
    @Override
    public double measureTimeOnOneSize(int inputSize) {

        Stopwatch watch = new Stopwatch();
        watch.start();

        // You may need to modify the 100000 if it's too fast or too slow.
        for (int counter = 0; counter < 100000; counter++) { // for loop that runs the code inside many times

            Fibonacci.fib(inputSize);

        }

        watch.stop();
        return watch.getElapsedTimeInSeconds();
    }
}
