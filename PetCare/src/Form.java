import java.util.ArrayList;
import java.util.Scanner;

public abstract class Form {

    protected LostAndFoundPet pet;
    protected String contactInfo;

    protected void setDetails(LostAndFoundPet pet, String contactInfo) {
        this.pet = pet;
        this.contactInfo = contactInfo;
    }


    public LostAndFoundPet getPet() {
        return pet;
    }

    public String getContactInfo() {
        return contactInfo;
    }


    public abstract boolean validateDetails();
    public abstract Post createPost();
    public Form() {
    }
    static Pet petForm() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter pet name: ");
        String name = scanner.nextLine();

        System.out.print("Enter pet age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        System.out.print("Enter pet breed: ");
        String breed = scanner.nextLine();

        ArrayList<String> vaccinations = new ArrayList<>();
        ArrayList<String> medications = new ArrayList<>();
        ArrayList<String> allergies = new ArrayList<>();
        ArrayList<String> surgicalProcedures = new ArrayList<>();

        String input;

        do {
            System.out.print("\nEnter any vaccinations (Press enter & write 'done' when finished) ");
            System.out.println("\n(e.g. Rabies, Canine Distemper, Feline Leukemia):");

            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("done")) {
                vaccinations.add(input);
            }
        } while (!input.equalsIgnoreCase("done"));


        do {
            System.out.print("\nEnter any medications (Press enter & write 'done' when finished) ");
            System.out.println("\n(e.g. Heartworm, Non steroidal Anti-inflammatory Drugs, Antibiotics):");

            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("done")) {
                medications.add(input);
            }
        } while (!input.equalsIgnoreCase("done"));


        do {
            System.out.print("\nEnter any allergies (Press enter & write 'done' when finished)");
            System.out.println("\n(e.g. Beef, Dairy, Wheat, Chicken):");

            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("done")) {
                allergies.add(input);
            }
        } while (!input.equalsIgnoreCase("done"));


        do {
            System.out.print("\nEnter any surgical procedures (Press enter & write 'done' when finished) ");
            System.out.println("\n(e.g. Spaying or Neutering, Orthopedic, Tumor Removal):");

            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("done")) {
                surgicalProcedures.add(input);
            }
        } while (!input.equalsIgnoreCase("done"));

        HealthRecord healthRecord = new HealthRecord(vaccinations, medications, allergies, surgicalProcedures);

        return new Pet(name, age, breed, healthRecord);
    }
}
