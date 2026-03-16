package lab6;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MemphisMap {
    double minLat, maxLat, minLong, maxLong; // max/min boundaries of latitude & longitude
    private SimpleCanvas canvas;  // the canvas to draw on
    private ArrayList<RoadSegment> listOfRoadSegs;  // list of all road segments we will draw

    public MemphisMap(SimpleCanvas c) {
        canvas = c;
        listOfRoadSegs = new ArrayList<>();

        loadRoadSegs();
    }

    /**
     * Calculate the distance between two points in lat/long coordinates.
     */
    public static double distanceBetweenLatLongs(LatLong l1, LatLong l2) {
        // Based on https://stackoverflow.com/questions/27928/calculate-distance-between-two-latitude-longitude-points-haversine-formula
        double lat1 = l1.latitude;
        double lat2 = l2.latitude;
        double lon1 = l1.longitude;
        double lon2 = l2.longitude;
        if (lat1 == lat2 && lon1 == lon2) return 0;

        double R = 3958.8; // Radius of the earth in miles
        double dLat = deg2rad(lat2 - lat1);  // deg2rad below
        double dLon = deg2rad(lon2 - lon1);
        double a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c; // Distance in miles
        return d;
    }

    /**
     * Helper method: convert degrees to radians.
     */
    private static double deg2rad(double deg) {
        return deg * (Math.PI / 180);
    }

    /**
     * Convert lat/long coordinates to x/y coordinates.
     */
    public int[] convertLatLongToXY(LatLong latlong) {
        // Remember x corresponds to longitude, y corresponds to latitude
        int maxX = canvas.getWidth();
        int maxY = canvas.getHeight();

        double latDiff = maxLat - minLat;
        double longDiff = maxLong - minLong;

        // convert longitude:
        int newX = (int) (((latlong.longitude - minLong) / longDiff) * maxX);
        // convert latitude (backwards b/c we have to "reverse" the y axis)
        int newY = (int) (((maxLat - latlong.latitude) / latDiff) * maxY);
        return new int[]{newX, newY};
    }

    /**
     * Convert x/y coordinates to lat/long coordinates.
     */
    public LatLong convertXYToLatLong(int x, int y) {
        // Remember x corresponds to longitude, y corresponds to latitude
        int maxX = canvas.getWidth();
        int maxY = canvas.getHeight();
        double latDiff = maxLat - minLat;
        double longDiff = maxLong - minLong;

        // convert x:
        double lon = (x / (double) maxX) * longDiff + minLong;
        // convert y:
        double lat = maxLat - (y / (double) maxY) * latDiff;
        return new LatLong(lat, lon);
    }

    /**
     * Helper method: Used to find the max/minn lat/long coordinates so
     * we know where to draw them on the canvas.
     */
    private void setMinsAndMaxes() {
        double currMinLat = 1000;  // bigger than any latitude
        double currMaxLat = -1000; // smaller than any latitude
        double currMinLong = 1000;  // bigger than any longitude
        double currMaxLong = -1000; // smaller than any longitude
        for (int i = 0; i < listOfRoadSegs.size(); i++) {
            RoadSegment roadSeg = listOfRoadSegs.get(i);
            LatLong start = roadSeg.getStart();
            LatLong end = roadSeg.getEnd();
            // update max lat, long
            if (start.latitude > currMaxLat) {
                currMaxLat = start.latitude;
            }
            if (end.latitude > currMaxLat) {
                currMaxLat = end.latitude;
            }
            if (start.longitude > currMaxLong) {
                currMaxLong = start.longitude;
            }
            if (end.longitude > currMaxLong) {
                currMaxLong = end.longitude;
            }
            // update min lat, long
            if (start.latitude < currMinLat) {
                currMinLat = start.latitude;
            }
            if (end.latitude < currMinLat) {
                currMinLat = end.latitude;
            }
            if (start.longitude < currMinLong) {
                currMinLong = start.longitude;
            }
            if (end.longitude < currMinLong) {
                currMinLong = end.longitude;
            }
        }
        minLat = currMinLat;
        maxLat = currMaxLat;
        minLong = currMinLong;
        maxLong = currMaxLong;
    }

    /**
     * Draw the map on the canvas.
     */
    public void draw() {
        canvas.clear();

        // draw roads
        for (int i = 0; i < listOfRoadSegs.size(); i++) {
            RoadSegment roadSeg = listOfRoadSegs.get(i);
            LatLong start = roadSeg.getStart();
            LatLong end = roadSeg.getEnd();
            int[] point1 = convertLatLongToXY(start);
            int[] point2 = convertLatLongToXY(end);
            canvas.drawLine(point1[0], point1[1], point2[0], point2[1]);
            //System.out.println(roadSeg);  // used for debugging
        }

        // draw parks here

        canvas.update();
    }

    /**
     * Read in all the roads from a file.
     */
    private void loadRoadSegs() {
        InputStream is = MemphisMap.class.getResourceAsStream("memphis-roads.txt");
        if (is == null) {
            System.err.println("Bad filename: " + "memphis-roads.txt");
            System.exit(1);
        }
        Scanner scan = new Scanner(is);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] pieces = line.split("/");

            double lat1 = Double.parseDouble(pieces[1]);
            double long1 = Double.parseDouble(pieces[2]);
            double lat2 = Double.parseDouble(pieces[3]);
            double long2 = Double.parseDouble(pieces[4]);
            int speedLimit = Integer.parseInt(pieces[5]);
            String nameOfRoad = pieces[6];

            LatLong roadStart = new LatLong(lat1, long1);
            LatLong roadEnd = new LatLong(lat2, long2);
            RoadSegment roadSeg = new RoadSegment(roadStart, roadEnd, speedLimit, nameOfRoad);
            listOfRoadSegs.add(roadSeg);
        }
        setMinsAndMaxes();
    }

    /**
     * Read in all the parks from a file.
     */
    public void loadParks() {

    }
}
