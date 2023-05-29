import java.util.ArrayList;

public class Product {
    private String productId;
    private String name;
    private double price;
    private String description;
    private ArrayList<Order> orders;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

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

