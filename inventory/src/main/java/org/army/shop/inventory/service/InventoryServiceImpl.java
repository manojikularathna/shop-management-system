package org.army.shop.inventory.service;

import org.army.base.common.to.BaseResponse;
import org.army.shop.inventory.api.InventoryService;
import org.army.shop.inventory.bl.InventoryBL;
import org.army.shop.inventory.to.InventoryAdjustmentRequest;
import org.army.shop.inventory.to.InventorySearchRequest;
import org.army.shop.inventory.to.InventorySearchResponse;
import org.army.shop.inventory.to.ItemCategoryTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/inventory")
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryBL inventoryBL;

    @RequestMapping(path = "/search", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public InventorySearchResponse search(@RequestBody InventorySearchRequest inventorySearch) {
        return inventoryBL.search(inventorySearch);
    }

    @RequestMapping(path = "/remove", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse remove(@RequestBody InventoryAdjustmentRequest inventoryAdjustment) {
        return inventoryBL.remove(inventoryAdjustment);
    }

    @RequestMapping(path = "/category/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse addItemCategory(@RequestBody ItemCategoryTO itemCategoryTO) {
        return inventoryBL.addItemCategory(itemCategoryTO);
    }

    @RequestMapping(path = "/category/update", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse updateItemCategory(@RequestBody ItemCategoryTO itemCategoryTO) {
        return inventoryBL.updateItemCategory(itemCategoryTO);
    }

    @RequestMapping(path = "/category/search", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemCategoryTO> getItemCategories() {
        return inventoryBL.getItemCategories();
    }
}
