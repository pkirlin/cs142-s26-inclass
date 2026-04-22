package lab11;

public class Stopwatch {
    private long startTime = 0;
    private long stopTime = 0;

    public void start() {
        // can only be started if both times are zero
        if (startTime == 0 && stopTime == 0) {
            startTime = System.currentTimeMillis();
        } else {
            System.err.println("Can't start watch; must reset first.");
            System.exit(1);
        }
    }

    public void stop() {
        // can only be stopped if start time > 0 and stop time == 0
        if (startTime > 0 && stopTime == 0) {
            stopTime = System.currentTimeMillis();
        } else {
            System.err.println("Can't stop watch; must first start it, or reset and start.");
            System.exit(1);
        }
    }

    public void reset() {
        stopTime = 0;
        startTime = 0;
    }

    public double getElapsedTimeInSeconds() {
        return (stopTime - startTime) / 1000.0;
    }
}
