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
}