package org.army.shop.sales.bl;

import java.util.Date;

import org.army.shop.sales.adapter.Receipt;
import org.army.shop.sales.adapter.RequestAdapter;
import org.army.shop.sales.entity.Invoice;
import org.army.shop.sales.repository.InvoiceRepository;
import org.army.shop.sales.to.SalesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesServiceBL {

	@Autowired
	RequestAdapter requestAdapter;
	
	@Autowired
	Receipt receipt;

	//
	// @Autowired
	// ProductCategoryRepository productCategoryRepository;
	//
	@Autowired
	InvoiceRepository invoiceRepository;

	// @Autowired
	// InventoryRepository inventoryRepository;
	//
	// public Long saveProductCategory(ProductCategoryRequest request){
	// ProductCategory category =
	// requestAdapter.convertToProductCategory(request);
	// productCategoryRepository.save(category);
	// return category.getCategoryId();
	// }
	//
	// public Long saveProduct(ProductRequest request){
	// Product product = requestAdapter.convertToProduct(request);
	// productRepository.save(product);
	// return product.getProductId();
	// }
	//
	public String saveInventory(SalesRequest request) {
		Invoice invoice = requestAdapter.convertToInvoice(request);
		invoiceRepository.save(invoice);
		return receipt.generateReceipt(invoice);
		//return invoice.getInvoiceId();
	}
}
