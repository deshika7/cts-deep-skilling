import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return productId + " - " + productName + " [" + category + "]";
    }
}

public class ECommerceSearch {

    public static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id) {
                return p;
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] sortedProducts, int id) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedProducts[mid].productId == id) {
                return sortedProducts[mid];
            } else if (sortedProducts[mid].productId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(104, "Mobile", "Electronics"),
            new Product(101, "Shirt", "Clothing"),
            new Product(103, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear")
        };

        System.out.println("🔍 Linear Search:");
        Product result1 = linearSearch(products, 103);
        System.out.println(result1 != null ? "Found: " + result1 : "Product not found");

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        System.out.println("\n🔍 Binary Search:");
        Product result2 = binarySearch(products, 103);
        System.out.println(result2 != null ? "Found: " + result2 : "Product not found");
    }
}
