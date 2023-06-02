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

    public void sendMessage(String messageContent) {
        Message message = new Message(user, messageContent);
        sessions.get(currentExpert).add(message);
        System.out.println("Message sent to " + currentExpert.getName() + " successfully!");
    }


    public void receiveMessage(String messageContent) {
        Message message = new Message(currentExpert, messageContent);
        sessions.get(currentExpert).add(message);
        System.out.println("Received message from " + currentExpert.getName() + " successfully!");
    }


    public void displayMessages() {
        List<Message> messages = sessions.get(currentExpert);
        System.out.println("\n------------ Chat ------------");
        for (Message message : messages) {
            System.out.println(message.getSender().getName() + ": " + message.getContent());
        }
        System.out.println("------------------------------");
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
            switch (option) {

                case 1:

                    System.out.println("\n----- Available Experts -----");
                    for (int i = 0; i < Main.nutritionExperts.size(); i++) {
                        NutritionExpert expert = Main.nutritionExperts.get(i);
                       // System.out.println((i + 1) + ". " + expert.getName() + ", Average rating: " + expert.calculateAverageRating());

                    }
                    System.out.println("-----------------------------");

                    System.out.print("Select a nutrition expert: ");
                    int selectedExpert = sc.nextInt();
                    sc.nextLine();

                    Main.currentUser.startChatWith(Main.nutritionExperts.get(selectedExpert - 1));
                    break;

                case 2:

                    System.out.print("\nEnter a message to send: ");
                    String message = sc.nextLine();
                    Main.currentUser.sendChatMessage(message);
                    break;

                case 3:

                    System.out.print("\nEnter a message to send: ");
                    String reply = sc.nextLine();
                    Main.currentUser.receiveChatMessage(reply);
                    break;

            }
        }

        }
    }