package org.army.shop.inventory.util;

import org.army.shop.common.util.CommonToTOTransformer;
import org.army.shop.inventory.entity.*;
import org.army.shop.inventory.to.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class InventoryToTOTransformer {

    public ItemBatchTO toItemBatchTO(ItemBatch itemBatch) {
        ItemBatchTO itemBatchTO = new ItemBatchTO();
        return toItemBatchTO(itemBatchTO, itemBatch);
    }

    public ItemBrandTO toItemBrandTO(ItemBrand itemBrand) {
        ItemBrandTO itemBrandTO = new ItemBrandTO();
        return toItemBrandTO(itemBrandTO, itemBrand);
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

    public SupplierTO toSupplierTO(Supplier supplier) {
        SupplierTO supplierTO = new SupplierTO();
        return toSupplierTO(supplierTO, supplier);
    }

    private ItemBatchTO toItemBatchTO(ItemBatchTO itemBatchTO, ItemBatch itemBatch) {
        itemBatchTO.setItemBatchId(itemBatch.getItemBatchId());
        itemBatchTO.setBranchId(itemBatch.getBranchId());
        if (itemBatchTO.getItemBrand() == null) {
            ItemBrandTO itemBrandTO = new ItemBrandTO();
            itemBrandTO.setBatches(new ArrayList<>());
            itemBatchTO.setItemBrand(toItemBrandTO(itemBrandTO, itemBatch.getItemBrand()));
        }
        itemBatchTO.setLowStockBoundary(CommonToTOTransformer.toItemQuantityTO(itemBatch.getLowStockBoundary()));
        itemBatchTO.setPurchasedPrice(CommonToTOTransformer.toUnitPriceTO(itemBatch.getPurchasedPrice()));
        itemBatchTO.setProfit(CommonToTOTransformer.toValueDefinition(itemBatch.getProfit()));
        if (itemBatchTO.getStock() == null) {
            ItemBatchStockTO itemBatchStockTO = new ItemBatchStockTO();
            itemBatchStockTO.setBatch(new ItemBatchTO());
            itemBatchTO.setStock(toItemBatchStockTO(itemBatchStockTO, itemBatch.getStock()));
        }
        itemBatchTO.setSupplier(toSupplierTO(itemBatch.getSupplier()));

        return itemBatchTO;
    }

    public SupplierTO toSupplierTO(SupplierTO supplierTO, Supplier supplier) {
        supplierTO.setSupplierId(supplier.getSupplierId());
        supplierTO.setName(supplier.getName());
        supplierTO.setPrimaryContactInfo(CommonToTOTransformer.toPrimaryContactInformationTO(supplier.getPrimaryContactInfo()));
        supplierTO.setSupplyingItems(supplier.getSupplyingItems()
                .stream()
                .map(supplyItem ->  {
                    SupplyItemTO supplyItemTO = new SupplyItemTO();
                    return toSupplyItemTO(supplyItemTO, supplyItem);
                })
                .collect(Collectors.toList()));

        return supplierTO;
    }

    private ItemBatchStockTO toItemBatchStockTO(ItemBatchStockTO itemBatchStockTO, ItemBatchStock itemBatchStock) {
        itemBatchStockTO.setItemBatchStockId(itemBatchStock.getItemBatchStockId());
        itemBatchStockTO.setRemainingQuantity(CommonToTOTransformer.toItemQuantityTO(itemBatchStock.getRemainingQuantity()));
        itemBatchStockTO.setSellingPrice(CommonToTOTransformer.toUnitPriceTO(itemBatchStock.getSellingPrice()));

        return itemBatchStockTO;
    }

    private ItemBrandTO toItemBrandTO(ItemBrandTO itemBrandTO, ItemBrand itemBrand) {
        itemBrandTO.setItemBrandId(itemBrand.getItemBrandId());
        itemBrandTO.setBrandName(itemBrand.getBrandName());
        itemBrandTO.setLowStockBoundary(CommonToTOTransformer.toItemQuantityTO(itemBrand.getLowStockBoundary()));
        itemBrandTO.setProfit(CommonToTOTransformer.toValueDefinition(itemBrand.getProfit()));

        if (itemBrandTO.getBatches() == null) {
            itemBrandTO.setBatches(itemBrand.getBatches()
                    .stream()
                    .map(itemBatch -> {
                        ItemBatchTO itemBatchTO = new ItemBatchTO();
                        itemBatchTO.setItemBrand(new ItemBrandTO());
                        return toItemBatchTO(itemBatchTO, itemBatch);
                    })
                    .collect(Collectors.toList()));
        }

        return itemBrandTO;
    }



    private SupplyItemTO toSupplyItemTO(SupplyItemTO supplyItemTO, SupplyItem supplyItem) {
        supplyItemTO.setSupplyItemId(supplyItem.getSupplyItemId());

        ItemBrandTO itemBrandTO = new ItemBrandTO();
        supplyItemTO.setItemBrand(toItemBrandTO(itemBrandTO, supplyItem.getItemBrand()));

        supplyItemTO.setMinQuantity(CommonToTOTransformer.toItemQuantityTO(supplyItem.getMinQuantity()));
        supplyItemTO.setMaxQuantity(CommonToTOTransformer.toItemQuantityTO(supplyItem.getMaxQuantity()));

        return supplyItemTO;
    }

}
