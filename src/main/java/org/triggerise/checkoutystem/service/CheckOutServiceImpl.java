package org.triggerise.checkoutystem.service;

import org.triggerise.checkoutystem.data.DiscountedProduct;
import org.triggerise.checkoutystem.exception.InvalidProductException;
import org.triggerise.checkoutystem.rules.DiscountableProduct;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

//

public class CheckOutServiceImpl implements CheckOutService {

    private final Map<String, DiscountedProduct> products;
    private final Map<DiscountableProduct, Integer> cart = new HashMap<>();
    private final DiscountRuleService discountRuleService;

    public CheckOutServiceImpl(Map<String, DiscountedProduct> products, DiscountRuleService discountRuleService) {
        this.products = products;
        this.discountRuleService = discountRuleService;
    }


    @Override
    public CheckOutService scan(String code) {
        DiscountedProduct product = products.get(code);
        if (product == null) {
            throw new InvalidProductException();
        }
        cart.put(product, cart.getOrDefault(product, 0) + 1);
        return this;
    }

    @Override
    public BigDecimal total() {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<DiscountableProduct, Integer> entry : cart.entrySet()) {
            DiscountableProduct product = entry.getKey();
            int quantity = entry.getValue();
            total = total.add(discountRuleService.applyRule(product, quantity));
        }
        return total;
    }

    public Map<DiscountableProduct, Integer> getCart() {
        return cart;
    }
}
