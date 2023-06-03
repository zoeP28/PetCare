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

}
