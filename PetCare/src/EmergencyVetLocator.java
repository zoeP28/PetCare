import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class EmergencyVetLocator extends Vet {

    public EmergencyVetLocator(String name, Location location, String hoursOfOperation) {
        super(name, location, hoursOfOperation);
    }

    public static List<Vet> findEmergencyVets(User user) {
        List<Vet> emergencyVets = Vet.vets.stream()
                .filter(vet -> vet.getLocation().equals(user.getLocation()))
                .filter(EmergencyVetLocator::availableEmergencyVet)
                .toList();

        for (int i = 0; i < emergencyVets.size(); i++) {
            System.out.println((i + 1) + ". " + emergencyVets.get(i).getName());
        }
        return emergencyVets;
    }
}