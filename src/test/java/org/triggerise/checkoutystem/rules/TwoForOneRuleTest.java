package org.triggerise.checkoutystem.rules;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TwoForOneRuleTest {
    private TwoForOneRule twoForOneRule;
    private DiscountableProduct discountableProduct;

    @Before
    public void setUp() {
        twoForOneRule = new TwoForOneRule();
        discountableProduct = mock(DiscountableProduct.class);
    }

    @Test
    public void testApply_twoForOneDiscountApplied() {
        when(discountableProduct.getPrice()).thenReturn(new BigDecimal("4.00"));
        BigDecimal expectedPrice = new BigDecimal("4.00");
        BigDecimal actualPrice = twoForOneRule.apply(discountableProduct, 2);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testApply_twoForOneDiscountNotApplied() {
        when(discountableProduct.getPrice()).thenReturn(new BigDecimal("4.00"));
        BigDecimal expectedPrice = new BigDecimal("4.00");
        BigDecimal actualPrice = twoForOneRule.apply(discountableProduct, 1);
        assertEquals(expectedPrice, actualPrice);
    }

}