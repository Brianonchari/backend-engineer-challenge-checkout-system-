package org.triggerise.checkoutystem.rules;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NoRule implements DiscountRule {
    @Override
    public BigDecimal apply(DiscountableProduct product, int quantity) {
        return product.getPrice().multiply(new BigDecimal(quantity)).setScale(2, RoundingMode.HALF_EVEN);
    }
}
