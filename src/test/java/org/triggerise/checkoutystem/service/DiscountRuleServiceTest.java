package org.triggerise.checkoutystem.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.triggerise.checkoutystem.rules.DiscountRule;
import org.triggerise.checkoutystem.rules.DiscountableProduct;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DiscountRuleServiceTest {
    private DiscountRuleService discountRuleService;
    private DiscountableProduct discountableProduct;
    private DiscountRule discountRule;

    @Before
    public void setUp() {
        discountRuleService = new DiscountRuleService();
        discountableProduct = mock(DiscountableProduct.class);
        discountRule = mock(DiscountRule.class);
    }

    @Test
    public void testApplyRule() {
        when(discountableProduct.getDiscountRule()).thenReturn(discountRule);
        when(discountRule.apply(discountableProduct,2)).thenReturn(new BigDecimal("21.00"));
//        when(usbkey.getDiscountRule()).thenReturn(noRule);

    }

}