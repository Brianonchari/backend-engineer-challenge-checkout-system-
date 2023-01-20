package org.triggerise.checkoutystem;

import org.triggerise.checkoutystem.data.DiscountedProduct;
import org.triggerise.checkoutystem.data.Mug;
import org.triggerise.checkoutystem.data.TShirt;
import org.triggerise.checkoutystem.data.USBKey;
import org.triggerise.checkoutystem.rules.BulkDiscountRule;
import org.triggerise.checkoutystem.rules.NoRule;
import org.triggerise.checkoutystem.rules.TwoForOneRule;
import org.triggerise.checkoutystem.service.CheckOutService;
import org.triggerise.checkoutystem.service.CheckOutServiceImpl;
import org.triggerise.checkoutystem.service.DiscountRuleService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, DiscountedProduct> products = new HashMap<>();
        products.put("MUG", new DiscountedProduct(new Mug(), new TwoForOneRule()));
        products.put("TSHIRT", new DiscountedProduct(new TShirt(), new BulkDiscountRule(3, 0.3)));
        products.put("USBKEY", new DiscountedProduct(new USBKey(), new NoRule()));
        DiscountRuleService discountRuleService = new DiscountRuleService();
        CheckOutService checkout = new CheckOutServiceImpl(products, discountRuleService);

        checkout
                .scan("MUG")
                .scan("MUG")
                .scan("MUG")
                .scan("TSHIRT")
                .scan("TSHIRT")
                .scan("TSHIRT")
                .scan("USBKEY");
        BigDecimal totalPrice = checkout.total();
        System.out.println("Total price: " + totalPrice);

    }
}