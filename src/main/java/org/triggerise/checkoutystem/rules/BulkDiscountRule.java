package org.triggerise.checkoutystem.rules;

import java.math.BigDecimal;

public class BulkDiscountRule implements DiscountRule {
    private int minimumCount;
    private double discount;


    public BulkDiscountRule(int minimumCount, double discount) {
        this.minimumCount = minimumCount;
        this.discount = discount;

    }

    @Override
    public BigDecimal apply(DiscountableProduct product, int quantity) {
        if (quantity >= minimumCount) {
            BigDecimal price = product.getPrice().multiply(new BigDecimal(1 - discount));
            return price.multiply(new BigDecimal(quantity));
        }

        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
