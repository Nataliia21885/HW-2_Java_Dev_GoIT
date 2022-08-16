package store;

import entity.Product;
import entity.ProductBuilderImpl;

import java.util.HashMap;
import java.util.Map;

public class State {

    public Map<String, Product> getState() {
        Map<String, Product> availableGoods = new HashMap<>();
        availableGoods.put("A", new ProductBuilderImpl().setPrice(1.25).setPromotionalQuantity(3).setPromotionalPrice(3).build());
        availableGoods.put("B", new ProductBuilderImpl().setPrice(4.25).build());
        availableGoods.put("C", new ProductBuilderImpl().setPrice(1).setPromotionalQuantity(6).setPromotionalPrice(5).build());
        availableGoods.put("D", new ProductBuilderImpl().setPrice(0.75).build());

        return availableGoods;
    }

}
