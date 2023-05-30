import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<Product, Integer> cartItems;

    public ShoppingCart(){
        this.cartItems = new HashMap<>();
    }

    public void addToCart(Product product, int quantity){
        if (product.validateProductAvailability(quantity)){
            cartItems.put(product,quantity);
            product.setQuantity(product.getQuantity() - quantity);
        }
        else {
            ConfirmationMessage.quantityError(product);
        }
    }

    public double calculateTotal(){
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()){
            total +=entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void emptyCart(){
        this.cartItems.clear();
    }
}