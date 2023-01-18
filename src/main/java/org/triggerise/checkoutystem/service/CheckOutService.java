package org.triggerise.checkoutystem.service;

import java.math.BigDecimal;

public interface CheckOutService {
    void scan(String code);

    BigDecimal total();
}
