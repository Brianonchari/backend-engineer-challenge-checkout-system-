package org.triggerise.checkoutystem.service;

import java.math.BigDecimal;

public interface CheckOutService {
    CheckOutService scan(String code);

    BigDecimal total();

}
