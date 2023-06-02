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
    static void createAppointment() {

        System.out.println("\nSelect Vet Location: " + Main.currentUser.getLocation().getName());

        List<Vet> availableVets = Vet.displayVets();

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter Vet number: ");
        int vetIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Vet vet = availableVets.get(vetIndex);

        System.out.print("Enter desired appointment time (HH:MM): ");
        String desiredTime = scanner.nextLine();
        boolean isAvailable = BookingSystem.checkAvailability(vet, desiredTime);

        String appointmentTime;

        if (isAvailable) {
            appointmentTime = desiredTime;
        }

        else {

            System.out.println("Desired appointment time is not available. Please select from available times:");
            List<String> availableAppointments = vet.getAvailableAppointments();

            if(availableAppointments.isEmpty()) {
                System.out.println("Sorry, this vet has no available appointments.");
                return;
            }

            for(int i = 0; i < availableAppointments.size(); i++) {
                System.out.println((i + 1) + ". " + availableAppointments.get(i));
            }

            System.out.print("Enter Appointment number: ");
            int appointmentIndex = Integer.parseInt(scanner.nextLine()) - 1;
            appointmentTime = availableAppointments.get(appointmentIndex);

        }

        // Add confirmation before booking the appointment
        boolean confirm = ConfirmationMessage.showConfirmationMessage("You've selected an appointment with " + vet.getName() + " at " + appointmentTime);

        if(!confirm) {
            System.out.println("Appointment booking cancelled.");
            return;
        }

        vet.bookAppointment(appointmentTime);
        Appointment appointment = new Appointment(vet, appointmentTime);

        Main.currentUser.addAppointment(appointment);
        System.out.println("Appointment booked successfully with " + vet.getName() + " at " + appointmentTime);
    }
}
