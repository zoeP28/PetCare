import java.util.ArrayList;

public class BookingSystem {

    public static boolean checkAvailability(Vet vet, String desiredTime) {
        return vet.isAvailable(desiredTime);
    }

    static void initVets() {

        Vet.vets = new ArrayList<>();
        Vet vet1 = new Vet("Vet1",Location.Patras);
        Vet vet2 = new Vet("Vet2",Location.Athens);
        Vet vet3 = new Vet("Vet3",Location.Patras);

        vet1.setAppointmentAvailability("09:00", true);
        vet1.setAppointmentAvailability("10:00", true);
        vet2.setAppointmentAvailability("11:00", true);
        vet2.setAppointmentAvailability("14:00", true);
        vet3.setAppointmentAvailability("13:00", true);
        vet3.setAppointmentAvailability("18:00", true);

        Vet.vets.add(vet1);
        Vet.vets.add(vet2);
        Vet.vets.add(vet3);
    }
}
