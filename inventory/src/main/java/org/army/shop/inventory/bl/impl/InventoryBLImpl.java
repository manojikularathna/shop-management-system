package org.army.shop.inventory.bl.impl;

import org.army.shop.common.conf.ApplicationConfiguration;
import org.army.shop.common.dao.CommonDAO;
import org.army.shop.common.to.BaseResponse;
import org.army.shop.inventory.bl.InventoryBL;
import org.army.shop.inventory.dao.InventoryDAO;
import org.army.shop.inventory.entity.ItemBatch;
import org.army.shop.inventory.entity.ItemBatchStock;
import org.army.shop.inventory.entity.ItemCategory;
import org.army.shop.inventory.to.*;
import org.army.shop.inventory.util.InventoryConstants;
import org.army.shop.inventory.util.InventoryToEntityTransformer;
import org.army.shop.inventory.util.InventoryToTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryBLImpl implements InventoryBL {

    @Autowired
    private ApplicationConfiguration configuration;

    @Autowired
    private InventoryDAO inventoryDAO;

    @Autowired
    private CommonDAO commonDAO;

    @Override
    public InventorySearchResponse search(InventorySearchRequest inventorySearch) {

        List<String> keywords = Arrays
                .stream(inventorySearch.getGenericCriterion().split(InventoryConstants.ITEM_SEARCH_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

        InventorySearchTO inventorySearchTO = new InventorySearchTO();
        inventorySearchTO.setBranchId(inventorySearch.getBranchId());
        inventorySearchTO.setItemCategoryCode(keywords);
        inventorySearchTO.setBrandName(keywords);

        List<ItemBatch> items = inventoryDAO.search(inventorySearchTO);

        List<ItemBatchTO> tos = items
                .stream()
                .map(InventoryToTOTransformer::toItemBatchTO)
                .collect(Collectors.toList());

        InventorySearchResponse response = new InventorySearchResponse();
        response.setItems(tos);

        return response;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public BaseResponse remove(InventoryAdjustmentRequest inventoryAdjustment) {

        inventoryAdjustment.getItems()
                .forEach(adjustment -> {

                    ItemBatch itemBatch = commonDAO.get(ItemBatch.class, adjustment.getItemBatchId());
                    ItemBatchStock itemBatchStock = itemBatch.getStock();
                    itemBatchStock.getRemainingQuantity().setQuantity(
                            itemBatchStock.getRemainingQuantity().getQuantity().subtract(adjustment.getQuantity().getQuantity()));

                    commonDAO.update(itemBatch);

                });

        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public BaseResponse addItemCategory(ItemCategoryTO itemCategoryTO) {

        ItemCategory itemCategory = InventoryToEntityTransformer.toItemCategory(itemCategoryTO);
        itemCategory = commonDAO.add(itemCategory);

        BaseResponse response = new BaseResponse();
        response.setSuccess(true);
        return response;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public BaseResponse updateItemCategory(ItemCategoryTO itemCategoryTO) {
//        TODO
        return null;
    }

    public List<ItemCategoryTO> getItemCategories() {
        List<ItemCategory> suppliers = commonDAO.get(ItemCategory.class);

        List<ItemCategoryTO> supplierTOs = suppliers
                .stream()
                .map(InventoryToTOTransformer::toItemCategoryTO)
                .collect(Collectors.toList());

        return supplierTOs;
    }
}
