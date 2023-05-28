import java.util.Scanner;

public class ConfirmationMessage {

    public static boolean showConfirmationMessage(String message) {
        System.out.println(message + " Confirm? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }
}
