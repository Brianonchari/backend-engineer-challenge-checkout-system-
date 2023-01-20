package org.triggerise.checkoutystem.service;

import org.triggerise.checkoutystem.data.Product;
import org.triggerise.checkoutystem.rules.DiscountRule;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CheckOutServiceImpl implements CheckOutService{
    private Map<Product, Integer> items;
    private Map<Product, DiscountRule> discountRules;
    private DiscountRuleService discountRuleService;

    public CheckOutServiceImpl() {
        items = new HashMap<>();
        discountRules = new HashMap<>();
        discountRuleService = new DiscountRuleService();
    }

    @Override
    public void scan(Product product) {
//        if(!discountRules.containsKey(product)){
//            throw new IllegalArgumentException("Invalid Product");
//        }

        if(!items.containsKey(product)){
            items.put(product,1);
        }else {
            items.put(product,items.get(product) + 1);
        }
    }

    @Override
    public BigDecimal total() {
        BigDecimal total = new BigDecimal("0.00");
        for(Map.Entry<Product,Integer> entry: items.entrySet()){
            Product product = entry.getKey();
            int productCount = entry.getValue();
            BigDecimal itemPrice = discountRuleService.applyRule(product,productCount);
            total = total.add(itemPrice);
        }
        return total;
    }
}
