package org.army.shop.inventory.util;

import org.army.shop.common.util.CommonToTOTransformer;
import org.army.shop.inventory.entity.*;
import org.army.shop.inventory.to.*;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class InventoryToTOTransformer {

    public ItemBatchTO toItemBatchTO(ItemBatch itemBatch) {
        ItemBatchTO itemBatchTO = new ItemBatchTO();
        itemBatchTO.setItemBatchId(itemBatch.getItemBatchId());
        itemBatchTO.setItemBrand(toItemBrandTO(itemBatch.getItemBrand()));
        itemBatchTO.setLowStockBoundary(CommonToTOTransformer.toItemQuantityTO(itemBatch.getLowStockBoundary()));
        itemBatchTO.setPurchasedPrice(CommonToTOTransformer.toUnitPriceTO(itemBatch.getPurchasedPrice()));
        itemBatchTO.setProfit(CommonToTOTransformer.toValueDefinition(itemBatch.getProfit()));
        itemBatchTO.setStock(toItemBatchStockTO(itemBatch.getStock()));
        itemBatchTO.setSupplier(toSupplierTO(itemBatch.getSupplier()));

        return itemBatchTO;
    }

    public ItemBatchStockTO toItemBatchStockTO(ItemBatchStock itemBatchStock) {
        ItemBatchStockTO itemBatchStockTO = new ItemBatchStockTO();
        itemBatchStockTO.setItemBatchStockId(itemBatchStock.getItemBatchStockId());
        itemBatchStockTO.setRemainingQuantity(CommonToTOTransformer.toItemQuantityTO(itemBatchStock.getRemainingQuantity()));
        itemBatchStockTO.setSellingPrice(CommonToTOTransformer.toUnitPriceTO(itemBatchStock.getSellingPrice()));

        return itemBatchStockTO;
    }

    public ItemBrandTO toItemBrandTO(ItemBrand itemBrand) {
        ItemBrandTO itemBrandTO = new ItemBrandTO();
        itemBrandTO.setItemBrandId(itemBrand.getItemBrandId());
        itemBrandTO.setBrandName(itemBrand.getBrandName());
        itemBrandTO.setLowStockBoundary(CommonToTOTransformer.toItemQuantityTO(itemBrand.getLowStockBoundary()));
        itemBrandTO.setProfit(CommonToTOTransformer.toValueDefinition(itemBrand.getProfit()));
        itemBrandTO.setBatches(itemBrand.getBatches()
                .stream()
                .map(this::toItemBatchTO)
                .collect(Collectors.toList()));

        return itemBrandTO;
    }

    public SupplierTO toSupplierTO(Supplier supplier) {
        SupplierTO supplierTO = new SupplierTO();
        supplierTO.setSupplierId(supplier.getSupplierId());
        supplierTO.setName(supplier.getName());
        supplierTO.setPrimaryContactInfo(CommonToTOTransformer.toPrimaryContactInformationTO(supplier.getPrimaryContactInfo()));
        supplierTO.setSupplyingItems(supplier.getSupplyingItems()
                .stream()
                .map(this::toSupplyItemTO)
                .collect(Collectors.toList()));

        return supplierTO;
    }

    public SupplyItemTO toSupplyItemTO(SupplyItem supplyItem) {
        SupplyItemTO supplyItemTO = new SupplyItemTO();
        supplyItemTO.setSupplyItemId(supplyItem.getSupplyItemId());
        supplyItemTO.setItemBrand(this.toItemBrandTO(supplyItem.getItemBrand()));
        supplyItemTO.setMinQuantity(CommonToTOTransformer.toItemQuantityTO(supplyItem.getMinQuantity()));
        supplyItemTO.setMaxQuantity(CommonToTOTransformer.toItemQuantityTO(supplyItem.getMaxQuantity()));

        return supplyItemTO;
    }

    public ItemCategoryTO toItemCategoryTO(ItemCategory itemCategory) {
        ItemCategoryTO itemCategoryTO = new ItemCategoryTO();
        itemCategoryTO.setItemCategoryId(itemCategory.getItemCategoryId());
        itemCategoryTO.setDescription(itemCategory.getDescription());
        itemCategoryTO.setItemCategoryCode(itemCategory.getItemCategoryCode());
        itemCategoryTO.setLowStockBoundary(CommonToTOTransformer.toItemQuantityTO(itemCategory.getLowStockBoundary()));
        itemCategoryTO.setProfit(CommonToTOTransformer.toValueDefinition(itemCategory.getProfit()));

        return itemCategoryTO;
    }

}
