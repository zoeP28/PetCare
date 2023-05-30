import java.util.Scanner;

public class ConfirmationMessage {

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
}
