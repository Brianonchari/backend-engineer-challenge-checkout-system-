package org.triggerise.checkoutystem.service;

import org.triggerise.checkoutystem.data.Product;

import java.math.BigDecimal;

public interface CheckOutService {
    void scan(Product product);

    BigDecimal total();
}
