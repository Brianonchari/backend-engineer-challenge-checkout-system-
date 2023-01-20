package org.triggerise.checkoutystem.rules;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.triggerise.checkoutystem.data.DiscountedProduct;
import org.triggerise.checkoutystem.data.USBKey;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NoRuleTest {
    private NoRule noRule;
    private Map<String, DiscountedProduct> products;
    private DiscountableProduct discountableProduct;

    @Before
    public void setUp() {
        noRule = new NoRule();
        products = new HashMap<>();
        discountableProduct = mock(DiscountableProduct.class);

    }

    @Test
    public void applyTest() {
        BigDecimal price = new BigDecimal("10.00");
        when(discountableProduct.getPrice()).thenReturn(price);
        BigDecimal expectedPrice = new BigDecimal("20.00");
        BigDecimal actualPrice = noRule.apply(discountableProduct, 2);
        assertEquals(expectedPrice, actualPrice);
    }

}