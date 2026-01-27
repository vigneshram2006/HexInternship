package HexLevel3;
import java.util.*;
class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    void addStock(int qty) {
        quantity += qty;
    }

    boolean removeStock(int qty) {
        if (qty > quantity) {
            return false;
        }
        quantity -= qty;
        return true;
    }
}

public class InventoryManagementSystem {

    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        
        products.add(new Product(1, "Laptop", 10, 55000));
        products.add(new Product(2, "Mouse", 50, 500));

        while (true) {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Purchase Stock");
            System.out.println("4. Sell Product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    purchaseStock();
                    break;
                case 4:
                    sellProduct();
                    break;
                case 5:
                    System.out.println("Exiting Inventory System...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        products.add(new Product(id, name, qty, price));
        System.out.println("Product added successfully");
    }

    static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available");
            return;
        }

        System.out.println("\nID\tName\t\tQty\tPrice");
        for (Product p : products) {
            System.out.println(
                p.productId + "\t" +
                p.productName + "\t\t" +
                p.quantity + "\t" +
                p.price
            );
        }
    }

    static void purchaseStock() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = findProduct(id);
        if (p == null) {
            System.out.println("Product not found");
            return;
        }

        System.out.print("Enter quantity to add: ");
        int qty = sc.nextInt();
        p.addStock(qty);

        System.out.println("Stock updated");
    }

    static void sellProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = findProduct(id);
        if (p == null) {
            System.out.println("Product not found");
            return;
        }

        System.out.print("Enter quantity to sell: ");
        int qty = sc.nextInt();

        if (p.removeStock(qty)) {
            System.out.println("Product sold successfully");
        } else {
            System.out.println("Insufficient stock");
        }
    }

    static Product findProduct(int id) {
        for (Product p : products) {
            if (p.productId == id) {
                return p;
            }
        }
        return null;
    }
}
