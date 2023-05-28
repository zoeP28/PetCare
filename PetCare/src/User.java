
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

    static void checkAppointments() {
        List<Appointment> appointments = Main.currentUser.getAppointments();
        if(appointments.isEmpty()) {
            System.out.println("You have no appointments.");
        } else {
            System.out.println("Your appointments:");
            for(Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    static void initUsers() {

        users = new ArrayList<>();
        User user1 = new User("user1", "pass1", Location.Patras);
        User user2 = new User("user2", "pass2",Location.Patras);
        User user3 = new User("user3", "pass3",Location.Athens);
        User user4 = new User("user4", "pass4",Location.Athens);

