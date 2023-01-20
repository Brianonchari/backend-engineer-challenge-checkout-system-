package org.triggerise.checkoutystem.data;

import org.triggerise.checkoutystem.rules.DiscountRule;
import org.triggerise.checkoutystem.rules.DiscountableProduct;

import java.math.BigDecimal;

public class DiscountedProduct implements DiscountableProduct {
    private Product product;
    private DiscountRule discountRule;

    public DiscountedProduct(Product product, DiscountRule discountRule) {
        this.product = product;
        this.discountRule = discountRule;
    }

    @Override
    public BigDecimal getPrice() {
        return product.getPrice();
    }

    @Override
    public DiscountRule getDiscountRule() {
        return discountRule;
    }
}
