import java.util.*;

public class Main {

    static User currentUser;

    public static void main(String[] args) {

        User.initUsers();
        Vet.initVets();

        Scanner scanner = new Scanner(System.in);
        System.out.println("***** Welcome! *****\nPlease login to continue.");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = User.login(username, password);

        if(user == null) {
            System.out.println("Invalid username or password.");
        }
        else {

            System.out.println("Successful Login!");
            int option;

            do{

                System.out.println("\n****** Home Page *******");
                System.out.println("1. Book Appointment");
                System.out.println("2. Check Appointments");
                System.out.println("3. Pet Health Records");
                System.out.println("4. Order Supplies");
                System.out.println("5. Exit");
                System.out.print("Enter option: ");
                option  = new Scanner(System.in).nextInt();

                switch(option) {
                    case 1:
                        Appointment.createAppointment(scanner);
                        break;

                    case 2:
                        User.checkAppointments();
                        break;

                    case 3:

                        // Pet Health Records Options
                        System.out.println("Welcome to Pet Health Records");
                        System.out.println("1. Add Pet");
                        System.out.println("2. Select Pet");
                        System.out.print("Enter your choice (1-2): ");
                        int choice = new Scanner(System.in).nextInt();

                        switch (choice) {
                            case 1 -> {
                                Pet newPet = Form.fillForm();
                                user.addPet(newPet);
                                System.out.println("Pet added successfully!");
                                ConfirmationMessage.showConfirmationMessage("Do you want to confirm the insertion?");
                            }
                            case 2 -> {

                                List<Pet> pets = user.getPets();
                                for (int i = 0; i < pets.size(); i++) {
                                    System.out.println((i + 1) + ". " + pets.get(i).getName());
                                }
                                System.out.println("Select a pet to view its health records");
                                int petChoice = new Scanner(System.in).nextInt();
                                Pet selectedPet = pets.get(petChoice - 1);
                                System.out.println("Health records for " + selectedPet.getName() + ":");
                                selectedPet.displayHealthRecord();

                            }
                            default -> System.out.println("Invalid choice");
                        }
                        break;

                    case 4:
                        System.out.println("Exiting, thank you!");
                        break;

                    default:
                        System.out.println("Invalid option, please try again.");
                        break;
                }
            }while (option!=5);
        }
    }
}

