package lab11;

import java.util.List;

public class CodeTimerDemos {
    public static void main(String[] args)
    {
        measureSumOfArray();

        //measureSumOf2DArray();

        //measureFibonacci();

        //measureBinarySearch();
    }

    public static void measureSumOfArray() {
        CodeTimer timer = new ArraySumTimer();
        timer.measureTimeOnAllSizes(List.of(1000, 2000, 4000, 8000, 16000, 32000, 64000));
    }

    public static void measureSumOf2DArray() {
        CodeTimer timer = new Array2DSumTimer();
        timer.measureTimeOnAllSizes(List.of(100, 200, 400, 800, 1600, 3200, 6400));
    }

    public static void measureFibonacci() {
        CodeTimer timer = new FibonacciTimer();
        timer.measureTimeOnAllSizes(List.of(5, 10, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25));
    }

    public static void measureBinarySearch() {
        CodeTimer timer = new BinarySearchTimer();
        timer.measureTimeOnAllSizes(List.of(1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 256000, 512000, 1024000));
    }
}
