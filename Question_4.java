import java.util.HashMap;
import java.util.Scanner;

class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String msg) {
        super(msg);
    }
}

class ProductStore {
    private HashMap<String, Double> products = new HashMap<>();

    // Add product  
    public void addProduct(String id, double price) {
        products.put(id, price);
    }

    // Apply discount
    public void applyDiscount(String id, double discount) 
            throws ProductNotFoundException, IllegalArgumentException {
        
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException("Error: Product ID not found!");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Error: Discount percentage must be between 0 and 100!");
        }
        double oldPrice = products.get(id);
        double newPrice = oldPrice - (oldPrice * discount / 100);
        products.put(id, newPrice);
        System.out.println("New price for " + id + ": $" + newPrice);
    }

    public void displayProducts() {
        System.out.println("Product List: " + products);
    }
}

public class HashMapDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductStore store = new ProductStore();

        // Add only one product
        store.addProduct("P001", 50.0);
        System.out.println("Adding product: P001=$50.0");

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Display Products");
            System.out.println("2. Apply Discount");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    store.displayProducts();
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    String id = sc.next();
                    System.out.print("Enter Discount %: ");
                    double d = sc.nextDouble();
                    try {
                        System.out.println("Applying " + d + "% discount to " + id + "...");
                        store.applyDiscount(id, d);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);

        sc.close();
    }
}
