package org.army.shop.sales.adapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.army.shop.sales.entity.Invoice;
import org.army.shop.sales.entity.InvoiceItem;
import org.army.shop.sales.to.SalesRequest;
import org.springframework.stereotype.Service;

@Service
public class RequestAdapter {

	public Invoice convertToInvoice(SalesRequest request) {
		Invoice invoice = new Invoice();
		invoice.setItems(request.getItems());
		invoice.setTotal(request.getTotal());
		invoice.setDate(new Date());
		return invoice;
	}

	// public Product convertToProduct(ProductRequest request) {
	// Product product = new Product();
	// product.setProductName(request.getProductName());
	// product.setCompany(request.getCompany());
	// product.setBrandName(request.getBrandName());
	// return product;
	// }
	//
	// public Inventory convertToInventory(PurchaseRequest request) {
	// Inventory inventory = new Inventory();
	// inventory.setMeasuringUnit(request.getMeasuringUnit());
	// inventory.setProductId(new Long(request.getProductId()));
	// inventory.setQuantity(request.getQuantity());
	// inventory.setReceiptNumber(request.getReceiptNumber());
	// inventory.setTotalCost(new Long(request.getTotalCost()));
	// inventory.setUnitPrice(new Long(request.getUnitPrice()));
	// inventory.setReceiptDate(new Date(request.getReceiptDate()));
	// inventory.setStatus("OPN");
	// return inventory;
	// }

	// public Sales convertToSales(SalesRequest request) {
	// Sales sales = new Sales();
	// if (request.getSalesDetails() != null) {
	// Set<ProductWiseSales> productWiseSales = new LinkedHashSet<>();
	// request.getSalesDetails().forEach(product -> {
	// ProductWiseSales sale = new ProductWiseSales();
	// // service.setMember(member);
	// sale.setQuantity(new Integer(product.getQuantity()));
	// productWiseSales.add(sale);
	// });
	// sales.setProductWiseSales(productWiseSales);
	// }
	// return null;
	//
	// }
}
