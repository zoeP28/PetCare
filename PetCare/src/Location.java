public class Location {

    private String name;
    static Location Patras = new Location("Patras");
    static Location Athens = new Location("Athens");


    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
