import java.time.LocalTime;
import java.util.ArrayList;


public class NutritionExpert extends  User {

    private ArrayList<Rating> ratings;

    public boolean isAvailable() {
        LocalTime now = LocalTime.now();
        return !now.isBefore(LocalTime.of(9, 0)) && !now.isAfter(LocalTime.of(23, 0));
    }


    public NutritionExpert(String username, String password, Location location) {
        super(username, password, location);
        this.ratings = new ArrayList<>();
    }
}
