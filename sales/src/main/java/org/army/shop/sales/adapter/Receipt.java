package org.army.shop.sales.adapter;

import java.math.BigDecimal;
import java.util.*;

import org.army.shop.sales.entity.Invoice;
import org.army.shop.sales.entity.InvoiceItem;
import org.springframework.stereotype.Service;

@Service
public class Receipt {
	private BigDecimal total = BigDecimal.ZERO;
	private Formatter f = new Formatter(System.out);

	public void printTitle() {
		f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
		f.format("%-15s %5s %10s\n", "----", "---", "-----");
	}

	public void print(String name, BigDecimal qty, BigDecimal price) {
		f.format("%-15.15s %5d %10.2f\n", name, qty, price);
		total = total.add(price);
	}

	public void printTotal() {
		f.format("%-15s %5s %10.2f\n", "Tax", "", total.multiply(BigDecimal.valueOf(0.06)));
		f.format("%-15s %5s %10s\n", "", "", "-----");
		f.format("%-15s %5s %10.2f\n", "Total", "", total.multiply(BigDecimal.valueOf(1.06)));
	}

	public String generateReceipt(Invoice invoice) {
		Receipt receipt = new Receipt();
		receipt.printTitle();

		if (invoice.getItems() != null) {
			invoice.getItems().forEach(product -> {
				receipt.print(product.getItem().getItemBrand().getCategory().getDescription(), product.getQuantity().getQuantity(),
						product.getPrice().getPrice());
			});

		}

		receipt.printTotal();
		String receiptText = f.toString();
		return receiptText;
	}
}