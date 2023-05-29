import java.util.ArrayList;

public class Payment {
    private String paymentId;
    private User user;
    private Order order;
    private double amount;

    private ArrayList<Payment> payments;


    public Payment(User user, double amount) {
        this.paymentId = paymentId;
        this.user = user;
        this.amount = amount;
    }

    public Payment(double calculateTotal, PetSupplyStore petSupplyStore) {
    }

}