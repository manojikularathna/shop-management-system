package org.army.shop.sales.service;

import org.army.shop.sales.api.SalesService;
import org.army.shop.sales.bl.SalesServiceBL;
import org.army.shop.common.to.BaseResponse;
import org.army.shop.common.to.CancelTransactionRequest;
import org.army.shop.common.to.SalesCalculationResponse;
import org.army.shop.common.to.SalesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/sale")
public class SalesServiceImpl implements SalesService {

	@Autowired
	SalesServiceBL salesServiceBL;

	@RequestMapping(path = "/calculate", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SalesCalculationResponse calculate(@RequestBody SalesRequest sales) {
		return null;
	}

	@RequestMapping(path = "/", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse sale(@RequestBody SalesRequest sales) {
		return null;
	}

	@RequestMapping(path = "/cancel", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse cancelSale(@RequestBody CancelTransactionRequest cancel) {
		return null;
	}
}