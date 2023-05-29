import java.util.ArrayList;
import java.util.Scanner;

public class Form {

    static Pet fillForm() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter pet name: ");
        String name = scanner.nextLine();

        System.out.println("Enter pet age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        System.out.println("Enter pet breed: ");
        String breed = scanner.nextLine();

        ArrayList<String> vaccinations = new ArrayList<>();
        ArrayList<String> medications = new ArrayList<>();
        ArrayList<String> allergies = new ArrayList<>();
        ArrayList<String> surgicalProcedures = new ArrayList<>();

        String input;

        do {
            System.out.println("Enter any vaccinations (enter 'done' when finished): ");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("done")) {
                vaccinations.add(input);
            }
        } while (!input.equalsIgnoreCase("done"));


        do {
            System.out.println("Enter any medications (enter 'done' when finished): ");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("done")) {
                medications.add(input);
            }
        } while (!input.equalsIgnoreCase("done"));


        do {
            System.out.println("Enter any allergies (enter 'done' when finished): ");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("done")) {
                allergies.add(input);
            }
        } while (!input.equalsIgnoreCase("done"));


        do {
            System.out.println("Enter any surgical procedures (enter 'done' when finished): ");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("done")) {
                surgicalProcedures.add(input);
            }
        } while (!input.equalsIgnoreCase("done"));

        HealthRecord healthRecord = new HealthRecord(vaccinations, medications, allergies, surgicalProcedures);

        return new Pet(name, age, breed, healthRecord);
    }
}