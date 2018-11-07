package org.army.shop.sales.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface SalesDAO {

    BigDecimal totalSales(LocalDate date);

}
