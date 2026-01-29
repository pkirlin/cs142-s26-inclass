package functions;

public class FunctionPractice {
    public static double distance(int x1, int y1, int x2, int y2) {
        // calculate Euclidean distance from (x1, y1) to (x2, y2)
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static int sumRange(int lower, int upper) {
        // write code to calculate the sum of all the numbers
        // between lower and upper.  Return the answer.
        int sum = 0;
        for (int count = lower; count <= upper; count++) {
            sum = sum + count;
        }
        return sum;
    }

    public static double totalDistance(int[] points) {
        double sum = 0;
        for (int i = 0; i < points.length-3; i += 2) {
            sum = sum + distance(points[i], points[i+1], points[i+2], points[i+3]);
        }
        return sum;
    }

    public static void main(String[] args) {
        // Write code here to test each function:

        System.out.println("Testing distance:");
        System.out.println(distance(1, 2, 3, 4)); // should be about 2.828
        System.out.println(distance(3, 7, -5, 1));  // should be 10.0
        System.out.println("Testing sumRange:");
        System.out.println(sumRange(1, 9));
        System.out.println(sumRange(1, 100));
        System.out.println("Testing totalDistance:");

        // Here is an array you can use for the totalDistance() function:
        int[] array = new int[] { 1, 2, 3, -4, -3, 0 };
        System.out.println(totalDistance(array));
    }
}
