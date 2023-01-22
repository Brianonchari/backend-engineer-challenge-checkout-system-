package org.triggerise.checkoutystem.rules;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BulkDiscountRuleTest {
    private BulkDiscountRule bulkDiscountRule;
    private DiscountableProduct discountableProduct;

    @Before
    public void setUp() {
        bulkDiscountRule = new BulkDiscountRule(3, 0.3);
        discountableProduct = mock(DiscountableProduct.class);
    }

    @Test
    public void testApply_discountApplied() {
        when(discountableProduct.getPrice()).thenReturn(new BigDecimal("21.00"));
        BigDecimal expectedPrice = new BigDecimal("74.00");
        BigDecimal actualPrice = bulkDiscountRule.apply(discountableProduct,3);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testApply_discountNotApplied(){
        when(discountableProduct.getPrice()).thenReturn(new BigDecimal("21.00"));
        BigDecimal expectedPrice = new BigDecimal("42.00");
        BigDecimal actualPrice = bulkDiscountRule.apply(discountableProduct,2);
        assertEquals(expectedPrice,actualPrice);
    }
}