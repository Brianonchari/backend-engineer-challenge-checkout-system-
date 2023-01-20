package org.triggerise.checkoutystem.rules;

import org.triggerise.checkoutystem.data.Product;

import java.math.BigDecimal;

public class NoRule implements DiscountRule{
    @Override
    public BigDecimal apply(DiscountableProduct product, int quantity) {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
