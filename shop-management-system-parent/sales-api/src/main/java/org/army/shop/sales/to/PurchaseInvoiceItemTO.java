package org.army.shop.sales.to;

import org.army.shop.common.to.ItemQuantityTO;
import org.army.shop.common.to.ValueDefinition;

public class PurchaseInvoiceItemTO extends InvoiceItemTO {

    private Long itemBrandId;

    private ItemQuantityTO lowStockBoundary;

    private ValueDefinition profit;

    public Long getItemBrandId() {
        return itemBrandId;
    }

    public void setItemBrandId(Long itemBrandId) {
        this.itemBrandId = itemBrandId;
    }

    public ItemQuantityTO getLowStockBoundary() {
        return lowStockBoundary;
    }

    public void setLowStockBoundary(ItemQuantityTO lowStockBoundary) {
        this.lowStockBoundary = lowStockBoundary;
    }

    public ValueDefinition getProfit() {
        return profit;
    }

    public void setProfit(ValueDefinition profit) {
        this.profit = profit;
    }
}
