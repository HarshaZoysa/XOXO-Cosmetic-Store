
package cosmeticstore.myfunctions;


public class product {
    
    private String sku;
    private String productName;
    private int quantity;
    private double price;
    private String category;

    public product(String sku, String productName, int quantity, double price, String category) {
        this.sku = sku;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    // Getters and setters for each field
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}
