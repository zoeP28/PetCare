
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String password;
    private Location location;

    private List<Pet> pets;
    private static List<User> users;
    private List<Appointment> appointments;

    public User(String name, String password, Location location) {
        this.name = name;
        this.password = password;
        this.appointments = new ArrayList<>();
        this.pets = new ArrayList<>();
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public List<Pet> getPets() {
        return pets;
    }
    public void addPet(Pet pet) {
        this.pets.add(pet);
    }
    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
    static User login(String username, String password) {
        for(User user : users) {
            if(user.getName().equals(username) && user.getPassword().equals(password)) {
                Main.currentUser = user;
                return user;
            }
        }
        return null;
    }

