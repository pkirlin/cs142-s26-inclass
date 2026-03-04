package lab6;

/**
 * A RoadSegment represents a straight-line segment of a road, street, highway, or anything
 * a car can drive on.  A true "road" may consist of many of these straight-line segments.
 */
public class RoadSegment {
    private LatLong start; // location where the road starts
    private LatLong end;   // location where the road ends
    private int speedLimit; // speed limit of the road
    private String name; // name of the road

    public RoadSegment(LatLong start, LatLong end, int speedLimit, String name) {
        this.start = start;
        this.end = end;
        this.speedLimit = speedLimit;
        this.name = name;
    }

    public LatLong getStart() {
        return start;
    }

    public LatLong getEnd() {
        return end;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RoadSegment{" + "start=" + start + ", end=" + end + ", speedLimit=" + speedLimit +
                ", name='" + name + '\'' + '}';
    }
}
