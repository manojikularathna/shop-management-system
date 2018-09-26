package org.army.shop.sales.service;

import org.army.shop.common.to.BaseResponse;
import org.army.shop.sales.api.SalesService;
import org.army.shop.sales.bl.SalesServiceBL;
import org.army.shop.sales.to.CancelTransactionRequest;
import org.army.shop.sales.to.SalesCalculationResponse;
import org.army.shop.sales.to.SalesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/sales")
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesServiceBL salesServiceBL;

	@RequestMapping(path = "/calculate", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SalesCalculationResponse calculate(@RequestBody SalesRequest sales) {
		return salesServiceBL.calculate(sales);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse sell(@RequestBody SalesRequest sales) {
		return salesServiceBL.sell(sales);
	}

	@RequestMapping(path = "/cancel", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse cancelSale(@RequestBody CancelTransactionRequest cancel) {
		return salesServiceBL.cancelSale(cancel);
	}
}