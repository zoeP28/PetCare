
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private String name;
    private String password;
    private Location location;

    private List<Pet> pets;
    private static List<User> users;
    private List<Appointment> appointments;
    private Chat chat;



    public User(String name, String password, Location location) {
        this.name = name;
        this.password = password;
        this.appointments = new ArrayList<>();
        this.pets = new ArrayList<>();
        this.location = location;
        this.chat = new Chat(this);
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

    public void startChatWith(NutritionExpert expert) {
        chat.startChatWith(expert);
    }

    public void sendChatMessage(String messageContent) {
        chat.sendMessage(messageContent);
    }

    public void receiveChatMessage(String messageContent) {
        chat.receiveMessage(messageContent);
    }

    public void displayChatHistory() {
        chat.displayMessages();
    }

    public Pet selectPet() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----- Your Pets -----");
        for (int i = 0; i < this.pets.size(); i++) {
            System.out.println((i + 1) + ". " + this.pets.get(i).getName());
        }
        System.out.println("-----------------------------");

        System.out.print("Select a pet: ");
        int selectedPet = sc.nextInt();
        sc.nextLine();

        return this.pets.get(selectedPet - 1);
    }

    static void initUsers() {

        users = new ArrayList<>();
        User user1 = new User("user1", "pass1", Location.Patras);
        User user2 = new User("user2", "pass2",Location.Patras);
        User user3 = new User("user3", "pass3",Location.Athens);
        User user4 = new User("user4", "pass4",Location.Athens);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        ArrayList<String> vaccinations = new ArrayList<>();
        vaccinations.add("Rabies");
        vaccinations.add("Distemper");

        ArrayList<String> medications = new ArrayList<>();
        medications.add("Heartworm");

        ArrayList<String> allergies = new ArrayList<>();
        allergies.add("Chicken");

        ArrayList<String> surgicalProcedures = new ArrayList<>();
        surgicalProcedures.add("Neutering");

        HealthRecord healthRecord = new HealthRecord(vaccinations, medications, allergies, surgicalProcedures);

        Pet pet1 = new Pet("Bobby", 3, "Golden Retriever", healthRecord);
        Pet pet2 = new Pet("Kitty", 2, "Persian Cat",healthRecord);

        user1.addPet(pet1);
        user1.addPet(pet2);

    }
}






