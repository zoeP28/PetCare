import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VendorSystem {
    private List<Category> categories;
    private ShoppingCart shoppingCart;

    public VendorSystem(){
        categories = new ArrayList<>();

        //Δημιουργία Categories και products

        for (int i = 0; i < 10; i++){
            Category category = new Category("Category " + (i + 1));

            for (int j = 0; j < 2; j++){

                Random random = new Random();
                double price = 10 + (random.nextDouble() * (30-10));
                price = Math.round(price * 100) / 100.0;

                Product product = new Product("Product " + (j + 1) + " of category " + (i + 1), price, 10, category);
                category.addProduct(product);
            }
            categories.add(category);
        }
        shoppingCart = new ShoppingCart();
    }

    public List<Category> getCategories(){
        return categories;
    }
}