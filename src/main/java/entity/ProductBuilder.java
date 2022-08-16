package entity;

public interface ProductBuilder {

    ProductBuilder setPrice(double price);

    ProductBuilder setPromotionalQuantity(int quantity);

    ProductBuilder setPromotionalPrice(double promotPrice);

    Product build();
}
