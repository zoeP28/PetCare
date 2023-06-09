import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LostAndFoundPet extends Pet {
    private String description;
    private String dateLostOrFound;
    private String status;

    static List<LostAndFoundPet> lostPets = new ArrayList<>();


    public LostAndFoundPet(String name, int age,String breed,HealthRecord healthRecord, String lastSeenLocation,
                           String description, String dateLostOrFound, String status) {
        super(name, age, breed, healthRecord);
        this.description = description;
        this.dateLostOrFound = dateLostOrFound;
        this.status = status;
        setLastSeenLocation(lastSeenLocation);
    }

    public String getDescription() {
        return description;
    }

    public String getDateLostOrFound() {
        return dateLostOrFound;
    }

    public static String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    static void initLostPets() {
        LostAndFoundPet pet1 = new LostAndFoundPet("Bobby", 3, "Golden Retriever", null,
                "Park", "Bobby is a friendly dog.", "June 1, 2023", "Lost");
        LostAndFoundPet pet2 = new LostAndFoundPet("Kitty", 2, "Persian Cat", null,
                "Backyard", "Kitty is a fluffy cat.", "June 2, 2023", "Lost");
        lostPets.add(pet1);
        lostPets.add(pet2);
    }


    private static LostAndFoundPet selectLostPet(Scanner scanner) {
        for (int i = 0; i < lostPets.size(); i++) {
            System.out.println((i + 1) + ". " + lostPets.get(i));
        }
        int petIndex = scanner.nextInt() - 1;
        return lostPets.get(petIndex);
    }
}
