package org.triggerise.checkoutystem.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.triggerise.checkoutystem.rules.DiscountRule;
import org.triggerise.checkoutystem.rules.DiscountableProduct;

import static org.mockito.Mockito.mock;

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

    }

}