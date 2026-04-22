package lab11;

import java.util.List;

public abstract class CodeTimer {

    public void measureTimeOnAllSizes(List<Integer> inputSizes) {
        for (int inputSize : inputSizes) {
            double elapsedTime = measureTimeOnOneSize(inputSize);
            System.out.println("input size: " + inputSize + ", elapsed time: " + elapsedTime);
        }
    }

    public abstract double measureTimeOnOneSize(int inputSize);

}
