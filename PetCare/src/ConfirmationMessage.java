import java.util.Scanner;

public class ConfirmationMessage {

    static Scanner scanner;
    static String response;

    public static boolean showConfirmationMessage(String message) {
        System.out.println(message + " Confirm? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }

    public static void displayConfirmation() {
        System.out.println("Order confirmed! Thank you for your purchase.");
    }

    public static void quantityError(Product product) {
        System.out.println("Sorry, we do not have enough stock of " + product.getName() + ".");
    }

    public static String unavailableNutritionExpert(NutritionExpert expert){
        System.out.println(expert.getName() + " is currently unavailable. Would you like to schedule a chat? (Yes/No)");
        response = scanner.nextLine();
        return response;
    }

    public static String promptForLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*** Welcome to Emergency Vet Locator ***");
        System.out.print("Do you allow access to your location? (Yes/No): ");
        return scanner.next();
    }
}
