import java.util.ArrayList;

public class PetSupplyStore {
    private String storeId;
    private String name;
    private Location location;
    private ArrayList<Product> products;


    private ArrayList<Payment> payments;

    public PetSupplyStore() {
        this.products = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.initProducts();
    }



    public String getStoreId() {
        return storeId;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }


    public void proceedToCheckout(ShoppingCart cart) {
        this.payments.add(new Payment(cart.calculateTotal(), this));
    }

    public Payment displayPaymentForm(User user, double amount) {
        Payment payment = new Payment(user, amount);
        this.payments.add(payment);
        return payment;
    }


    private void initProducts() {
        // Initial products
        this.products.add(new Product("Dog Food",13.00));
        this.products.add(new Product("Cat Toys",20.50));
        // Add more products as necessary
    }


}
