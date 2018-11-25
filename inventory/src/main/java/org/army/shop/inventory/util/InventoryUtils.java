package org.army.shop.inventory.util;

import org.army.shop.common.CommonConstants;
import org.army.shop.common.entity.UnitPrice;
import org.army.shop.common.entity.Value;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class InventoryUtils {

    public static UnitPrice getSellingPrice(UnitPrice purchasedPrice, Value profit) {

        UnitPrice sellingPrice = new UnitPrice();
        sellingPrice.setUnitType(purchasedPrice.getUnitType());

        switch (profit.getType()) {
            case CommonConstants.ValueType.VALUE:
                sellingPrice.setPrice(purchasedPrice.getPrice().add(profit.getValue()));
                break;
            case CommonConstants.ValueType.PERCENTAGE:
                sellingPrice.setPrice(purchasedPrice.getPrice()
                        .multiply(BigDecimal.ONE.add(profit.getValue()))
                        .setScale(2, RoundingMode.CEILING));
                break;
        }

        return sellingPrice;
    }

}
