import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    Map<String, Double> accounts;

    public BankSystem() {
        accounts = new HashMap<>();
    }

    public void addBankAccount(String userId, double initialBalance) {
        accounts.put(userId, initialBalance);
    }

    public boolean processPayment(String userId, double amount) {
        Double currentBalance = accounts.get(userId);

        if (currentBalance == null) {
            System.out.println("Error: No bank account found for user " + userId);
            return false;
        }

        else if (currentBalance < amount) {
            System.out.println("Error: Not enough balance in user's account. Current balance: " + currentBalance);
            return false;
        }

        else {
            accounts.put(userId, currentBalance - amount);
            System.out.println("Payment processed successfully. New balance: " + (currentBalance - amount));
            return true;

        }
    }
    public void getPaymentInfo(){
        addBankAccount("user1", 500);
        addBankAccount("user2", 500);
        addBankAccount("user3", 500);
        addBankAccount("user4", 500);
    }


}