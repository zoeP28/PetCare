import java.util.ArrayList;
import java.util.Scanner;

public class FoundPetReport extends Form {


    public FoundPetReport(LostAndFoundPet pet, String contactInfo) {
        super();
        setDetails(pet, contactInfo);
        pet.setStatus("Found");
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
        Post post = new Post(this.getPet(), "Found", this.getContactInfo());
        return post;
    }


    public static LostAndFoundPet fillFoundPetForm(Scanner scanner, ArrayList<LostAndFoundPet> lostPets) {
        System.out.print("Please fill in the following details:\n");
        System.out.print("Enter pet's name: ");
        String name = scanner.next();
        scanner.nextLine(); // consume the leftover newline
        System.out.print("Enter location found: ");
        String lastSeenLocation = scanner.nextLine();
        System.out.print("Enter description of pet: ");
        String description = scanner.nextLine();
        System.out.print("Enter date pet was found: ");
        String dateLostOrFound = scanner.nextLine();

        // Check if pet is in lostPets list
        for (LostAndFoundPet lostPet : lostPets) {
            if (description.contains(lostPet.getName())) {
                lostPet.setStatus("Found");
                return lostPet;
            }
        }

        HealthRecord healthRecord = new HealthRecord("","","",""); // Empty health record
        return new LostAndFoundPet(name, 0, "Unknown", healthRecord, lastSeenLocation, description, dateLostOrFound, "Found");
    }

}
