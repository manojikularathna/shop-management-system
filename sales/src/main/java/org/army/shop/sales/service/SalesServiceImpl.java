package org.army.shop.sales.service;

import org.army.shop.sales.bl.SalesServiceBL;
import org.army.shop.sales.to.SalesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "/inventory")
public class SalesServiceImpl {

	@Autowired
	SalesServiceBL salesServiceBL;
	
	@RequestMapping(value = "/sales", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity sellProducts(@RequestBody SalesRequest request) {
		String text = salesServiceBL.saveInventory(request);
		return new ResponseEntity<>(text, HttpStatus.OK); 
	}

	// @Autowired
	// InventoryServiceBL inventoryServiceBL;
	//
	// @RequestMapping(value = "/purchase", method = RequestMethod.POST,
	// consumes = MediaType.APPLICATION_JSON_VALUE, produces =
	// MediaType.APPLICATION_JSON_VALUE)
	// public BaseResponse purchaseProducts(@RequestBody PurchaseRequest
	// request) {
	// BaseResponse response = new BaseResponse();
	// Long id = inventoryServiceBL.saveInventory(request);
	// response.setStatus("SUCCESS");
	// return response;
	// }
	//
	//
	// @RequestMapping(value = "/supplierDetails", method = RequestMethod.POST,
	// consumes = MediaType.APPLICATION_JSON_VALUE, produces =
	// MediaType.APPLICATION_JSON_VALUE)
	// public void addSupplierDetails() {
	//
	// }
	//
	// @RequestMapping(value = "/productCategory", method = RequestMethod.POST,
	// consumes = MediaType.APPLICATION_JSON_VALUE, produces =
	// MediaType.APPLICATION_JSON_VALUE)
	// public BaseResponse addProductCategory(@RequestBody
	// ProductCategoryRequest request) {
	// BaseResponse response = new BaseResponse();
	// Long id = inventoryServiceBL.saveProductCategory(request);
	// response.setStatus("SUCCESS");
	// return response;
	// }
	//
	// @RequestMapping(value = "/product", method = RequestMethod.POST, consumes
	// = MediaType.APPLICATION_JSON_VALUE, produces =
	// MediaType.APPLICATION_JSON_VALUE)
	// public BaseResponse addProduct(@RequestBody ProductRequest request) {
	// BaseResponse response = new BaseResponse();
	// Long id = inventoryServiceBL.saveProduct(request);
	// response.setStatus("SUCCESS");
	// return response;
	// }
}