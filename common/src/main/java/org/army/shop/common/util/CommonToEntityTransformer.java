package org.army.shop.common.util;

import org.army.shop.common.entity.*;
import org.army.shop.common.to.*;

public class CommonToEntityTransformer {

    public static Address toAddress(AddressTO addressTO) {
        Address address = new Address();
        address.setAddressLine1(addressTO.getAddressLine1());
        address.setAddressLine2(addressTO.getAddressLine2());
        return address;
    }

    public static PrimaryContactInformation toPrimaryContactInformation(PrimaryContactInformationTO primaryContactInformationTO) {
        PrimaryContactInformation primaryContactInformation = new PrimaryContactInformation();

        if (primaryContactInformationTO.getAddress() != null) {
            primaryContactInformation.setAddress(toAddress(primaryContactInformationTO.getAddress()));
        }
        primaryContactInformation.setEmailAddress(primaryContactInformationTO.getEmailAddress());
        primaryContactInformation.setPhoneNumber(primaryContactInformationTO.getPhoneNumber());

        return primaryContactInformation;
    }

    public static SecondaryContactInformation toSecondaryContactInformation(SecondaryContactInformationTO secondaryContactInformationTO) {
        SecondaryContactInformation secondaryContactInformation = new SecondaryContactInformation();

        return secondaryContactInformation;
    }

    public static ItemQuantity toItemQuantity(ItemQuantityTO itemQuantityTO) {
        ItemQuantity itemQuantity = new ItemQuantity();
        itemQuantity.setUnit(itemQuantityTO.getUnit());
        itemQuantity.setQuantity(itemQuantityTO.getQuantity());

        return itemQuantity;
    }

    public static UnitPrice toUnitPrice(UnitPriceTO unitPriceTO) {
        UnitPrice unitPrice = new UnitPrice();
        unitPrice.setUnitType(unitPriceTO.getUnit());
        unitPrice.setPrice(unitPriceTO.getPrice());

        return unitPrice;
    }

    public static Value toValue(ValueDefinition valueDefinition) {
        Value value = new Value();
        value.setType(valueDefinition.getType());
        value.setValue(valueDefinition.getValue());

        return value;
    }
}
