package org.triggerise.checkoutystem.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.junit.MockitoJUnitRunner;
import org.triggerise.checkoutystem.data.DiscountedProduct;
import org.triggerise.checkoutystem.data.Mug;
import org.triggerise.checkoutystem.data.TShirt;
import org.triggerise.checkoutystem.data.USBKey;
import org.triggerise.checkoutystem.exception.InvalidProductException;
import org.triggerise.checkoutystem.rules.BulkDiscountRule;
import org.triggerise.checkoutystem.rules.DiscountableProduct;
import org.triggerise.checkoutystem.rules.NoRule;
import org.triggerise.checkoutystem.rules.TwoForOneRule;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CheckOutServiceImplTest {
    private CheckOutService checkOutService;
    private Map<String, DiscountedProduct> products;
    private DiscountRuleService discountRuleService;
    private Map<DiscountableProduct, Integer> cart;


    @Before
    public void setUp() {
        products = new HashMap<>();
        products.put("MUG", new DiscountedProduct(new Mug(), new TwoForOneRule()));
        products.put("TSHIRT", new DiscountedProduct(new TShirt(),new BulkDiscountRule(3,0.3)));
        products.put("USBKEY", new DiscountedProduct(new USBKey(), new NoRule()));
        discountRuleService = new DiscountRuleService();
        checkOutService = new CheckOutServiceImpl(products, discountRuleService);
        cart = new HashMap<>();
    }

    @Test
    public void testScanMethod() {
        checkOutService.scan("MUG");
        Map<DiscountableProduct, Integer> cart = ((CheckOutServiceImpl) checkOutService).getCart();
        assertEquals(1, cart.size());
    }

    @Test(expected = InvalidProductException.class)
    public void testInvalidProduct() {
        checkOutService.scan("INVALID_CODE");
    }

    @Test
    public void testTotalMethod() {
        checkOutService.scan("MUG").scan("MUG").scan("TSHIRT").scan("TSHIRT").scan("TSHIRT").scan("USBKEY");
        BigDecimal total = checkOutService.total();
        BigDecimal expectedTotal = new BigDecimal("58.00");
        assertEquals(expectedTotal, total);
    }


}