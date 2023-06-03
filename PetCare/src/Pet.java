import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String name;

    private String lastSeenLocation;
    private int age;
    private String breed;
    private DietPlan dietPlan;
    private List<HealthRecord> healthHistory;
    private HealthRecord healthRecord;

    public Pet(String name, int age, String breed, HealthRecord healthRecord) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.healthRecord= healthRecord;
        this.healthHistory = new ArrayList<>();
    }


    public Pet(String name, int age, String breed) {
        this(name, age, breed, new HealthRecord("", "", "",""));
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }


    public List<HealthRecord> getHealthHistory() {
        return healthHistory;
    }

    public String getLastSeenLocation() {
        return lastSeenLocation;
    }

    public void setLastSeenLocation(String lastSeenLocation) {
        this.lastSeenLocation = lastSeenLocation;
    }


    public void addHealthRecord(HealthRecord record) {
        this.healthHistory.add(record);
    }

    public void displayHealthRecord() {
        HealthRecord.display();
    }

    public DietPlan getDietPlan() {
        return dietPlan;
    }

    public void setDietPlan(DietPlan dietPlan) {
        this.dietPlan = dietPlan;
    }
}
