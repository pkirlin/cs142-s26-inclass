package lab11;

public class ArraySumTimer extends CodeTimer {

    public double measureTimeOnOneSize(int inputSize) {
        // Create an array of random numbers.  The size of the array
        // is "inputSize" and the numbers range from 0 to maxNumber (10,000 here).
        int[] randomNums = RandomArrayMaker.makeRandomArray(inputSize, 10000);

        // Make a stopwatch and "start" it.
        Stopwatch watch = new Stopwatch();
        watch.start();

        // Between the watch start and stop, this code will be timed
        // for how long it takes to run.

        // You may need to modify the 1000000 here if the code runs too fast or too slow.
        for (int counter = 0; counter < 1000000; counter++) {  // for loop that runs the code inside 1,000,000 times

            // Code here is our normal algorithm to add up the numbers in an array.
            int sum = 0;
            for (int i = 0; i < randomNums.length; i++) {
                sum += randomNums[i];
            }

        }

        // Stop the watch and return the elapsed time.
        watch.stop();
        return watch.getElapsedTimeInSeconds();
    }
}
