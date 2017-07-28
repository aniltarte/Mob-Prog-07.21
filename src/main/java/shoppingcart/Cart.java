package shoppingcart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    private List<Product> products = new ArrayList<>();
    private String offerAppliedOn;

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void addProduct(String productName, Integer productPrice) {
        products.add(new Product(productName, productPrice));
    }

    public long getProductQuantity(String productName) {
        return products.stream()
                .filter(p -> p.getProductName().equals(productName))
                .count();
    }

    public int computeTotalPrice() {
        return computePriceForProductsWithOffer() + computePriceOfProductsWithoutOffer();
    }

    private int computePriceOfProductsWithoutOffer() {
        return products.stream()
                    .filter(p -> !matchProduct(p))
                    .mapToInt(p -> p.getProductPrice())
                    .sum();
    }

    private boolean matchProduct(Product product) {
        return product.getProductName().equals(this.offerAppliedOn);
    }

    private int computePriceForProductsWithOffer() {
        List<Product> productWithOffer = products.stream()
                .filter(this::matchProduct)
                .collect(Collectors.toList());

        int freeProducts = productWithOffer.size() / 3;

        int productsToBePaidFor = productWithOffer.size() - freeProducts;

        return productsToBePaidFor *
                (productWithOffer.isEmpty() ? 0 : productWithOffer.get(0).getProductPrice());
    }

    public void addBuyTwoGetOneFreeOffer(String productName) {
        this.offerAppliedOn = productName;
    }
}
