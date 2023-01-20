package org.triggerise.checkoutystem;

import org.triggerise.checkoutystem.data.Mug;
import org.triggerise.checkoutystem.data.TShirt;
import org.triggerise.checkoutystem.service.CheckOutServiceImpl;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Triggerise Checkout System");
        CheckOutServiceImpl checkOutService = new CheckOutServiceImpl();
//        checkOutService.scan(new Mug());
        checkOutService.scan(new TShirt());
        checkOutService.scan(new TShirt());
        checkOutService.scan(new TShirt());
        checkOutService.scan(new TShirt());
        checkOutService.scan(new Mug());

        BigDecimal total = checkOutService.total();
        System.out.println("Total: " + total + " Euros");
    }
}