import java.util.List;
import java.util.Scanner;

public class Appointment {
    private Vet vet;
    private String time;

    public Appointment(Vet vet, String time) {
        this.vet = vet;
        this.time = time;
    }

    public Vet getVet() {
        return vet;
    }
    public String getTime() {
        return time;
    }

    @Override
    public String toString() {

        //return "Appointment with " + vet.getName() + " at " + time;
        return "Appointment with " + getVet().getName() + " at " + getTime();
    }
    static void createAppointment(Scanner scanner) {

        System.out.println("Select Vet:");

        List<Vet> availableVets = Vet.displayVets();

        System.out.print("Enter Vet number: ");
        int vetIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Vet vet = availableVets.get(vetIndex);

        System.out.print("Enter desired appointment time (HH:MM): ");
        String desiredTime = scanner.nextLine();
        boolean isAvailable = BookingSystem.checkAvailability(vet, desiredTime);

        String appointmentTime;