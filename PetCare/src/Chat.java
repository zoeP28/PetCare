import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Scanner;

public class Chat {

    private User user;
    private NutritionExpert currentExpert;
    private static Map<NutritionExpert, List<Message>> sessions;
    Scanner scanner = new Scanner(System.in);

    public Chat(User user) {
        this.user = user;
        this.sessions = new HashMap<>();
    }
    public void startChatWith(NutritionExpert expert) {

        if (!expert.isAvailable()){
            System.out.println(expert.getName() + " is currently unavailable. Would you like to schedule a chat? (Yes/No)");

            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("Yes")) {
                System.out.println("\nEnter the date and time for the scheduled chat (format: yyyy-MM-dd HH:mm): ");
                String datetimeInput = scanner.nextLine();
                LocalDateTime scheduledTime = LocalDateTime.parse(datetimeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                System.out.println("Chat with " + expert.getName() + " has been scheduled for " + scheduledTime);
                System.out.println("Would you like to receive an email notification? (Yes/No)");
                response = scanner.nextLine();

                if (response.equalsIgnoreCase("Yes")) {
                    System.out.println("Sending Email...");
                    System.out.println("Email sent successfully!");
                }

            } else{return;}
        }

        else {
            this.currentExpert = expert;
            if (!sessions.containsKey(expert)) {
                sessions.put(expert, new ArrayList<>());
            }
            System.out.println("*** Started chat with " + expert.getName() + " ***");
        }
    }

    public static void chat(){
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("\n------------------ Chat ------------------");
            System.out.println("1. Select a nutrition expert to chat with");
            System.out.println("2. Send a message");
            System.out.println("3. Receive a message");
            System.out.println("4. Display chat history");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------");

            System.out.print("Enter your choice: ");

            int option = sc.nextInt();
            sc.nextLine();
        }
//
        }
    }