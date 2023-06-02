import java.time.LocalTime;
import java.util.ArrayList;


public class NutritionExpert extends  User {

    private ArrayList<Rating> ratings;

    public boolean isAvailable() {
        LocalTime now = LocalTime.now();
        return !now.isBefore(LocalTime.of(9, 0)) && !now.isAfter(LocalTime.of(23, 59));
    }


    public NutritionExpert(String username, String password, Location location) {
        super(username, password, location);
        this.ratings = new ArrayList<>();
    }

    public double calculateAverageRating() {
        if(ratings.isEmpty()) {
            return 0;
        }

        int totalScore = 0;
        for(Rating rating : ratings) {
            totalScore += rating.getScore();
        }

        return totalScore / (double) ratings.size();
    }


    public void addRating(Rating rating) {
        this.ratings.add(rating);
        System.out.println("Received rating: " + rating.getScore() + " Comment: " + rating.getComment());
    }
    public void createCustomDietPlan(Pet pet) {


        // Create diet plan
        String details = "\nDefault diet details:\n";

        if (pet.getBreed().equals("Golden Retriever")) {

            details = " \n\n ----------------------- Diet Plan for a Golden Retriever: -----------------------\n" +
                    "• High-Quality Dog Food: Choose a premium dog food that is specifically formulated \n" +
                    "  for large breeds or all life stages. Look for a brand that includes real meat as \n" +
                    "  the first ingredient and avoids fillers, artificial preservatives, and additives.\n\n" +

                    "• Balanced Macronutrients: A well-rounded diet for a Golden Retriever should consist \n" +
                    "  of approximately 18-24% protein, 10-15% fat, and a moderate amount of carbohydrates. \n" +
                    "  These ratios may vary depending on your dog's age, activity level, and any specific \n" +
                    "  health concerns.\n\n" +

                    "• Portion Control: Follow the feeding guidelines provided on the dog food packaging \n" +
                    "  as a starting point. Adjust the portions based on your dog's age, weight, and activity \n" +
                    "  level. It's essential to monitor your dog's weight and body condition to avoid  \n" +
                    "  overfeeding or underfeeding.\n\n" +

                    "• Fresh Water: Make sure your Golden Retriever has access \n" +
                    "  to fresh, clean water at all times.\n\n" +

                    "• Treats and Supplements: Limit the number of treats and choose healthy options like \n" +
                    "  natural dog treats or fruits and vegetables. Avoid giving your dog foods that are \n" +
                    "  toxic to dogs, such as chocolate, grapes, or onions. Consult with your veterinarian \n" +
                    "  before adding any supplements to your dog's diet.\n"+
                    "  --------------------------------------------------------------------------------------";

        } else if (pet.getBreed().equals("Persian Cat")) {

            details = " \n\n ----------------------- Diet Plan for a Persian Cat: -----------------------\n" +
                    "• High-Quality Cat Food: Choose a premium cat food that is specifically formulated \n" +
                    "  for adult cats. Look for a brand that includes real meat as the primary ingredient \n" +
                    "  and avoids fillers, artificial preservatives, and additives. Persian cats may benefit \n" +
                    "  from cat food that promotes skin and coat health.\n\n" +

                    "• Balanced Macronutrients: A healthy cat diet typically consists of approximately \n" +
                    "  25-30% protein, 15-20% fat, and a moderate amount of carbohydrates. Again, these \n" +
                    "  ratios may vary depending on your cat's age, weight, and activity level.\n\n" +

                    "• Portion Control: Follow the feeding guidelines provided on the cat food packaging \n" +
                    "  as a starting point. Adjust the portions based on your cat's age, weight, and \n" +
                    "  activity level. Monitor your cat's weight and body condition to avoid overfeeding \n" +
                    "  or underfeeding.\n\n" +

                    "• Fresh Water: Ensure that your Persian cat has access to fresh, clean \n" +
                    "  water at all times.\n\n" +

                    "• Grooming: Persian cats have long, luxurious coats that require regular \n" +
                    "  grooming to prevent matting. Brush your cat's coat daily and consider \n" +
                    "  incorporating hairball control supplements or foods into their diet.\n" +
                    " --------------------------------------------------------------------------------------";
        }

        DietPlan dietPlan = new DietPlan(pet.getName() + "'s Diet Plan");
        dietPlan.setDetails(details);
        pet.setDietPlan(dietPlan);
        System.out.println("Created custom diet plan for " + pet.getName() + ": " + dietPlan.getName());
    }

}
