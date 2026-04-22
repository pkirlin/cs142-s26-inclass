package lab11;

import java.util.Arrays;

public class BinarySearchTimer extends CodeTimer {

    @Override
    public double measureTimeOnOneSize(int inputSize) {
        int[] randomNums = RandomArrayMaker.makeRandomSortedArray(inputSize, 10000);

        Stopwatch watch = new Stopwatch();
        watch.start();
        for (int counter = 0; counter < 9000000; counter++) { // for loop that runs the code inside 9,000,000 times

            Arrays.binarySearch(randomNums, (int) (Math.random() * 10000));

        }
        watch.stop();
        return watch.getElapsedTimeInSeconds();
    }
}
