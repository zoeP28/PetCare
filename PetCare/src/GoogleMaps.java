import java.io.IOException;

public class GoogleMaps {

    public static void getDirections(Vet vet) {
        System.out.println("Clinic Name: " + vet.getName());
        System.out.println("Location: " + vet.getLocation().getName());
        System.out.println("Latitude: " +  vet.getLocation().getLatitude());
        System.out.println("Longitude: " +  vet.getLocation().getLongitude());
        System.out.println("Opening Google Maps...");
    }
}

