package shoppingcart;

public class Product {
    private final String productName;
    private final Integer productPrice;

    public Product(String productName, Integer productPrice) {

        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getProductPrice() {

        return productPrice;
    }
}
