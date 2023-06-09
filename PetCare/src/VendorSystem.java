import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VendorSystem {
    private List<Category> categories;
    private ShoppingCart shoppingCart;

    public void fetchPetSupplies() {

        categories = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Category category = new Category("Category " + (i + 1));

            for (int j = 0; j < 2; j++) {

                Random random = new Random();
                double price = 10 + (random.nextDouble() * (30 - 10));
                price = Math.round(price * 100) / 100.0;

                Product product = new Product("Product " + (j + 1) + " of Category " + (i + 1), price, 10, category);
                category.addProduct(product);
            }
            categories.add(category);
        }
        shoppingCart = new ShoppingCart();
    }


    public void fetchProducts(Category category){
        for (int i = 0; i < category.getProducts().size(); i++) {
            System.out.println((i + 1) + ": " + category.getProducts().get(i).getName() + " "
                    + category.getProducts().get(i).getPrice());
        }
    }

    public void showPetSupplies(){
        System.out.println("\n------ Categories ------ ");
        for (int i = 0; i < getCategories().size(); i++) {
            System.out.println((i + 1) + ". " + getCategories().get(i).getName());
        }
        System.out.println("------------------------ ");
    }

    
    public List<Category> getCategories(){
        return categories;
    }
}