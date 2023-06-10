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

    public static void displayClinicInfo(Vet vet) {
        GoogleMaps.getDirections(vet);
        System.out.println("Hours of operation: " + vet.getHoursOfOperation());
    }


    public static List<Vet> expandSearchMethod() {
        System.out.println("Expanding search to all locations...");

        List<Vet> emergencyVets = Vet.vets.stream()
                .filter(EmergencyVetLocator::availableEmergencyVet)
                .collect(Collectors.toList());

        for (int i = 0; i < emergencyVets.size(); i++) {
            System.out.println((i + 1) + ". " + emergencyVets.get(i).getName());
        }
        return emergencyVets;
    }

    public static boolean availableEmergencyVet(Vet vet) {
        LocalTime now = LocalTime.now();
        LocalTime openTime = LocalTime.parse(vet.getHoursOfOperation().split("-")[0].trim());
        LocalTime closeTime = LocalTime.parse(vet.getHoursOfOperation().split("-")[1].trim());
        return !now.isBefore(openTime) && !now.isAfter(closeTime);
    }


    static void locateEmergencyVet() {
        String answer = ConfirmationMessage.promptForLocation();
        if (answer.equalsIgnoreCase("No")) {
            User.typeLocationManually();
        }

        List<Vet> nearbyVets = EmergencyVetLocator.findEmergencyVets(Main.currentUser);

        if (nearbyVets.isEmpty()) {
            System.out.println("\nNo clinic available in the area. Expanding search...");
            List<Vet> emergencyVets = EmergencyVetLocator.expandSearchMethod();
            Vet selectedVet = User.selectVetLocator(emergencyVets);
            EmergencyVetLocator.displayClinicInfo(selectedVet);

        } else {
            Vet selectedVet = User.selectVetLocator(nearbyVets);
            EmergencyVetLocator.displayClinicInfo(selectedVet);

        }
    }


}