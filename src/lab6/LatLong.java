/**
 * This class holds a geographical coordinate in latitude/longitude.
 *
 * This is one of the few cases where I think it's ok to have public
 * instance variables, since it's very clear what they mean and there's
 * no harm in making them public.
 */

package lab6;

public class LatLong {
    public double latitude, longitude;

    public LatLong(double lat, double lon) {
        latitude = lat;
        longitude = lon;
    }

    public String toString() {
        return "(" + "lat=" + latitude + ", lon=" + longitude + ")";
    }
}
