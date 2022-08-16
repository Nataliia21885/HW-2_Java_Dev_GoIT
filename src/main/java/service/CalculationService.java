package service;

import entity.Product;
import exceptions.ProductCodeException;
import exceptions.ResourceBadRequestException;
import store.State;

import java.util.HashMap;
import java.util.Map;

public class CalculationService {
    public static double calculateTotalCost(State state, String expressionOfGoods) {

        double money = 0;

        try {

            Map<String, Product> map = state.getState();

            if (map.isEmpty()) {
                throw new ProductCodeException("Map with state is empty");
            }

            if (expressionOfGoods == null || expressionOfGoods.length() == 0) {
                throw new ProductCodeException("User's expressions is empty");
            }


            String[] arrOfCodes = expressionOfGoods.trim().split("");
            Map<String, Integer> basket = new HashMap<>();
            int amount = 0;

            for (int i = 0; i < arrOfCodes.length; i ++ ) {    //ABCDABA
                for (int j = 0; j < arrOfCodes.length; j++) {
                    if  (!map.containsKey(arrOfCodes[i])) {
                        throw new ProductCodeException("Product code does not exist!");
                    }

                    if(arrOfCodes[i].equals(arrOfCodes[j]) ) {
                        basket.put(arrOfCodes[i], ++amount);
                    }
                }
                amount = 0;
            }

            for (String key : basket.keySet()) {
                var t =  basket.get(key.toString());
                if (map.get(key).getPromotionalQuantity() == basket.get(key)) {
                    money = money + map.get(key).getPromotionalPrice();
                } else
                {
                    money = money + (map.get(key).getPrice() * basket.get(key));
                }
            }

        } catch (Exception e) {
           throw new ResourceBadRequestException(e.getMessage());
        }
        return money;
    }
}
