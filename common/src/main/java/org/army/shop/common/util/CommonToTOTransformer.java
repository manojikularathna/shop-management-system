package org.army.shop.common.util;

import org.army.base.common.to.AddressTO;
import org.army.base.common.to.PrimaryContactInformationTO;
import org.army.base.common.to.SecondaryContactInformationTO;
import org.army.common.entity.Address;
import org.army.common.entity.PrimaryContactInformation;
import org.army.common.entity.SecondaryContactInformation;
import org.army.shop.common.entity.ItemQuantity;
import org.army.shop.common.entity.UnitPrice;
import org.army.shop.common.entity.Value;
import org.army.shop.common.to.ItemQuantityTO;
import org.army.shop.common.to.UnitPriceTO;
import org.army.shop.common.to.ValueDefinition;

public class CommonToTOTransformer {

    public static AddressTO toAddressTO(Address address) {
        AddressTO addressTO = new AddressTO();
        addressTO.setAddressLine1(address.getAddressLine1());
        addressTO.setAddressLine2(address.getAddressLine2());
        return addressTO;
    }

    public static PrimaryContactInformationTO toPrimaryContactInformationTO(PrimaryContactInformation primaryContactInformation) {
        PrimaryContactInformationTO primaryContactInformationTO = null;

        if (primaryContactInformation != null) {
            primaryContactInformationTO = new PrimaryContactInformationTO();

            if (primaryContactInformation.getAddress() != null) {
                primaryContactInformationTO.setAddress(toAddressTO(primaryContactInformation.getAddress()));
            }
            primaryContactInformationTO.setEmailAddress(primaryContactInformation.getEmailAddress());
            primaryContactInformationTO.setPhoneNumber(primaryContactInformation.getPhoneNumber());
        }

        return primaryContactInformationTO;
    }

    public static SecondaryContactInformationTO toSecondaryContactInformation(SecondaryContactInformation secondaryContactInformation) {
        SecondaryContactInformationTO secondaryContactInformationTO = new SecondaryContactInformationTO();

        return secondaryContactInformationTO;
    }

    public static ItemQuantityTO toItemQuantityTO(ItemQuantity itemQuantity) {
        ItemQuantityTO itemQuantityTO = null;

        if (itemQuantity != null) {
            itemQuantityTO = new ItemQuantityTO();
            itemQuantityTO.setUnit(itemQuantity.getUnit());
            itemQuantityTO.setQuantity(itemQuantity.getQuantity());
        }

        return itemQuantityTO;
    }

    public static UnitPriceTO toUnitPriceTO(UnitPrice unitPrice) {
        UnitPriceTO unitPriceTO = new UnitPriceTO();
        unitPriceTO.setUnit(unitPrice.getUnitType());
        unitPriceTO.setPrice(unitPrice.getPrice());

        return unitPriceTO;
    }

    public static ValueDefinition toValueDefinition(Value value) {
        ValueDefinition valueDefinition = null;

        if (value != null) {
            valueDefinition = new ValueDefinition();
            valueDefinition.setType(value.getType());
            valueDefinition.setValue(value.getValue());
        }

        return valueDefinition;
    }
}
