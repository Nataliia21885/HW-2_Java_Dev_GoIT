package entity;

import java.util.Objects;

public class Product {
    double price;
    int promotionalQuantity;
    double promotionalPrice;

    public Product() {
    }

    public double getPrice() {
        return price;
    }

    public int getPromotionalQuantity() {
        return promotionalQuantity;
    }

    public double getPromotionalPrice() {
        return promotionalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0
                && promotionalQuantity == product.promotionalQuantity
                && Double.compare(product.promotionalPrice, promotionalPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, promotionalQuantity, promotionalPrice);
    }

    @Override
    public String toString() {
        return "entity.Product{" +
                "price=" + price +
                ", promotionalQuantity=" + promotionalQuantity +
                ", promotionalPrice=" + promotionalPrice +
                '}';
    }
}
