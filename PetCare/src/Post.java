public class Post {

    private LostAndFoundPet pet;
    private String type; // "Lost" or "Found"
    private String contactInfo;

    public Post(LostAndFoundPet pet, String type, String contactInfo) {
        this.pet = pet;
        this.type = type;
        this.contactInfo = contactInfo;
    }
}
