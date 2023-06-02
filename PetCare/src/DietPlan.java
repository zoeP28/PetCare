public class DietPlan {
    private String name;
    private String details;

    public DietPlan(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getName() {
        return this.name;
    }

    public String getDetails() {
        return this.details;
    }
}
