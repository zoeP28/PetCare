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
    }