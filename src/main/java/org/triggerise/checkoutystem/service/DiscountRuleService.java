package org.triggerise.checkoutystem.service;

import org.triggerise.checkoutystem.data.Mug;
import org.triggerise.checkoutystem.data.Product;
import org.triggerise.checkoutystem.data.TShirt;
import org.triggerise.checkoutystem.data.USBKey;
import org.triggerise.checkoutystem.rules.BulkDiscountRule;
import org.triggerise.checkoutystem.rules.DiscountRule;
import org.triggerise.checkoutystem.rules.NoRule;
import org.triggerise.checkoutystem.rules.TwoForOneRule;

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

    public BigDecimal applyRule(Product product, int quantity){
//        if(!discountRules.containsKey(product)){
//            throw new IllegalArgumentException("Invalid Product");
//        }

        DiscountRule discountRule = discountRules.getOrDefault(product,new NoRule());
        return discountRule.apply(product,quantity);
    }
}
