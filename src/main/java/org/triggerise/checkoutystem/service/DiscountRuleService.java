package org.triggerise.checkoutystem.service;

import org.triggerise.checkoutystem.data.*;
import org.triggerise.checkoutystem.rules.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DiscountRuleService {
    private Map<Product, DiscountRule> discountRules;

    public DiscountRuleService() {
        discountRules = new HashMap<>();
        discountRules.put(new Mug(), new TwoForOneRule());
        discountRules.put(new TShirt(), new BulkDiscountRule(3, 0.3));
        discountRules.put(new USBKey(), new NoRule());
    }



    public BigDecimal applyRule(DiscountableProduct product, int quantity) {
        return product.getDiscountRule().apply(product, quantity);
    }
}
