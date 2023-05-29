import java.util.ArrayList;


public class ShoppingCart {
    private ArrayList<Order> orders;

    public ShoppingCart() {
        this.orders = new ArrayList<>();
    }

    public double calculateTotal() {
        double total = 0;
        for (Order order : orders) {
            total += order.getProduct().getPrice() * order.getQuantity();
        }
        return total;
    }
}