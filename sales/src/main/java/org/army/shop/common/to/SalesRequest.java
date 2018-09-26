package org.army.shop.common.to;

import org.army.shop.sales.entity.InvoiceItem;

import java.math.BigDecimal;
import java.util.List;

public class SalesRequest extends BaseRequest{
	
	private List<InvoiceItem> items;
	
	private BigDecimal total;

	public List<InvoiceItem> getItems() {
		return items;
	}

	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
}
