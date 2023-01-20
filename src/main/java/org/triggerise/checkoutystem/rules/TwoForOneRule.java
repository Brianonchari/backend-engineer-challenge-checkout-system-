package org.triggerise.checkoutystem.rules;

import org.triggerise.checkoutystem.data.Product;

import java.math.BigDecimal;

public class TwoForOneRule implements DiscountRule{
    @Override
    public BigDecimal apply(Product product, int quantity) {
        int freeItems = quantity / 2;
        quantity -= freeItems;
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
