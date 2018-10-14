package org.army.shop.inventory.to;

import java.util.List;

public class InventorySearchResponse {

//    private List<ItemCategoryTO> categories;
    private List<ItemBatchTO> items;

//    public List<ItemCategoryTO> getCategories() {
//        return categories;
//    }

//    public void setCategories(List<ItemCategoryTO> categories) {
//        this.categories = categories;
//    }

    public List<ItemBatchTO> getItems() {
        return items;
    }

    public void setItems(List<ItemBatchTO> items) {
        this.items = items;
    }
}
