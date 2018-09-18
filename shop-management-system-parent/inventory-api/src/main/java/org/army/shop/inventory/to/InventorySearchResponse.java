package org.army.shop.inventory.to;

import java.util.List;

public class InventorySearchResponse {

    private List<ItemCategoryTO> categories;

    public List<ItemCategoryTO> getCategories() {
        return categories;
    }

    public void setCategories(List<ItemCategoryTO> categories) {
        this.categories = categories;
    }
}
