import java.util.*;

public class Main {

    static User currentUser;
    static List<NutritionExpert> nutritionExperts;
    public static void main(String[] args) {

        User.initUsers();
        Vet.initVets();

        BankSystem bank = new BankSystem();
        bank.addBankAccount("user1", 500);
        bank.addBankAccount("user2", 5000);
        bank.addBankAccount("user3", 5000);
        bank.addBankAccount("user4", 5000);

        // Initialize nutrition experts
        nutritionExperts = new ArrayList<>();
        NutritionExpert expert1 = new NutritionExpert("Expert1", "password", Location.Patras);
        NutritionExpert expert2 = new NutritionExpert("Expert2", "password", Location.Athens);
        nutritionExperts.add(expert1);
        nutritionExperts.add(expert2);

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
                        PetSupplyStore store = new PetSupplyStore();
                        ShoppingCart shoppingCart = new ShoppingCart();
                        Scanner scanner2 = new Scanner(System.in);

                        int option2;
                        do {

                            System.out.println("\n*** Order Supplies ***");
                            System.out.println("1. List categories");
                            System.out.println("2. Add to Cart");
                            System.out.println("3. Checkout");
                            System.out.println("4. Quit");
                            System.out.println("Enter option: ");
                            option2 = scanner2.nextInt();

                            switch (option2){

                                case 1:
                                    for (int i = 0; i < store.getCategories().size(); i++){
                                        System.out.println((i + 1) + ". " + store.getCategories().get(i).getName());
                                    }
                                    break;

                                case 2:

                                    System.out.println("Please enter the category number of the product you wish to purchase: ");

                                    int categoryNumber = scanner.nextInt();
                                    Category category = store.getCategories().get(categoryNumber - 1);

                                    System.out.println("These are the product in this category: ");

                                    for (int i = 0; i < category.getProducts().size(); i++){
                                        System.out.println((i + 1) + ": " + category.getProducts().get(i).getName() +" " + category.getProducts().get(i).getPrice());
                                    }

                                    System.out.print("Enter product number: ");
                                    int productNumber = scanner.nextInt();

                                    if (productNumber < 1 || productNumber > category.getProducts().size()){
                                        System.out.println("Invalid product number. Please enter a number between 1 and " + category.getProducts().size());
                                    }
                                    else {
                                        Product product = category.getProducts().get(productNumber - 1);
                                        System.out.print("Enter quality: ");
                                        int quantity = scanner.nextInt();
                                        shoppingCart.addToCart(product, quantity);
                                        double totalAmount = shoppingCart.calculateTotal();
                                        System.out.println("Total Amount to be paid: " + totalAmount);
                                    }
                                    break;

                                case 3:

                                    //Proceed to checkout
                                    double totalAmount = shoppingCart.calculateTotal();
                                    System.out.println("Total Amount to be paid: " + totalAmount);
                                    System.out.println("Shipping Address: " + Main.currentUser.getLocation().getName());

                                    System.out.println("Proceeding to Payment...");
                                    ConfirmationMessage.showConfirmationMessage("Do you want to confirm the paymetn?");
                                    boolean paymentSuccess = bank.processPayment(currentUser.getName(), totalAmount);

                                    if (paymentSuccess){
                                        ConfirmationMessage.displayConfirmation();
                                        shoppingCart.emptyCart();
                                    }
                                    else {
                                        System.out.println("Payment failed. Please try again.");
                                    }
                                    break;

                                case 4:
                                    System.out.println("Thank you for using our service. Goodbye!");
                                    break;

                                default:
                                System.out.println("Invalid option, please try again.");
                                break;
                            }
                        }while (option2 != 4);

                    case 5:
                        //System.out.println("Balance: " + bank.accounts.get(Main.currentUser.getName()) + "$");
                        break;

                    case 6:
                        System.out.println("Exiting, thank you!");
                        break;
                    case 7:

                        Scanner scanner3 = new Scanner(System.in);
                        boolean isRunning = true;

                        while (isRunning) {

                            System.out.println("\n------ Nutrition Expert Menu ------");
                            System.out.println("1. Chat with a Nutrition Expert");
                            System.out.println("2. Create a diet plan for your pet");
                            System.out.println("3. Exit");
                            System.out.println("-----------------------------------");

                            System.out.print("Enter a choice: ");

                            int choice2 = scanner3.nextInt();
                            switch (choice2) {

                                case 1:
                                    Chat.chat();
                                    break;
                            }

                            }

                    default:
                        System.out.println("Invalid option. Please enter a number between 1 and 4.");
                        break;
                }
            }while (option!=5);
        }
    }
}

