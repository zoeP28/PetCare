import java.util.ArrayList;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private Category category;

    public Product(String name, double price, int quantity, Category category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }


    public boolean validateProductAvailability(int requestedQuantity) {
        return this.quantity >= requestedQuantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

