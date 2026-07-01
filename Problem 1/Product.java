import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private double price;
    private int stockQuantity;

    public Product(String productId, String productName, double price, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = Math.max(0.0, price);
        this.stockQuantity = Math.max(0, stockQuantity);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = Math.max(0.0, price);
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = Math.max(0, stockQuantity);
    }

    public void applyDiscount(double percentage) {
        if (percentage < 0) {
            return;
        }
        price = price - (price * percentage / 100.0);
        if (price < 0.0) {
            price = 0.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        String productId = scanner.nextLine();

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = 0.0;
        if (scanner.hasNextDouble()) {
            price = scanner.nextDouble();
        } else {
            scanner.next();
        }

        System.out.print("Enter stock quantity: ");
        int stockQuantity = 0;
        if (scanner.hasNextInt()) {
            stockQuantity = scanner.nextInt();
        } else {
            scanner.next();
        }

        Product p = new Product(productId, productName, price, stockQuantity);

        System.out.print("Enter discount percentage: ");
        double discount = 0.0;
        if (scanner.hasNextDouble()) {
            discount = scanner.nextDouble();
        }

        p.applyDiscount(discount);

        System.out.println("Price after discount: " + p.getPrice());
        System.out.println("Stock quantity: " + p.getStockQuantity());

        scanner.close();
    }
}
