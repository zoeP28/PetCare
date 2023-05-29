
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


    public static List<Vet> displayVets() {
        System.out.println("Available Vets:");
        List<Vet> availableVets = vets.stream()
                .filter(vet -> vet.getLocation().getName().equals(Main.currentUser.getLocation().getName())).toList();

        for(int i = 0; i < availableVets.size(); i++) {
            System.out.println((i + 1) + ". " + availableVets.get(i).getName());
        }
        return availableVets;
    }


    public List<String> getAvailableAppointments() {
        return availableAppointments.entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    static void initVets() {

        vets = new ArrayList<>();
        Vet vet1 = new Vet("Vet1",Location.Patras);
        Vet vet2 = new Vet("Vet2",Location.Athens);
        Vet vet3 = new Vet("Vet3",Location.Patras);

        vet1.setAppointmentAvailability("09:00", true);
        vet1.setAppointmentAvailability("10:00", true);
        vet2.setAppointmentAvailability("11:00", true);
        vet2.setAppointmentAvailability("14:00", true);
        vet3.setAppointmentAvailability("13:00", true);
        vet3.setAppointmentAvailability("18:00", true);

        vets.add(vet1);
        vets.add(vet2);
        vets.add(vet3);
    }

}