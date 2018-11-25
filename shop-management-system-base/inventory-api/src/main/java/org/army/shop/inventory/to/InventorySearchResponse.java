package org.army.shop.inventory.to;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class InventorySearchResponse {

//    private List<ItemCategoryTO> categories;

    private List<ItemBrandTO> brands;

    private List<ItemBatchTO> batches;

}
