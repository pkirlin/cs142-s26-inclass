package lab10;

public class Car {
    protected int topSpeed, currentSpeed;
    protected double totalDistanceTraveled;

    public Car(int newTopSpeed) {
        topSpeed = newTopSpeed;
        currentSpeed = 0;
        totalDistanceTraveled = 0;
    }

    public double getDistance() {
        return totalDistanceTraveled;
    }

    /**
     * Drive the car for one second of time.
     */
    public void drive() {
        if (currentSpeed + 5 <= topSpeed) {
            currentSpeed += 5;
        }

        System.out.println("Driving regular car at " + currentSpeed + " mph.");

        // 1 mph = 0.0002777 miles per second
        totalDistanceTraveled += currentSpeed * 0.0002777;
    }
}
