package org.triggerise.checkoutystem.data;

import org.triggerise.checkoutystem.rules.DiscountRule;
import org.triggerise.checkoutystem.rules.DiscountableProduct;

import java.math.BigDecimal;

/**
 *  This class associates a specific product  with a specific discount rule,
 *  Decouple product classes from discount logic
 *
 */

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
