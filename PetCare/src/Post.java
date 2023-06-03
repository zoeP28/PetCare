public class Post {

    private LostAndFoundPet pet;
    private String type; // "Lost" or "Found"
    private String contactInfo;

    public Post(LostAndFoundPet pet, String type, String contactInfo) {
        this.pet = pet;
        this.type = type;
        this.contactInfo = contactInfo;
    }


    @Override
    public String toString() {
        return type + " Pet\n" + "Name: " + pet.getName() + "\nBreed: " + pet.getBreed() +
                "\nDescription: " + pet.getDescription() + "\nLast Seen/Found Location: "
                + pet.getLastSeenLocation() + "\nDate: " + pet.getDateLostOrFound() + "\nContact: "
                + contactInfo + "\n";
    }
}
