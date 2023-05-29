import java.util.Date;

public class Order {
    private String orderId;
    private Product product;
    private int quantity;
    private String address;
    private Date date;
    private User user;

    // ... constructors, getters and setters
    public Order(Product product, int quantity, User user) {
        this.product = product;
        this.quantity = quantity;
        this.user = user;
    }

    public String getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getAddress() {
        return address;
    }

    public Date getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

