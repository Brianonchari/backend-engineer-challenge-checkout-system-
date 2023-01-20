package org.triggerise.checkoutystem.rules;

import java.math.BigDecimal;

public class TwoForOneRule implements DiscountRule {
    @Override
    public BigDecimal apply(DiscountableProduct product, int quantity) {
        int freeItems = quantity / 2;
        BigDecimal total = product.getPrice().multiply(BigDecimal.valueOf(quantity - freeItems));
        return total;
    }

}
