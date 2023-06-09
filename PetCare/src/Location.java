public class Location {

    private String name;
    private double latitude;
    private final double longitude;

    static Location Patras = new Location("Patras");
    static Location Athens = new Location("Athens");


    public Location(String name) {
        this.name = name;
        this.latitude = 0.0;
        this.longitude = 0.0;
    }

    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public  double getLatitude() {
        return latitude;
    }

    public  double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }
}
