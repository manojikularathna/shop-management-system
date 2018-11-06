package org.army.shop.common;

public interface CommonConstants {

    interface ValueType {
        String VALUE = "VALUE";
        String PERCENTAGE = "PERCENTAGE";
    }

    interface Status {
        String ACTIVE = "ACTIVE";
        String CANCELLED = "CANCELLED";
    }

    interface TransactionTypeCode {
        String SALES = "SALES";
        String PURCHASE = "PURCHASE";
    }
}
