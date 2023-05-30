import java.util.ArrayList;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}

