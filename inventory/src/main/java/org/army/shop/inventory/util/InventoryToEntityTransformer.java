package org.army.shop.inventory.util;

import org.army.common.dao.CommonDAO;
import org.army.shop.common.util.CommonToEntityTransformer;
import org.army.shop.inventory.entity.*;
import org.army.shop.inventory.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class InventoryToEntityTransformer {

    @Autowired
    private CommonDAO commonDAO;

    public Supplier toSupplier(SupplierTO supplierTO) {
        Supplier supplier = new Supplier();
        mergeSupplier(supplier, supplierTO);

        return supplier;
    }

    public void mergeSupplier(Supplier supplier, SupplierTO supplierTO) {
        supplier.setName(supplierTO.getName());
        supplier.setPrimaryContactInfo(CommonToEntityTransformer.toPrimaryContactInformation(supplierTO.getPrimaryContactInfo()));
        supplier.setSupplyingItems(supplierTO.getSupplyingItems()
                .stream()
                .map(this::toSupplyItem)
                .collect(Collectors.toList()));
    }

    public SupplyItem toSupplyItem(SupplyItemTO supplyItemTO) {
        SupplyItem supplyItem;
        if (supplyItemTO.getSupplyItemId() != null) {
            supplyItem = commonDAO.get(SupplyItem.class, supplyItemTO.getSupplyItemId());
        } else {
            supplyItem = new SupplyItem();
        }
        mergeSupplyItem(supplyItem, supplyItemTO);

        return supplyItem;
    }

    public void mergeSupplyItem(SupplyItem supplyItem, SupplyItemTO supplyItemTO) {
        supplyItem.setItemBrand(commonDAO.get(ItemBrand.class, supplyItemTO.getSupplyItemId()));
        supplyItem.setMinQuantity(CommonToEntityTransformer.toItemQuantity(supplyItemTO.getMinQuantity()));
        supplyItem.setMaxQuantity(CommonToEntityTransformer.toItemQuantity(supplyItemTO.getMaxQuantity()));
    }

    public ItemBatch toItemBatch(InventorySupplyItemBatchTO itemBatchTO) {
        ItemBatch itemBatch = new ItemBatch();
        itemBatch.setItemBrand(commonDAO.get(ItemBrand.class, itemBatchTO.getItemBrandId()));
        itemBatch.setBranchId(itemBatchTO.getBranchId());
        itemBatch.setPurchasedDate(new Date());
        itemBatch.setPurchasedPrice(CommonToEntityTransformer.toUnitPrice(itemBatchTO.getPurchasedPrice()));
        itemBatch.setPurchasedQuantity(CommonToEntityTransformer.toItemQuantity(itemBatchTO.getPurchasedQuantity()));
        itemBatch.setStock(new ItemBatchStock());
        if (itemBatchTO.getLowStockBoundary() != null) {
            itemBatch.setLowStockBoundary(CommonToEntityTransformer.toItemQuantity(itemBatchTO.getLowStockBoundary()));
        }
        if (itemBatchTO.getProfit() != null) {
            itemBatch.setProfit(CommonToEntityTransformer.toValue(itemBatchTO.getProfit()));
        }

        return itemBatch;
    }

    public ItemCategory toItemCategory(ItemCategoryTO itemCategoryTO) {
        ItemCategory itemCategory = new ItemCategory();
        mergeItemCategory(itemCategory, itemCategoryTO);

        return itemCategory;
    }

    public void mergeItemCategory(ItemCategory itemCategory, ItemCategoryTO itemCategoryTO) {
        itemCategory.setDescription(itemCategoryTO.getDescription());
        itemCategory.setItemCategoryCode(itemCategoryTO.getItemCategoryCode());
        if (itemCategoryTO.getLowStockBoundary() != null) {
            itemCategory.setLowStockBoundary(CommonToEntityTransformer.toItemQuantity(itemCategoryTO.getLowStockBoundary()));
        }
        if (itemCategoryTO.getProfit() != null) {
            itemCategory.setProfit(CommonToEntityTransformer.toValue(itemCategoryTO.getProfit()));
        }
    }

    public ItemBrand toItemBrand(ItemBrandTO itemBrandTO) {
        ItemBrand itemBrand = new ItemBrand();
        mergeItemBrand(itemBrand, itemBrandTO);
        return itemBrand;
    }

    public void mergeItemBrand(ItemBrand itemBrand, ItemBrandTO itemBrandTO) {

        itemBrand.setBrandName(itemBrandTO.getBrandName());
        itemBrand.setCategory(commonDAO.get(ItemCategory.class, itemBrandTO.getCategory().getItemCategoryId()));
        if (itemBrandTO.getLowStockBoundary() != null) {
            itemBrand.setLowStockBoundary(CommonToEntityTransformer.toItemQuantity(itemBrandTO.getLowStockBoundary()));
        }
        if (itemBrandTO.getProfit() != null) {
            itemBrand.setProfit(CommonToEntityTransformer.toValue(itemBrandTO.getProfit()));
        }

    }
}
