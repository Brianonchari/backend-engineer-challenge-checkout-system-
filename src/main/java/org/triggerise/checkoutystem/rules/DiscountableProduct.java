package org.triggerise.checkoutystem.rules;

import java.math.BigDecimal;

public interface DiscountableProduct {
    BigDecimal getPrice();
    DiscountRule getDiscountRule();
}
