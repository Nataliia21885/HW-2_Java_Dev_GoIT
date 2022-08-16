package entity;

public class ProductBuilderImpl implements ProductBuilder {
    Product product = new Product();

    @Override
    public ProductBuilder setPrice(double price) {
        product.price = price;
        return this;
    }

    @Override
    public ProductBuilder setPromotionalQuantity(int quantity) {
        product.promotionalQuantity = quantity;
        return this;
    }

    @Override
    public ProductBuilder setPromotionalPrice(double promotPrice) {
        product.promotionalPrice = promotPrice;
        return this;
    }

    @Override
    public Product build() {
        return product;
    }
}
