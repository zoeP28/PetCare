import java.util.Scanner;

public class LostPetReport extends Form {
    public LostPetReport(LostAndFoundPet pet, String contactInfo) {
        super();
        setDetails(pet, contactInfo);
        pet.setStatus("Lost");
    }

    @Override
    public boolean validateDetails() {
        if (getPet().getName().isEmpty() || getContactInfo().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Post createPost() {
        if (!validateDetails()) {
            System.out.println("Validation failed. Please fill out all required fields.");
            return null;
        }
        Post post = new Post(this.getPet(), "Lost", this.getContactInfo());
        return post;
    }
    public static LostAndFoundPet fillLostPetForm(Scanner scanner) {
        System.out.print("Please fill in the following details:\n");
        System.out.print("Enter pet's name: ");
        String name = scanner.next();
        System.out.print("Enter pet's age: ");
        int age = scanner.nextInt();
        System.out.print("Enter pet's breed: ");
        String breed = scanner.next();
        System.out.print("Enter location last seen: ");
        String lastSeenLocation = scanner.nextLine();
        System.out.print("Enter description of pet: ");
        String description = scanner.nextLine();
        System.out.print("Enter date pet was lost: ");
        String dateLostOrFound = scanner.next();

        HealthRecord healthRecord = new HealthRecord("","","",""); // Empty health record
        return new LostAndFoundPet(name, age, breed, healthRecord, lastSeenLocation, description, dateLostOrFound, "Lost");
    }

    public static String fillContactInfo(Scanner scanner) {
        System.out.println("Enter your contact info: ");
        return scanner.next();
    }




}
