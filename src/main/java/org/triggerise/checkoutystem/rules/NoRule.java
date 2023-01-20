package org.triggerise.checkoutystem.rules;

import org.triggerise.checkoutystem.data.Product;

import java.math.BigDecimal;

public class NoRule implements DiscountRule{
    @Override
    public BigDecimal apply(Product product, int quantity) {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
