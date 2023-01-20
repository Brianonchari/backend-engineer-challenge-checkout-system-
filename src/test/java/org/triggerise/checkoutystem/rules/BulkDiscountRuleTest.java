package org.triggerise.checkoutystem.rules;


import org.junit.Before;
import org.triggerise.checkoutystem.data.Product;

public class BulkDiscountRuleTest {
    public BulkDiscountRule bulkDiscountRule;
    private Product product;


    @Before
    public void setUp(){
        bulkDiscountRule = new BulkDiscountRule(3,0.3);

    }

}