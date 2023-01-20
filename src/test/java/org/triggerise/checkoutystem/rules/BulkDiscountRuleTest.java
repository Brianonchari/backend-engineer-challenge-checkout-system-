package org.triggerise.checkoutystem.rules;


import org.junit.Before;
import org.junit.Test;
import org.triggerise.checkoutystem.data.DiscountedProduct;
import org.triggerise.checkoutystem.data.TShirt;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BulkDiscountRuleTest {
    private BulkDiscountRule bulkDiscountRule;
    private DiscountableProduct discountableProduct;

    @Before
    public void setUp() {
        bulkDiscountRule = new BulkDiscountRule(3, 0.3);
    }

    @Test
    public void testDiscount() {
        BigDecimal price = new BigDecimal("21.00");
        BigDecimal expected = new BigDecimal("14.70");

    }

}