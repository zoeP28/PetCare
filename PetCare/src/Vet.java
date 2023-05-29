
import java.util.*;
import java.util.stream.Collectors;
import java.util.Map;

public class Vet {
    private String name;
    private Location location;


    private Map<String, Boolean> availableAppointments;
    static List<Vet> vets;


    public Vet(String name ,Location location) {
        this.name = name;
        this.location = location;
        this.availableAppointments = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setAppointmentAvailability(String appointmentTime, boolean isAvailable) {
        this.availableAppointments.put(appointmentTime, isAvailable);
    }


    public boolean isAvailable(String appointmentTime) {
        return availableAppointments.getOrDefault(appointmentTime, false);
    }

    public void bookAppointment(String appointmentTime) {
        this.availableAppointments.put(appointmentTime, false);
    }

}