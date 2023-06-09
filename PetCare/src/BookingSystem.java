import java.util.ArrayList;

public class BookingSystem {

    public static boolean checkAvailability(Vet vet, String desiredTime) {
        return vet.isAvailable(desiredTime);
    }

    static void initVets() {

        Vet.vets = new ArrayList<>();
        Vet vet1 = new Vet("Vet1",Location.Patras,"09:00 - 18:00");
        Vet vet2 = new Vet("Vet2",Location.Athens,"10:00 - 19:00");
        Vet vet3 = new Vet("Vet3",Location.Patras,"14:00 - 17:00");

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
