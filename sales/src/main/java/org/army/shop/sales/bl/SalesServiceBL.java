package org.army.shop.sales.bl;

import org.army.shop.sales.adapter.RequestAdapter;
import org.army.shop.sales.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesServiceBL {

	@Autowired
	RequestAdapter requestAdapter;

	@Autowired
	InvoiceRepository invoiceRepository;


}
