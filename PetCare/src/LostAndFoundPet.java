public class LostAndFoundPet extends Pet {
    private String description;
    private String dateLostOrFound;
    private String status; // "Lost" or "Found"

    public LostAndFoundPet(String name, int age, String breed, HealthRecord healthRecord, String lastSeenLocation,
                           String description, String dateLostOrFound, String status) {
        super(name, age, breed, healthRecord);
        this.description = description;
        this.dateLostOrFound = dateLostOrFound;
        this.status = status;
        setLastSeenLocation(lastSeenLocation);
    }
}