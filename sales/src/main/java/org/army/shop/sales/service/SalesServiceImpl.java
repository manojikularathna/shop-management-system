package org.army.shop.sales.service;

import org.army.shop.sales.bl.SalesServiceBL;
import org.army.shop.sales.to.SalesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/inventory")
public class SalesServiceImpl {

	@Autowired
	SalesServiceBL salesServiceBL;

}